package diengDev.GesCRA.dtos.reponse;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record MissionResponse(
        UUID id,
        String titre,
        LocalDate dateDebut,
        LocalDate dateFin,
        String description,
        String motif,
        BigDecimal tjm,
        Boolean active
) {
}