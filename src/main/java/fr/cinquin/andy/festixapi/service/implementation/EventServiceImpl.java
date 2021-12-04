package fr.cinquin.andy.festixapi.service.implementation;

import fr.cinquin.andy.festixapi.model.Event;
import fr.cinquin.andy.festixapi.dao.repository.EventRepository;
import fr.cinquin.andy.festixapi.service.EventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.UUID;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;

    @Override
    public Event create(Event event) {
        log.info("Create event... {}", event.getTitle());
        return eventRepository.save(event);
    }

    @Override
    public Collection<Event> list(int limit) {
        log.info("List event... limit : {}", limit);
        return eventRepository.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public Event get(UUID uuid) {
        log.info("get Event... {}", uuid);
        return eventRepository.getById(uuid);
    }

    @Override
    public Event update(Event event) {
        log.info("Update event... {}", event.getTitle());
        return eventRepository.save(event);
    }

    @Override
    public Boolean delete(UUID uuid) {
        log.info("delete Event... {}", uuid);
        eventRepository.deleteById(uuid);
        return Boolean.TRUE;
    }
}
