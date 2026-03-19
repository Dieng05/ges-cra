package diengDev.GesCRA.dtos.request;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record CreateCraRequest(
        @NotNull Integer mois,
        @NotNull Integer annee,
        @NotNull UUID utilisateurId
) {
}