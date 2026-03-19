package diengDev.GesCRA.dtos.request;

import diengDev.GesCRA.enums.TypeJour;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public record UpdateJourCraRequest(
        @NotNull LocalDate dateJour,
        @NotNull TypeJour typeJour,
        String commentaire,
        @NotNull UUID craId,
        UUID missionId
) {
}