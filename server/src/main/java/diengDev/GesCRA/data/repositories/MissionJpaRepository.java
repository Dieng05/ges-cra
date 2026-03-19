package diengDev.GesCRA.data.repositories;

import diengDev.GesCRA.data.entities.MissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MissionJpaRepository extends JpaRepository<MissionEntity, UUID> {
}