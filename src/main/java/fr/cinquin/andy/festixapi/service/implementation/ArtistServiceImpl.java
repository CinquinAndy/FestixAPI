package fr.cinquin.andy.festixapi.service.implementation;

import fr.cinquin.andy.festixapi.model.Artist;
import fr.cinquin.andy.festixapi.dao.repository.ArtistRepository;
import fr.cinquin.andy.festixapi.service.ArtistService;
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
public class ArtistServiceImpl implements ArtistService {
    private final ArtistRepository artistRepository;

    @Override
    public Artist create(Artist artist) {
        log.info("Create artist... {}", artist.getArtistName());
        return artistRepository.save(artist);
    }

    @Override
    public Collection<Artist> list(int limit) {
        log.info("List artist... limit : {}", limit);
        return artistRepository.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public Artist get(UUID uuid) {
        log.info("get Artist... {}", uuid);
        return artistRepository.findById(uuid).isPresent() ? artistRepository.findById(uuid).get() : null;
    }

    @Override
    public Artist update(Artist artist) {
        log.info("Update artist... {}", artist.getArtistName());
        return artistRepository.save(artist);
    }

    @Override
    public Boolean delete(UUID uuid) {
        log.info("delete Artist... {}", uuid);
        artistRepository.deleteById(uuid);
        return Boolean.TRUE;
    }
}
