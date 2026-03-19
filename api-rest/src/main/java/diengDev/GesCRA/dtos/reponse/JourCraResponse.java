package diengDev.GesCRA.dtos.reponse;

import diengDev.GesCRA.enums.TypeJour;

import java.time.LocalDate;
import java.util.UUID;

public record JourCraResponse(
        UUID id,
        LocalDate dateJour,
        TypeJour typeJour,
        String commentaire,
        UUID craId,
        UUID missionId
) {
}