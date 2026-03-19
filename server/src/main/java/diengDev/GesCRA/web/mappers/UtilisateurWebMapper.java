package diengDev.GesCRA.web.mappers;

import diengDev.GesCRA.domain.models.UtilisateurModel;
import diengDev.GesCRA.dtos.request.CreateUtilisateurRequest;
import diengDev.GesCRA.dtos.request.UpdateUtilisateurRequest;
import diengDev.GesCRA.dtos.reponse.UtilisateurResponse;
import org.springframework.stereotype.Component;

@Component
public class UtilisateurWebMapper {

    public UtilisateurModel toModel(CreateUtilisateurRequest request) {
        if (request == null) {
            return null;
        }

        return UtilisateurModel.builder()
                .nom(request.nom())
                .prenom(request.prenom())
                .email(request.email())
                .motDePasse(request.motDePasse())
                .role(request.role())
                .statutCollaborateur(request.statutCollaborateur())
                .typeContrat(request.typeContrat())
                .seniorite(request.seniorite())
                .salaire(request.salaire())
                .missionId(request.missionId())
                .actif(true)
                .build();
    }

    public UtilisateurModel toModel(UpdateUtilisateurRequest request) {
        if (request == null) {
            return null;
        }

        return UtilisateurModel.builder()
                .nom(request.nom())
                .prenom(request.prenom())
                .role(request.role())
                .statutCollaborateur(request.statutCollaborateur())
                .typeContrat(request.typeContrat())
                .seniorite(request.seniorite())
                .salaire(request.salaire())
                .missionId(request.missionId())
                .actif(request.actif())
                .build();
    }

    public UtilisateurResponse toResponse(UtilisateurModel model) {
        if (model == null) {
            return null;
        }

        return new UtilisateurResponse(
                model.getId(),
                model.getNom(),
                model.getPrenom(),
                model.getEmail(),
                model.getActif(),
                model.getRole(),
                model.getStatutCollaborateur(),
                model.getTypeContrat(),
                model.getSeniorite(),
                model.getSalaire(),
                model.getMissionId(),
                model.getMissionTitre()
        );
    }
}