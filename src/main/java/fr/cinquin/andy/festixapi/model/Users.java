package fr.cinquin.andy.festixapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

//implements UserDetails
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Users {
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
    @JoinTable(name = "USER_ROLE", joinColumns = @JoinColumn(name = "USER_ID"), inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
    @JsonBackReference
    @ToString.Exclude
    private Set<Role> roles;
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<String> liste = new ArrayList<>();
//        for (Role r:roles) {
//            liste.add(r.getRole());
//        }
//        return AuthorityUtils.commaSeparatedStringToAuthorityList(
//                String.join(",", liste)
//        );
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return username;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return enabled;
//    }
}
