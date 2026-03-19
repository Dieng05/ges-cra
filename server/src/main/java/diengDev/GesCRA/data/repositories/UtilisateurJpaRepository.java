package diengDev.GesCRA.data.repositories;

import diengDev.GesCRA.data.entities.UtilisateurEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UtilisateurJpaRepository extends JpaRepository<UtilisateurEntity, UUID> {
    Optional<UtilisateurEntity> findByEmail(String email);
    boolean existsByEmail(String email);
}