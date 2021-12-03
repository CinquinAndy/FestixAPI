package fr.cinquin.andy.festixapi.service.implementation;

import fr.cinquin.andy.festixapi.model.Festival;
import fr.cinquin.andy.festixapi.service.FestivalService;
import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.UUID;

@RequiredArgsConstructor
public class FestivalServiceImpl implements FestivalService {
    @Override
    public Festival create(Festival festival) {
        return null;
    }

    @Override
    public Collection<Festival> list(int limit) {
        return null;
    }

    @Override
    public Festival get(UUID uuid) {
        return null;
    }

    @Override
    public Festival update(Festival festival) {
        return null;
    }

    @Override
    public Boolean delete(UUID uuid) {
        return null;
    }
}
