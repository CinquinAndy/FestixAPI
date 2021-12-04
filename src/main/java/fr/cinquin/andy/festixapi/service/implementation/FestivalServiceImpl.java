package fr.cinquin.andy.festixapi.service.implementation;

import fr.cinquin.andy.festixapi.model.Festival;
import fr.cinquin.andy.festixapi.dao.repository.FestivalRepository;
import fr.cinquin.andy.festixapi.service.FestivalService;
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
public class FestivalServiceImpl implements FestivalService {
    private final FestivalRepository festivalRepository;

    @Override
    public Festival create(Festival festival) {
        log.info("Create festival... {}", festival.getTitle());
        return festivalRepository.save(festival);
    }

    @Override
    public Collection<Festival> list(int limit) {
        log.info("List festival... limit : {}", limit);
        return festivalRepository.findAll(PageRequest.of(0, limit)).toList();
    }

    @Override
    public Festival get(UUID uuid) {
        log.info("get Festival... {}", uuid);
        return festivalRepository.getById(uuid);
    }

    @Override
    public Festival update(Festival festival) {
        log.info("Update festival... {}", festival.getTitle());
        return festivalRepository.save(festival);
    }

    @Override
    public Boolean delete(UUID uuid) {
        log.info("delete Festival... {}", uuid);
        festivalRepository.deleteById(uuid);
        return Boolean.TRUE;
    }
}
