package fr.cinquin.andy.festixapi.mapper;

import fr.cinquin.andy.festixapi.dto.UserDto;
import fr.cinquin.andy.festixapi.model.Users;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    UserDto map(Users users);
    Users map(UserDto userDto);
}
