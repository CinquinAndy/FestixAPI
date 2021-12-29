package fr.cinquin.andy.festixapi.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
public class FestivalDto {
    private UUID id;
    @NotNull
    @NotEmpty
    private String title;
    @NotNull
    @NotEmpty
    private String description;
    @NotNull
    @NotEmpty
    private String photoUrl;
    @NotNull
    @NotEmpty
    private LocalDate dateStart;
    @NotNull
    @NotEmpty
    private LocalDate dateEnd;
    private Set<UUID> events;
}
