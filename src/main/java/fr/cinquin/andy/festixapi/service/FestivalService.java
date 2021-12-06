package fr.cinquin.andy.festixapi.service;

import fr.cinquin.andy.festixapi.model.Festival;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.UUID;

@Service
@Transactional
public interface FestivalService {
    Festival create(Festival festival);
    Collection<Festival> list(int limit);
    Festival get(UUID uuid);
    Festival update(Festival festival);
    Boolean delete(UUID uuid);
}
