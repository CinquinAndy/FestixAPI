package fr.cinquin.andy.festixapi.dao.repository;

import fr.cinquin.andy.festixapi.model.ERole;
import fr.cinquin.andy.festixapi.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}