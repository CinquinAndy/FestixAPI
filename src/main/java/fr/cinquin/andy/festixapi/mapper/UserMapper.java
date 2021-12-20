package fr.cinquin.andy.festixapi.mapper;

import fr.cinquin.andy.festixapi.dto.UserDto;
import fr.cinquin.andy.festixapi.model.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface UserMapper {
    @Mapping(target = "roles", ignore = true)
    UserDto map(Users users);
    @Mapping(target = "authorities_users", ignore = true)
    @Mapping(target = "authorities", ignore = true)
    @Mapping(target = "roles", ignore = true)
    Users map(UserDto userDto);
}
