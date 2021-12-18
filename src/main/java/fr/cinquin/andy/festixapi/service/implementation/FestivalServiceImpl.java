package fr.cinquin.andy.festixapi.service.implementation;

import fr.cinquin.andy.festixapi.dao.repository.FestivalRepository;
import fr.cinquin.andy.festixapi.dto.FestivalDto;
import fr.cinquin.andy.festixapi.mapper.FestivalMapper;
import fr.cinquin.andy.festixapi.model.Festival;
import fr.cinquin.andy.festixapi.service.FestivalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Transactional
@Service
@Slf4j
@RequiredArgsConstructor
public class FestivalServiceImpl implements FestivalService {
    private final FestivalRepository festivalRepository;

    private final FestivalMapper mapper = Mappers.getMapper(FestivalMapper.class);

    @Override
    public Festival create(FestivalDto festivalDto) {
        Festival festival = mapper.map(festivalDto);
        return festivalRepository.save(festival);
    }

    @Override
    public Collection<Festival> list(int limit) {
        log.info("List festival... limit : {}", limit);
        return festivalRepository.findAll(PageRequest.of(0, limit, Sort.by(Sort.Direction.ASC, "dateStart"))).toList();
    }

    @Override
    public Festival last() {
        List<Festival> festivalList = festivalRepository.findAll(Sort.by(Sort.Direction.ASC,"dateStart"));
        return festivalList.get(0);
    }

    @Override
    public Festival get(String uuid) {
        log.info("get Festival... {}", uuid);
        return festivalRepository.existsById(UUID.fromString(uuid)) ? festivalRepository.getById(UUID.fromString(uuid)) : null;
    }


    @Override
    public Festival update(FestivalDto festivalDto) {
        Festival festival = mapper.map(festivalDto);
        return festivalRepository.save(festival);
    }

    @Override
    public Boolean delete(String uuid) {
        log.info("delete Festival... {}", uuid);
        Boolean exists = festivalRepository.existsById(UUID.fromString(uuid)) ? Boolean.TRUE : Boolean.FALSE;
        if(exists == Boolean.TRUE) {
            festivalRepository.delete(festivalRepository.getById(UUID.fromString(uuid)));
        }
        return exists;
    }
}
