package diengDev.GesCRA.data.repositories;

import diengDev.GesCRA.data.entities.JourCraEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface JourCraJpaRepository extends JpaRepository<JourCraEntity, UUID> {
    List<JourCraEntity> findByCraId(UUID craId);
}