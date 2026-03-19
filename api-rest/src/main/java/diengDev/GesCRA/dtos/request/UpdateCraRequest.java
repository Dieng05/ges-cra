package diengDev.GesCRA.dtos.request;

import diengDev.GesCRA.enums.StatutCRA;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public record UpdateCraRequest(
        @NotNull Integer mois,
        @NotNull Integer annee,
        @NotNull StatutCRA statut,
        LocalDateTime dateSoumission,
        LocalDateTime dateValidation,
        String motifDecision,
        @NotNull UUID utilisateurId
) {
}