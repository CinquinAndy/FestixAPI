package fr.cinquin.andy.festixapi.service.implementation;

import fr.cinquin.andy.festixapi.dto.ArtistDto;
import fr.cinquin.andy.festixapi.mapper.ArtistMapper;
import fr.cinquin.andy.festixapi.model.Artist;
import fr.cinquin.andy.festixapi.dao.ArtistRepository;
import fr.cinquin.andy.festixapi.service.ArtistService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Transactional
@Service
@Slf4j
@RequiredArgsConstructor
public class ArtistServiceImpl implements ArtistService {
    private final ArtistRepository artistRepository;

    private final ArtistMapper mapper = Mappers.getMapper(ArtistMapper.class);

    @Override
    public Artist create(ArtistDto artistDto) {
        Artist artist = mapper.map(artistDto);
        return artistRepository.save(artist);
    }

    @Override
    public Collection<Artist> list(int limit) {
        return artistRepository.findAll(PageRequest.of(0, limit)).toList();
    }

    @Override
    public Collection<Artist> byevent(String uuid) {
        return artistRepository.findAllByEvents(UUID.fromString(uuid));
    }

    @Override
    public Artist random() {
        Random rand = new Random(); //instance of random class
        List<Artist> artistList = artistRepository.findAll(PageRequest.of(0, 100)).toList();
        int upperbound = artistList.size();
        int int_random = rand.nextInt(upperbound);
        return artistList.get(int_random);
    }

    @Override
    public Artist get(String uuid) {
        return artistRepository.existsById(UUID.fromString(uuid)) ? artistRepository.getById(UUID.fromString(uuid)) : null;
    }

    @Override
    public Artist update(ArtistDto artistDto) {
        Artist artist = mapper.map(artistDto);
        return artistRepository.save(artist);
    }

    @Override
    public Boolean delete(String uuid) {
        Boolean exists = artistRepository.existsById(UUID.fromString(uuid)) ? Boolean.TRUE : Boolean.FALSE;
        if(exists == Boolean.TRUE) {
            artistRepository.delete(artistRepository.getById(UUID.fromString(uuid)));
        }
        return exists;
    }
}
