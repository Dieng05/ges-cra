package diengDev.GesCRA.data.adapters;

import diengDev.GesCRA.data.entities.AssignmentEntity;
import diengDev.GesCRA.data.entities.MissionEntity;
import diengDev.GesCRA.data.entities.UtilisateurEntity;
import diengDev.GesCRA.data.mappers.AssignmentEntityMapper;
import diengDev.GesCRA.data.repositories.AssignmentJpaRepository;
import diengDev.GesCRA.data.repositories.MissionJpaRepository;
import diengDev.GesCRA.data.repositories.UtilisateurJpaRepository;
import diengDev.GesCRA.domain.dataports.AssignmentDataPort;
import diengDev.GesCRA.domain.models.AssignmentModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class AssignmentDataAdapter implements AssignmentDataPort {

    private final AssignmentJpaRepository assignmentJpaRepository;
    private final UtilisateurJpaRepository utilisateurJpaRepository;
    private final MissionJpaRepository missionJpaRepository;
    private final AssignmentEntityMapper assignmentEntityMapper;

    @Override
    public AssignmentModel save(AssignmentModel assignmentModel) {
        UtilisateurEntity utilisateur = utilisateurJpaRepository.findById(assignmentModel.getUtilisateurId())
                .orElseThrow(() -> new IllegalArgumentException("Utilisateur introuvable"));

        MissionEntity mission = missionJpaRepository.findById(assignmentModel.getMissionId())
                .orElseThrow(() -> new IllegalArgumentException("Mission introuvable"));

        AssignmentEntity entity;

        if (assignmentModel.getId() != null && assignmentJpaRepository.existsById(assignmentModel.getId())) {
            entity = assignmentJpaRepository.findById(assignmentModel.getId()).orElseThrow();
            assignmentEntityMapper.updateEntity(entity, assignmentModel, utilisateur, mission);
        } else {
            entity = assignmentEntityMapper.toEntity(assignmentModel, utilisateur, mission);
        }

        return assignmentEntityMapper.toModel(assignmentJpaRepository.save(entity));
    }

    @Override
    public List<AssignmentModel> findAll() {
        return assignmentJpaRepository.findAll()
                .stream()
                .map(assignmentEntityMapper::toModel)
                .toList();
    }

    @Override
    public Optional<AssignmentModel> findById(UUID id) {
        return assignmentJpaRepository.findById(id)
                .map(assignmentEntityMapper::toModel);
    }

    @Override
    public void deleteById(UUID id) {
        assignmentJpaRepository.deleteById(id);
    }
}