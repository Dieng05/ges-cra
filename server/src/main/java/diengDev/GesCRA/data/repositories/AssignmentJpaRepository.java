package diengDev.GesCRA.data.repositories;

import diengDev.GesCRA.data.entities.AssignmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AssignmentJpaRepository extends JpaRepository<AssignmentEntity, UUID> {
}