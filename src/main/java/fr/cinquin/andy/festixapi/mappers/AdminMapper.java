package fr.cinquin.andy.festixapi.mappers;

import fr.cinquin.andy.festixapi.dto.AdminDto;
import fr.cinquin.andy.festixapi.model.Admin;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface AdminMapper {
    @Mapping(target = "isValidated", ignore = true)
    AdminDto map(Admin admin);
    Admin map(AdminDto adminDto);
}
