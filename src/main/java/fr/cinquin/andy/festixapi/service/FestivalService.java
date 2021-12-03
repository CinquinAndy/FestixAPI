package fr.cinquin.andy.festixapi.service;

import fr.cinquin.andy.festixapi.model.Festival;

import java.util.Collection;
import java.util.UUID;

public interface FestivalService {
    Festival create(Festival festival);
    Collection<Festival> list(int limit);
    Festival get(UUID uuid);
    Festival update(Festival festival);
    Boolean delete(UUID uuid);
}
