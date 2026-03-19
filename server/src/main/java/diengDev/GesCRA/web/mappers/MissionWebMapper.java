package diengDev.GesCRA.web.mappers;

import diengDev.GesCRA.domain.models.MissionModel;
import diengDev.GesCRA.dtos.request.CreateMissionRequest;
import diengDev.GesCRA.dtos.request.UpdateMissionRequest;
import diengDev.GesCRA.dtos.reponse.MissionResponse;
import org.springframework.stereotype.Component;

@Component
public class MissionWebMapper {

    public MissionModel toModel(CreateMissionRequest request) {
        if (request == null) {
            return null;
        }

        return MissionModel.builder()
                .titre(request.titre())
                .dateDebut(request.dateDebut())
                .dateFin(request.dateFin())
                .description(request.description())
                .motif(request.motif())
                .tjm(request.tjm())
                .active(request.active() != null ? request.active() : true)
                .build();
    }

    public MissionModel toModel(UpdateMissionRequest request) {
        if (request == null) {
            return null;
        }

        return MissionModel.builder()
                .titre(request.titre())
                .dateDebut(request.dateDebut())
                .dateFin(request.dateFin())
                .description(request.description())
                .motif(request.motif())
                .tjm(request.tjm())
                .active(request.active())
                .build();
    }

    public MissionResponse toResponse(MissionModel model) {
        if (model == null) {
            return null;
        }

        return new MissionResponse(
                model.getId(),
                model.getTitre(),
                model.getDateDebut(),
                model.getDateFin(),
                model.getDescription(),
                model.getMotif(),
                model.getTjm(),
                model.getActive()
        );
    }
}