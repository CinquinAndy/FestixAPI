package fr.cinquin.andy.festixapi.service;

import fr.cinquin.andy.festixapi.dto.EventDto;
import fr.cinquin.andy.festixapi.model.Event;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
@Transactional
public interface EventService {
    Event create(EventDto event);
    Collection<Event> list(int limit);
    Event get(String uuid);
    Collection<Event> byfestival(String uuid);
    Event update(EventDto event);
    Boolean delete(String uuid);
}
