package fr.cinquin.andy.festixapi.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Festival {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "ID", updatable = false, nullable = false)
    private UUID id;
    @Column(name = "TITLE", nullable = false)
    private String title;
    @Column(name = "DESCRIPTION", nullable = false)
    private String description;
    @Column(name = "PHOTO_URL", nullable = false)
    private String photoUrl;
    @Column(name = "DATE_START", nullable = false)
    private LocalDate dateStart;
    @Column(name = "DATE_END")
    private LocalDate dateEnd;
    @OneToMany(mappedBy = "festival", orphanRemoval = true)
    @JsonManagedReference
    @ToString.Exclude
    private Set<Event> events;
}
