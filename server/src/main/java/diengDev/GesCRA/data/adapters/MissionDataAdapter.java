package diengDev.GesCRA.data.adapters;

import diengDev.GesCRA.data.entities.MissionEntity;
import diengDev.GesCRA.data.mappers.MissionEntityMapper;
import diengDev.GesCRA.data.repositories.MissionJpaRepository;
import diengDev.GesCRA.domain.dataports.MissionDataPort;
import diengDev.GesCRA.domain.models.MissionModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class MissionDataAdapter implements MissionDataPort {

    private final MissionJpaRepository missionJpaRepository;
    private final MissionEntityMapper mapper;

    @Override
    public MissionModel save(MissionModel model) {
        MissionEntity entity;
        if (model.getId() != null && missionJpaRepository.existsById(model.getId())) {
            entity = missionJpaRepository.findById(model.getId()).orElseThrow();
            mapper.updateEntity(entity, model);
        } else {
            entity = mapper.toEntity(model);
        }
        return mapper.toModel(missionJpaRepository.save(entity));
    }

    @Override
    public List<MissionModel> findAll() {
        return missionJpaRepository.findAll().stream()
                .map(mapper::toModel)
                .toList();
    }

    @Override
    public Optional<MissionModel> findById(UUID id) {
        return missionJpaRepository.findById(id).map(mapper::toModel);
    }

    @Override
    public void deleteById(UUID id) {
        missionJpaRepository.deleteById(id);
    }
}