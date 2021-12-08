package fr.cinquin.andy.festixapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Authorities {
    @Id
    @Column(name = "ID", nullable = false)
    @SequenceGenerator(name = "S_AUTHORITIES", sequenceName = "S_AUTHORITIES", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_AUTHORITIES")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
    @JsonBackReference
    private Users username;

    @ManyToOne
    @JoinColumn(name = "authority", referencedColumnName = "authority")
    @JsonBackReference
    private Authority authority;
}
