package diengDev.GesCRA.data.mappers;

import diengDev.GesCRA.data.entities.AssignmentEntity;
import diengDev.GesCRA.data.entities.MissionEntity;
import diengDev.GesCRA.data.entities.UtilisateurEntity;
import diengDev.GesCRA.domain.models.AssignmentModel;
import org.springframework.stereotype.Component;

@Component
public class AssignmentEntityMapper {

    public AssignmentModel toModel(AssignmentEntity entity) {
        if (entity == null) return null;

        return AssignmentModel.builder()
                .id(entity.getId())
                .dateDebut(entity.getDateDebut())
                .dateFin(entity.getDateFin())
                .utilisateurId(entity.getUtilisateurEntity() != null ? entity.getUtilisateurEntity().getId() : null)
                .missionId(entity.getMission() != null ? entity.getMission().getId() : null)
                .build();
    }

    public AssignmentEntity toEntity(AssignmentModel domain, UtilisateurEntity utilisateurEntity, MissionEntity missionEntity) {
        if (domain == null) return null;

        return AssignmentEntity.builder()
                .id(domain.getId())
                .dateDebut(domain.getDateDebut())
                .dateFin(domain.getDateFin())
                .utilisateurEntity(utilisateurEntity)
                .mission(missionEntity)
                .build();
    }

    public void updateEntity(AssignmentEntity entity, AssignmentModel domain, UtilisateurEntity utilisateurEntity, MissionEntity missionEntity) {
        entity.setDateDebut(domain.getDateDebut());
        entity.setDateFin(domain.getDateFin());
        entity.setUtilisateurEntity(utilisateurEntity);
        entity.setMission(missionEntity);
    }
}