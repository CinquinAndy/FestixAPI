package fr.cinquin.andy.festixapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@AllArgsConstructor
public class UserDto {
    private UUID id;
    @NotNull
    @NotEmpty
    private String username;
    @NotNull
    @NotEmpty
    private String firstname;
    @NotNull
    @NotEmpty
    private String lastname;
    @NotNull
    @NotEmpty
    private String password;
    @NotNull
    @NotEmpty
    private String email;
    private boolean enabled;
    @NotNull
    @NotEmpty
    private String authority;
}
