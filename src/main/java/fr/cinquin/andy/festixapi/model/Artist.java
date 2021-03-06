package fr.cinquin.andy.festixapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

//@Table(name = "ARTIST")
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Artist {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "ID", updatable = false, nullable = false)
    private UUID id;
    @Column(name = "ARTIST_NAME", nullable = false)
    private String artistName;
    @Column(name = "DESCRIPTION", nullable = false, columnDefinition = "text")
    private String description;
    @Column(name = "MUSIC_STYLE", nullable = false)
    private String musicStyle;
    @Column(name = "PHOTO_URL", nullable = false, length = 2048)
    private String photoUrl;
    @ManyToMany(mappedBy = "artists", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
//    @JsonManagedReference
    @JsonBackReference
//    @ToString.Exclude
    private Set<Event> events;
}
