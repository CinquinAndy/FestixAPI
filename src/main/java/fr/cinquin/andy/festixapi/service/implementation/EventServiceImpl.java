package fr.cinquin.andy.festixapi.service.implementation;

import fr.cinquin.andy.festixapi.dao.repository.EventRepository;
import fr.cinquin.andy.festixapi.dto.EventDto;
import fr.cinquin.andy.festixapi.mapper.EventMapper;
import fr.cinquin.andy.festixapi.model.Event;
import fr.cinquin.andy.festixapi.service.EventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.UUID;

@Transactional
@Service
@Slf4j
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;

    private final EventMapper mapper = Mappers.getMapper(EventMapper.class);

    @Override
    public Event create(EventDto eventDto) {
        Event event = mapper.map(eventDto);
        return eventRepository.save(event);
    }

    @Override
    public Collection<Event> list(int limit) {
        return eventRepository.findAll(PageRequest.of(0, limit)).toList();
    }

    @Override
    public Event get(String uuid) {
        return eventRepository.existsById(UUID.fromString(uuid)) ? eventRepository.getById(UUID.fromString(uuid)) : null;
    }

    @Override
    public Collection<Event> byfestival(String uuid) {
        return eventRepository.findAllByFestival(UUID.fromString(uuid));
    }

    @Override
    public Event update(EventDto eventDto) {
        Event event = mapper.map(eventDto);
        return eventRepository.save(event);
    }

    @Override
    public Boolean delete(String uuid) {
        Boolean exists = eventRepository.existsById(UUID.fromString(uuid)) ? Boolean.TRUE : Boolean.FALSE;
        if(exists == Boolean.TRUE) {
            eventRepository.delete(eventRepository.getById(UUID.fromString(uuid)));
        }
        return exists;
    }
}
