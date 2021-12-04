package fr.cinquin.andy.festixapi.dao.repository;

import fr.cinquin.andy.festixapi.model.Festival;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FestivalRepository extends JpaRepository<Festival, UUID> {
}
