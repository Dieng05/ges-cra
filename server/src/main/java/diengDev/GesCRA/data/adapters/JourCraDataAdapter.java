package diengDev.GesCRA.data.adapters;

import diengDev.GesCRA.data.entities.CraEntity;
import diengDev.GesCRA.data.entities.JourCraEntity;
import diengDev.GesCRA.data.entities.MissionEntity;
import diengDev.GesCRA.data.mappers.JourCraEntityMapper;
import diengDev.GesCRA.data.repositories.CraJpaRepository;
import diengDev.GesCRA.data.repositories.JourCraJpaRepository;
import diengDev.GesCRA.data.repositories.MissionJpaRepository;
import diengDev.GesCRA.domain.dataports.JourCraDataPort;
import diengDev.GesCRA.domain.models.JourCraModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class JourCraDataAdapter implements JourCraDataPort {

    private final JourCraJpaRepository jourCraJpaRepository;
    private final CraJpaRepository craJpaRepository;
    private final MissionJpaRepository missionJpaRepository;
    private final JourCraEntityMapper jourCraEntityMapper;

    @Override
    public JourCraModel save(JourCraModel jourCraModel) {
        CraEntity cra = craJpaRepository.findById(jourCraModel.getCraId())
                .orElseThrow(() -> new IllegalArgumentException("CRA introuvable"));

        MissionEntity mission = null;
        if (jourCraModel.getMissionId() != null) {
            mission = missionJpaRepository.findById(jourCraModel.getMissionId()).orElse(null);
        }

        JourCraEntity entity;

        if (jourCraModel.getId() != null && jourCraJpaRepository.existsById(jourCraModel.getId())) {
            entity = jourCraJpaRepository.findById(jourCraModel.getId()).orElseThrow();
            jourCraEntityMapper.updateEntity(entity, jourCraModel, cra, mission);
        } else {
            entity = jourCraEntityMapper.toEntity(jourCraModel, cra, mission);
        }

        return jourCraEntityMapper.toModel(jourCraJpaRepository.save(entity));
    }

    @Override
    public Optional<JourCraModel> findById(UUID id) {
        return jourCraJpaRepository.findById(id)
                .map(jourCraEntityMapper::toModel);
    }

    @Override
    public List<JourCraModel> findAll() {
        return jourCraJpaRepository.findAll()
                .stream()
                .map(jourCraEntityMapper::toModel)
                .toList();
    }
}