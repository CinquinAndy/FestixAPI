package fr.cinquin.andy.festixapi.service;

import fr.cinquin.andy.festixapi.dto.FestivalDto;
import fr.cinquin.andy.festixapi.model.Festival;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
@Transactional
public interface FestivalService {
    Festival create(FestivalDto festival);
    Collection<Festival> list(int limit);
    Festival get(String uuid);
    Festival update(FestivalDto festival);
    Boolean delete(String uuid);
}
