package diengDev.GesCRA.data.mappers;

import diengDev.GesCRA.data.entities.MissionEntity;
import diengDev.GesCRA.data.entities.UtilisateurEntity;
import diengDev.GesCRA.domain.models.UtilisateurModel;
import org.springframework.stereotype.Component;

@Component
public class UtilisateurEntityMapper {

    public UtilisateurModel toModel(UtilisateurEntity entity) {
        if (entity == null) {
            return null;
        }

        return UtilisateurModel.builder()
                .id(entity.getId())
                .nom(entity.getNom())
                .prenom(entity.getPrenom())
                .email(entity.getEmail())
                .motDePasse(entity.getMotDePasse())
                .actif(entity.getActif())
                .role(entity.getRole())
                .statutCollaborateur(entity.getStatutCollaborateur())
                .typeContrat(entity.getTypeContrat())
                .seniorite(entity.getSeniorite())
                .salaire(entity.getSalaire())
                .missionId(entity.getMission() != null ? entity.getMission().getId() : null)
                .missionTitre(entity.getMission() != null ? entity.getMission().getTitre() : null)
                .build();
    }

    public UtilisateurEntity toEntity(UtilisateurModel model, MissionEntity mission) {
        if (model == null) {
            return null;
        }

        return UtilisateurEntity.builder()
                .id(model.getId())
                .nom(model.getNom())
                .prenom(model.getPrenom())
                .email(model.getEmail())
                .motDePasse(model.getMotDePasse())
                .actif(model.getActif())
                .role(model.getRole())
                .statutCollaborateur(model.getStatutCollaborateur())
                .typeContrat(model.getTypeContrat())
                .seniorite(model.getSeniorite())
                .salaire(model.getSalaire())
                .mission(mission)
                .build();
    }

    public void updateEntity(UtilisateurEntity entity, UtilisateurModel model, MissionEntity mission) {
        entity.setNom(model.getNom());
        entity.setPrenom(model.getPrenom());
        entity.setActif(model.getActif());
        entity.setStatutCollaborateur(model.getStatutCollaborateur());
        entity.setTypeContrat(model.getTypeContrat());
        entity.setSeniorite(model.getSeniorite());
        entity.setSalaire(model.getSalaire());
        entity.setMission(mission);
    }
}