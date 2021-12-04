package fr.cinquin.andy.festixapi.service;

import fr.cinquin.andy.festixapi.dto.AdminDto;
import fr.cinquin.andy.festixapi.model.Admin;

public interface AuthService {
    Admin register(AdminDto adminDto);
}
