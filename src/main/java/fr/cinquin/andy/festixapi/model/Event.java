package fr.cinquin.andy.festixapi.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

//@Table(name = "EVENT")
//@Entity
@Getter
@Setter
@ToString
public class Event {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "DATETIME")
    private LocalDateTime dateTime;
    @Column(name = "FESTIVAL_ID")
    private Festival festival;
    //    @Column(name = "ARTISTS")
    @ManyToMany
    @JoinTable(name = "EVENT_ARTIST",
            joinColumns = @JoinColumn(name = "EVENT_ID"),
            inverseJoinColumns = @JoinColumn(name = "ARTIST_ID")
    )
    private Set<Artist> artists;
}
