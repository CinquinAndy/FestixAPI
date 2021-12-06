package fr.cinquin.andy.festixapi.dto;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;
import java.util.UUID;

@Component
@Data
@AllArgsConstructor
public class ArtistDto {
    private UUID id;
    @NotNull
    @NotEmpty
    private String artistName;
    @NotNull
    @NotEmpty
    private String description;
    @NotNull
    @NotEmpty
    private String musicStyle;
    @NotNull
    @NotEmpty
    private String photoUrl;
    private Set<UUID> events;
}
