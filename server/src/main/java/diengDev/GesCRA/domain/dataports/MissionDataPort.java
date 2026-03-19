package diengDev.GesCRA.domain.dataports;

import diengDev.GesCRA.domain.models.MissionModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MissionDataPort {
    MissionModel save(MissionModel model);
    List<MissionModel> findAll();
    Optional<MissionModel> findById(UUID id);
    void deleteById(UUID id);
}