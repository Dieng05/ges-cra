package diengDev.GesCRA.dtos.request;

import jakarta.validation.constraints.NotBlank;

public record DecisionCraRequest(
        @NotBlank String motif
) {
}