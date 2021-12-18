package fr.cinquin.andy.festixapi.dao.repository;

import fr.cinquin.andy.festixapi.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.UUID;

@Repository
public interface EventRepository extends JpaRepository<Event, UUID> {
    @Query(value = "SELECT * FROM public.event e where e.festival_id=?1 ORDER BY e.datetime ASC ", nativeQuery = true)
    Collection<Event>  findAllByFestival(UUID festivalId);
}
