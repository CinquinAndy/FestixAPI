package fr.cinquin.andy.festixapi.dto;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Component
@Data
@AllArgsConstructor
public class EventDto {
    private UUID id;

    @NotNull
    @NotEmpty
    private String title;
    @NotNull
    @NotEmpty
    private LocalDateTime dateTime;
    @NotNull
    @NotEmpty
    private UUID festival;

    private Set<UUID> artists;
}
