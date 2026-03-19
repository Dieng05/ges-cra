package diengDev.GesCRA.domain.models;

import diengDev.GesCRA.enums.Role;
import diengDev.GesCRA.enums.Seniorite;
import diengDev.GesCRA.enums.StatutCollaborateur;
import diengDev.GesCRA.enums.TypeContrat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UtilisateurModel {

    private UUID id;
    private String nom;
    private String prenom;
    private String email;
    private String motDePasse;
    private Boolean actif;
    private Role role;
    private StatutCollaborateur statutCollaborateur;
    private TypeContrat typeContrat;
    private Seniorite seniorite;
    private BigDecimal salaire;

    private UUID missionId;
    private String missionTitre;
}