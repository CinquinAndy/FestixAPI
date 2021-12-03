package fr.cinquin.andy.festixapi.service;

import fr.cinquin.andy.festixapi.model.Admin;

import java.util.Collection;
import java.util.UUID;

public interface AdminService {
    Admin create(Admin admin);
    Collection<Admin> list(int limit);
    Admin get(UUID uuid);
    Admin update(Admin admin);
    Boolean delete(UUID uuid);
}
