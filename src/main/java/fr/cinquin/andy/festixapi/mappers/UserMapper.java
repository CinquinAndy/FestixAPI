package fr.cinquin.andy.festixapi.mappers;

import fr.cinquin.andy.festixapi.dto.UserDto;
import fr.cinquin.andy.festixapi.model.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface UserMapper {
    @Mapping(target = "isValidated", ignore = true)
    UserDto map(Users users);
    Users map(UserDto userDto);
}
