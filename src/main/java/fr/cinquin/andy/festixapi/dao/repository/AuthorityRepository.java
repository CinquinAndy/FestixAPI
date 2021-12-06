package fr.cinquin.andy.festixapi.dao.repository;

import fr.cinquin.andy.festixapi.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorityRepository extends JpaRepository<Authority, UUID> {
}
