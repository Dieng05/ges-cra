package diengDev.GesCRA.domain.dataports;

import diengDev.GesCRA.domain.models.JourCraModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface JourCraDataPort {
    JourCraModel save(JourCraModel model);
    Optional<JourCraModel> findById(UUID id);
    List<JourCraModel> findAll();
}