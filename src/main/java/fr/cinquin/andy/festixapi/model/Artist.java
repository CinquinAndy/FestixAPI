package fr.cinquin.andy.festixapi.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

//@Table(name = "ARTIST")
@Entity
@Getter
@Setter
@ToString
public class Artist {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "ID", updatable = false, nullable = false)
    private UUID id;
    @Column(name = "ARTIST_NAME", nullable = false)
    private String artistName;
    @Column(name = "DESCRIPTION", nullable = false)
    private String description;
    @Column(name = "MUSIC_STYLE", nullable = false)
    private String musicStyle;
    @Column(name = "PHOTO_URL", nullable = false)
    private String photoUrl;
    @ManyToMany(mappedBy = "artists")
    @ToString.Exclude
    private Set<Event> events;
}
