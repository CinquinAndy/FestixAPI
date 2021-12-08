package fr.cinquin.andy.festixapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Users implements UserDetails {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    @Column(unique = true)
    private String username;
    private String firstname;
    private String lastname;
    private String password;
    @Column(unique = true)
    private String email;
    private boolean enabled;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "USER_PROFIL", joinColumns = @JoinColumn(name = "USER_ID"), inverseJoinColumns = @JoinColumn(name = "PROFIL_ID"))
    @JsonBackReference
    @ToString.Exclude
    private Set<Profil> profils;

    public List<String> getRoles(){
        return getProfils().stream()
                .map(Profil::getCode)
                .map(profil -> "ROLE_"+profil)
                .collect(Collectors.toList());
    }

    @Transient
    public String getFullName() {
        return String.format("%s %s", firstname, lastname);
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.commaSeparatedStringToAuthorityList(
                String.join(",", getRoles())
        );
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

//    public boolean isCredentialsExpired() {
//        boolean mdpIsExpired = getDateMajMdp() == null || getDateMajMdp().plusMonths(6).isBefore(LocalDateTime.now());
//        boolean hasProfilWebService = getUtilisateur().getUtilisateurProfils().stream().anyMatch(u -> u.getProfil().getCode().equals(Role.WEB_SERVICE));
//        return mdpIsExpired && !hasProfilWebService;
//    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
