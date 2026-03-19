package diengDev.GesCRA.data.mappers;

import diengDev.GesCRA.data.entities.MissionEntity;
import diengDev.GesCRA.domain.models.MissionModel;
import org.springframework.stereotype.Component;

@Component
public class MissionEntityMapper {

    public MissionModel toModel(MissionEntity entity) {
        if (entity == null) {
            return null;
        }

        return MissionModel.builder()
                .id(entity.getId())
                .titre(entity.getTitre())
                .dateDebut(entity.getDateDebut())
                .dateFin(entity.getDateFin())
                .description(entity.getDescription())
                .motif(entity.getMotif())
                .tjm(entity.getTjm())
                .active(entity.getActive())
                .build();
    }

    public MissionEntity toEntity(MissionModel model) {
        if (model == null) {
            return null;
        }

        return MissionEntity.builder()
                .id(model.getId())
                .titre(model.getTitre())
                .dateDebut(model.getDateDebut())
                .dateFin(model.getDateFin())
                .description(model.getDescription())
                .motif(model.getMotif())
                .tjm(model.getTjm())
                .active(model.getActive())
                .build();
    }

    public void updateEntity(MissionEntity entity, MissionModel model) {
        entity.setTitre(model.getTitre());
        entity.setDateDebut(model.getDateDebut());
        entity.setDateFin(model.getDateFin());
        entity.setDescription(model.getDescription());
        entity.setMotif(model.getMotif());
        entity.setTjm(model.getTjm());
        entity.setActive(model.getActive());
    }
}