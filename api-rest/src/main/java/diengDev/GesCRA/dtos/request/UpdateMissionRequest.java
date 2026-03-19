package diengDev.GesCRA.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record UpdateMissionRequest(
        @NotBlank String titre,
        @NotNull LocalDate dateDebut,
        LocalDate dateFin,
        String description,
        String motif,
        BigDecimal tjm,
        Boolean active
) {
}