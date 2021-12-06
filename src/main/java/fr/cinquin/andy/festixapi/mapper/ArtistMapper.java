package fr.cinquin.andy.festixapi.mapper;

import fr.cinquin.andy.festixapi.dto.ArtistDto;
import fr.cinquin.andy.festixapi.model.Artist;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper
public interface ArtistMapper {
    @Mapping(target = "authorities", ignore = true)
    ArtistDto map(Artist artist);
    Artist map(ArtistDto artistDto);
}
