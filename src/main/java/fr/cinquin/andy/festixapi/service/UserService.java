package fr.cinquin.andy.festixapi.service;

import fr.cinquin.andy.festixapi.dto.UserDto;
import fr.cinquin.andy.festixapi.model.UserToReturn;
import fr.cinquin.andy.festixapi.model.Users;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public interface UserService {
    List<UserToReturn> list(int limit);
    Users get(UUID uuid);
    Users update(UserDto userDto);
    Boolean delete(UUID uuid);
}
