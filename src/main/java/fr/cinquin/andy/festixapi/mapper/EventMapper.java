package fr.cinquin.andy.festixapi.mapper;

import fr.cinquin.andy.festixapi.dto.ArtistDto;
import fr.cinquin.andy.festixapi.dto.EventDto;
import fr.cinquin.andy.festixapi.model.Artist;
import fr.cinquin.andy.festixapi.model.Event;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper
public interface EventMapper {
    @Mapping(target = "festival", ignore = true)
    @Mapping(target = "artists", ignore = true)
    EventDto map(Event event);
    @Mapping(target = "festival", ignore = true)
    @Mapping(target = "artists", ignore = true)
    Event map(EventDto eventDto);
}
