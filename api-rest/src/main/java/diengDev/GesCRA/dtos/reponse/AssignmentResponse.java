package diengDev.GesCRA.dtos.reponse;

import java.time.LocalDate;
import java.util.UUID;

public record AssignmentResponse(
        UUID id,
        LocalDate dateDebut,
        LocalDate dateFin,
        UUID utilisateurId,
        UUID missionId
) {
}