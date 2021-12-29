package fr.cinquin.andy.festixapi.dao;

import fr.cinquin.andy.festixapi.model.UserToReturn;
import fr.cinquin.andy.festixapi.model.Users;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<Users, UUID> {
    Optional<Users> findByEmail(String email);
    List<UserToReturn> findAllBy(Sort sort);
    UserToReturn findAllById(UUID uuid);
    Boolean existsByEmail(String email);
}
