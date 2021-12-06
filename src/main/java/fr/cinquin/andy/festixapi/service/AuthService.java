package fr.cinquin.andy.festixapi.service;

import fr.cinquin.andy.festixapi.dto.UserDto;
import fr.cinquin.andy.festixapi.model.Users;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public interface AuthService {
    Users register(UserDto userDto);
}
