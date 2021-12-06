package fr.cinquin.andy.festixapi.dao.repository;

import fr.cinquin.andy.festixapi.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<Users, UUID> {
    Optional<Users> findByEmail(String email);

    Boolean existsByEmail(String email);
}
