package fr.cinquin.andy.festixapi.dao.repository;

import fr.cinquin.andy.festixapi.model.Artist;
import fr.cinquin.andy.festixapi.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.UUID;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, UUID> {
    @Query(value = "SELECT a.id,a.artist_name,a.description,a.music_style,a.photo_url FROM public.artist a join public.event_artist ea on a.id = ea.artist_id join public.event e ON e.id = ea.event_id where ea.event_id=?1 order by a.artist_name asc;" , nativeQuery = true)
    Collection<Artist> findAllByEvents(UUID eventId);
}
