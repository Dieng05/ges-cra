package diengDev.GesCRA.web.mappers;

import diengDev.GesCRA.domain.models.AssignmentModel;
import diengDev.GesCRA.dtos.request.CreateAssignmentRequest;
import diengDev.GesCRA.dtos.request.UpdateAssignmentRequest;
import diengDev.GesCRA.dtos.reponse.AssignmentResponse;
import org.springframework.stereotype.Component;

@Component
public class AssignmentWebMapper {

    public AssignmentModel toModel(CreateAssignmentRequest request) {
        if (request == null) {
            return null;
        }

        return AssignmentModel.builder()
                .dateDebut(request.dateDebut())
                .dateFin(request.dateFin())
                .utilisateurId(request.utilisateurId())
                .missionId(request.missionId())
                .build();
    }

    public AssignmentModel toModel(UpdateAssignmentRequest request) {
        if (request == null) {
            return null;
        }

        return AssignmentModel.builder()
                .dateDebut(request.dateDebut())
                .dateFin(request.dateFin())
                .utilisateurId(request.utilisateurId())
                .missionId(request.missionId())
                .build();
    }

    public AssignmentResponse toResponse(AssignmentModel model) {
        if (model == null) {
            return null;
        }

        return new AssignmentResponse(
                model.getId(),
                model.getDateDebut(),
                model.getDateFin(),
                model.getUtilisateurId(),
                model.getMissionId()
        );
    }
}