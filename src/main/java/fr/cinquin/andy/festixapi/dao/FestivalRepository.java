package fr.cinquin.andy.festixapi.dao;

import fr.cinquin.andy.festixapi.model.Festival;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FestivalRepository extends JpaRepository<Festival, UUID> {

}
