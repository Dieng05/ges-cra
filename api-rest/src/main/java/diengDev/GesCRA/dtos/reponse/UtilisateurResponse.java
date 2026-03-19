package diengDev.GesCRA.dtos.reponse;

import diengDev.GesCRA.enums.Role;
import diengDev.GesCRA.enums.Seniorite;
import diengDev.GesCRA.enums.StatutCollaborateur;
import diengDev.GesCRA.enums.TypeContrat;

import java.math.BigDecimal;
import java.util.UUID;

public record UtilisateurResponse(
        UUID id,
        String nom,
        String prenom,
        String email,
        Boolean actif,
        Role role,
        StatutCollaborateur statutCollaborateur,
        TypeContrat typeContrat,
        Seniorite seniorite,
        BigDecimal salaire,
        UUID missionId,
        String missionTitre
) {
}