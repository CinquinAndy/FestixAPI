package fr.cinquin.andy.festixapi.dao.repository;

import fr.cinquin.andy.festixapi.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ArtistRepository extends JpaRepository<Artist, UUID> {
}