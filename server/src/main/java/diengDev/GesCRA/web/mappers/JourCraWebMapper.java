package diengDev.GesCRA.web.mappers;

import diengDev.GesCRA.domain.models.JourCraModel;
import diengDev.GesCRA.dtos.request.CreateJourCraRequest;
import diengDev.GesCRA.dtos.request.UpdateJourCraRequest;
import diengDev.GesCRA.dtos.reponse.JourCraResponse;
import org.springframework.stereotype.Component;

@Component
public class JourCraWebMapper {

    public JourCraModel toModel(CreateJourCraRequest request) {
        if (request == null) {
            return null;
        }

        return JourCraModel.builder()
                .dateJour(request.dateJour())
                .typeJour(request.typeJour())
                .commentaire(request.commentaire())
                .craId(request.craId())
                .missionId(request.missionId())
                .build();
    }

    public JourCraModel toModel(UpdateJourCraRequest request) {
        if (request == null) {
            return null;
        }

        return JourCraModel.builder()
                .dateJour(request.dateJour())
                .typeJour(request.typeJour())
                .commentaire(request.commentaire())
                .craId(request.craId())
                .missionId(request.missionId())
                .build();
    }

    public JourCraResponse toResponse(JourCraModel model) {
        if (model == null) {
            return null;
        }

        return new JourCraResponse(
                model.getId(),
                model.getDateJour(),
                model.getTypeJour(),
                model.getCommentaire(),
                model.getCraId(),
                model.getMissionId()
        );
    }
}