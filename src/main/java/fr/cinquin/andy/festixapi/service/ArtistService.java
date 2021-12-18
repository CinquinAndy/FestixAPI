package fr.cinquin.andy.festixapi.service;

import fr.cinquin.andy.festixapi.dto.ArtistDto;
import fr.cinquin.andy.festixapi.model.Artist;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Collection;

@Transactional
@Service

public interface ArtistService {
    Artist create(ArtistDto artistDto);
    Collection<Artist> list(int limit);
    Artist random();
    Artist get(String uuid);
    Artist update(ArtistDto artistDto);
    Boolean delete(String uuid);
}
