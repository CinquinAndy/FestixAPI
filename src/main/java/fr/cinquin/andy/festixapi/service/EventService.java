package fr.cinquin.andy.festixapi.service;

import fr.cinquin.andy.festixapi.model.Event;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.UUID;

@Service
@Transactional
public interface EventService {
    Event create(Event event);
    Collection<Event> list(int limit);
    Event get(UUID uuid);
    Event update(Event event);
    Boolean delete(UUID uuid);
}
