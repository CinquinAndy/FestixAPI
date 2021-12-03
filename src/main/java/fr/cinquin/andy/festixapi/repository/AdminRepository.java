package fr.cinquin.andy.festixapi.repository;

import fr.cinquin.andy.festixapi.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AdminRepository extends JpaRepository<Admin, UUID> {
}
