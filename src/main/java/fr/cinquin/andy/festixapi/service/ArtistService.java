package fr.cinquin.andy.festixapi.service;

import fr.cinquin.andy.festixapi.dto.ArtistDto;
import fr.cinquin.andy.festixapi.model.Artist;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.UUID;

@Transactional
@Service

public interface ArtistService {
    Artist create(ArtistDto artistDto);
    Collection<Artist> list(int limit);
    Artist get(UUID uuid);
    Artist update(ArtistDto artistDto);
    Boolean delete(UUID uuid);
}
