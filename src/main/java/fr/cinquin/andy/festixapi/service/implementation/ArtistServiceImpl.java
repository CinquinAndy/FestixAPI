package fr.cinquin.andy.festixapi.service.implementation;

import fr.cinquin.andy.festixapi.dto.ArtistDto;
import fr.cinquin.andy.festixapi.mapper.ArtistMapper;
import fr.cinquin.andy.festixapi.model.Artist;
import fr.cinquin.andy.festixapi.dao.repository.ArtistRepository;
import fr.cinquin.andy.festixapi.service.ArtistService;
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
public class ArtistServiceImpl implements ArtistService {
    private final ArtistRepository artistRepository;

    private ArtistMapper mapper = Mappers.getMapper(ArtistMapper.class);

    @Override
    public Artist create(ArtistDto artistDto) {
        Artist artist = mapper.map(artistDto);
        log.info("Create artist... {}", artist.getArtistName());
        return artistRepository.save(artist);
    }

    @Override
    public Collection<Artist> list(int limit) {
        log.info("List artist... limit : {}", limit);
        return artistRepository.findAll(PageRequest.of(0, limit)).toList();
    }

    @Override
    public Artist get(String uuid) {
        log.info("get Artist... {}", uuid);
        return artistRepository.existsById(UUID.fromString(uuid)) ? artistRepository.getById(UUID.fromString(uuid)) : null;
    }

    @Override
    public Artist update(ArtistDto artistDto) {
        Artist artist = mapper.map(artistDto);
        log.info("Update artist... {}", artist.getArtistName());
        return artistRepository.save(artist);
    }

    @Override
    public Boolean delete(String uuid) {
        log.info("delete Artist... {}", uuid);
        Boolean exists = artistRepository.existsById(UUID.fromString(uuid)) ? Boolean.TRUE : Boolean.FALSE;
        if(exists == Boolean.TRUE) {
            artistRepository.delete(artistRepository.getById(UUID.fromString(uuid)));
        }
        return exists;
    }
}
