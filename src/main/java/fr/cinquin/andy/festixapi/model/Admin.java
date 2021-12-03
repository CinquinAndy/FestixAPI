package fr.cinquin.andy.festixapi.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

//@Table(name = "ADMIN")
@Entity
@Getter
@Setter
@ToString
public class Admin {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    private String firstname;
    private String lastname;
    private String email;
    private boolean isValidated;
}
