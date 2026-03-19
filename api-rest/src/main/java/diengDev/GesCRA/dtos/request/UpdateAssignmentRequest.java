package diengDev.GesCRA.dtos.request;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public record UpdateAssignmentRequest(
        @NotNull LocalDate dateDebut,
        LocalDate dateFin,
        @NotNull UUID utilisateurId,
        @NotNull UUID missionId
) {
}