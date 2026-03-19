package diengDev.GesCRA.data.adapters;

import diengDev.GesCRA.data.entities.MissionEntity;
import diengDev.GesCRA.data.entities.UtilisateurEntity;
import diengDev.GesCRA.data.mappers.UtilisateurEntityMapper;
import diengDev.GesCRA.data.repositories.MissionJpaRepository;
import diengDev.GesCRA.data.repositories.UtilisateurJpaRepository;
import diengDev.GesCRA.domain.dataports.UtilisateurDataPort;
import diengDev.GesCRA.domain.models.UtilisateurModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UtilisateurDataAdapter implements UtilisateurDataPort {

    private final UtilisateurJpaRepository utilisateurJpaRepository;
    private final MissionJpaRepository missionJpaRepository;
    private final UtilisateurEntityMapper utilisateurEntityMapper;

    @Override
    public UtilisateurModel save(UtilisateurModel model) {
        MissionEntity mission = null;

        if (model.getMissionId() != null) {
            mission = missionJpaRepository.findById(model.getMissionId())
                    .orElseThrow(() -> new RuntimeException("Mission introuvable"));
        }

        UtilisateurEntity entity;

        if (model.getId() != null && utilisateurJpaRepository.existsById(model.getId())) {
            entity = utilisateurJpaRepository.findById(model.getId())
                    .orElseThrow(() -> new RuntimeException("Utilisateur introuvable"));

            utilisateurEntityMapper.updateEntity(entity, model, mission);
        } else {
            entity = utilisateurEntityMapper.toEntity(model, mission);
        }

        UtilisateurEntity saved = utilisateurJpaRepository.save(entity);
        return utilisateurEntityMapper.toModel(saved);
    }

    @Override
    public Optional<UtilisateurModel> findById(UUID id) {
        return utilisateurJpaRepository.findById(id)
                .map(utilisateurEntityMapper::toModel);
    }

    @Override
    public Optional<UtilisateurModel> findByEmail(String email) {
        return utilisateurJpaRepository.findByEmail(email)
                .map(utilisateurEntityMapper::toModel);
    }

    @Override
    public List<UtilisateurModel> findAll() {
        return utilisateurJpaRepository.findAll()
                .stream()
                .map(utilisateurEntityMapper::toModel)
                .toList();
    }

    @Override
    public void deleteById(UUID id) {
        utilisateurJpaRepository.deleteById(id);
    }

    @Override
    public boolean existsByEmail(String email) {
        return utilisateurJpaRepository.existsByEmail(email);
    }
}