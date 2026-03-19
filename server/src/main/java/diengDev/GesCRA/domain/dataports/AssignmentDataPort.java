package diengDev.GesCRA.domain.dataports;

import diengDev.GesCRA.domain.models.AssignmentModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AssignmentDataPort {
    AssignmentModel save(AssignmentModel model);
    List<AssignmentModel> findAll();
    Optional<AssignmentModel> findById(UUID id);
    void deleteById(UUID id);
}