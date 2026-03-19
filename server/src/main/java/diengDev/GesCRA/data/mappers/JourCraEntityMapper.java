package diengDev.GesCRA.data.mappers;

import diengDev.GesCRA.data.entities.CraEntity;
import diengDev.GesCRA.data.entities.JourCraEntity;
import diengDev.GesCRA.data.entities.MissionEntity;
import diengDev.GesCRA.domain.models.JourCraModel;
import org.springframework.stereotype.Component;

@Component
public class JourCraEntityMapper {

    public JourCraModel toModel(JourCraEntity entity) {
        if (entity == null) {
            return null;
        }

        return JourCraModel.builder()
                .id(entity.getId())
                .dateJour(entity.getDateJour())
                .typeJour(entity.getTypeJour())
                .commentaire(entity.getCommentaire())
                .craId(entity.getCra() != null ? entity.getCra().getId() : null)
                .missionId(entity.getMission() != null ? entity.getMission().getId() : null)
                .build();
    }

    public JourCraEntity toEntity(JourCraModel model, CraEntity cra, MissionEntity mission) {
        if (model == null) {
            return null;
        }

        return JourCraEntity.builder()
                .id(model.getId())
                .dateJour(model.getDateJour())
                .typeJour(model.getTypeJour())
                .commentaire(model.getCommentaire())
                .cra(cra)
                .mission(mission)
                .build();
    }

    public void updateEntity(JourCraEntity entity, JourCraModel model, CraEntity cra, MissionEntity mission) {
        entity.setDateJour(model.getDateJour());
        entity.setTypeJour(model.getTypeJour());
        entity.setCommentaire(model.getCommentaire());
        entity.setCra(cra);
        entity.setMission(mission);
    }
}