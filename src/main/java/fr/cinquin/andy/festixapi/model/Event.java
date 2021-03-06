package fr.cinquin.andy.festixapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

//@Table(name = "EVENT")
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "DATETIME")
    private LocalDateTime dateTime;
    @ManyToOne
    @JoinColumn(name = "FESTIVAL_ID",referencedColumnName = "ID")
    @JsonBackReference
    private Festival festival;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "EVENT_ARTIST", joinColumns = @JoinColumn(name = "EVENT_ID"), inverseJoinColumns = @JoinColumn(name = "ARTIST_ID"))
//    @JsonBackReference
    @JsonManagedReference

//    @ToString.Exclude
    private Set<Artist> artists;
    @Column(name = "ARTISTENAVANT")
    private String artistEnAvant;
}
