package fr.cinquin.andy.festixapi.service;

import fr.cinquin.andy.festixapi.model.Users;

import java.util.Collection;
import java.util.UUID;

public interface UserService {
    Collection<Users> list(int limit);
    Users get(UUID uuid);
    Users update(Users users);
    Boolean delete(UUID uuid);
}
