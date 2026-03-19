package diengDev.GesCRA.dtos.request;

import diengDev.GesCRA.enums.Role;
import diengDev.GesCRA.enums.Seniorite;
import diengDev.GesCRA.enums.StatutCollaborateur;
import diengDev.GesCRA.enums.TypeContrat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public record UpdateUtilisateurRequest(
        @NotBlank String nom,
        @NotBlank String prenom,
        @NotNull Role role,
        @NotNull StatutCollaborateur statutCollaborateur,
        @NotNull TypeContrat typeContrat,
        @NotNull Seniorite seniorite,
        BigDecimal salaire,
        Boolean actif,
        UUID missionId
) {
}