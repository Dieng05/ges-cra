package diengDev.GesCRA.data.repositories;

import diengDev.GesCRA.data.entities.CraEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CraJpaRepository extends JpaRepository<CraEntity, UUID> {
    Optional<CraEntity> findByUtilisateurIdAndMoisAndAnnee(UUID utilisateurId, Integer mois, Integer annee);
}