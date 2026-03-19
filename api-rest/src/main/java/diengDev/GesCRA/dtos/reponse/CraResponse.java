package diengDev.GesCRA.dtos.reponse;

import diengDev.GesCRA.enums.StatutCRA;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record CraResponse(
        UUID id,
        Integer mois,
        Integer annee,
        StatutCRA statut,
        LocalDateTime dateSoumission,
        LocalDateTime dateValidation,
        String motifDecision,
        UUID utilisateurId,
        List<JourCraResponse> jours
) {
}