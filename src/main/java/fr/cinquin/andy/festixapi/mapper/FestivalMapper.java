package fr.cinquin.andy.festixapi.mapper;

import fr.cinquin.andy.festixapi.dto.EventDto;
import fr.cinquin.andy.festixapi.dto.FestivalDto;
import fr.cinquin.andy.festixapi.model.Event;
import fr.cinquin.andy.festixapi.model.Festival;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper
public interface FestivalMapper {
    @Mapping(target = "events", ignore = true)
    FestivalDto map(Festival festival);
    @Mapping(target = "events", ignore = true)
    Festival map(FestivalDto festivalDto);
}
