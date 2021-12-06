package fr.cinquin.andy.festixapi.service;

import fr.cinquin.andy.festixapi.dto.UserDto;
import fr.cinquin.andy.festixapi.model.Users;

public interface AuthService {
    Users register(UserDto userDto);
}
