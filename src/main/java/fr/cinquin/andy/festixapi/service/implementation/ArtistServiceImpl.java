package fr.cinquin.andy.festixapi.service.implementation;

import fr.cinquin.andy.festixapi.model.Artist;
import fr.cinquin.andy.festixapi.service.ArtistService;
import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.UUID;

@RequiredArgsConstructor
public class ArtistServiceImpl implements ArtistService {

    @Override
    public Artist create(Artist artist) {
        return null;
    }

    @Override
    public Collection<Artist> list(int limit) {
        return null;
    }

    @Override
    public Artist get(UUID uuid) {
        return null;
    }

    @Override
    public Artist update(Artist artist) {
        return null;
    }

    @Override
    public Boolean delete(UUID uuid) {
        return null;
    }
}
