package fr.cinquin.andy.festixapi.service.implementation;

import fr.cinquin.andy.festixapi.model.Event;
import fr.cinquin.andy.festixapi.service.EventService;
import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.UUID;

@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    @Override
    public Event create(Event event) {
        return null;
    }

    @Override
    public Collection<Event> list(int limit) {
        return null;
    }

    @Override
    public Event get(UUID uuid) {
        return null;
    }

    @Override
    public Event update(Event event) {
        return null;
    }

    @Override
    public Boolean delete(UUID uuid) {
        return null;
    }
}
