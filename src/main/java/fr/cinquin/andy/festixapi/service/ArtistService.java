package fr.cinquin.andy.festixapi.service;

import fr.cinquin.andy.festixapi.model.Artist;

import java.util.Collection;
import java.util.UUID;

public interface ArtistService {
    Artist create(Artist artist);
    Collection<Artist> list(int limit);
    Artist get(UUID uuid);
    Artist update(Artist artist);
    Boolean delete(UUID uuid);
}
