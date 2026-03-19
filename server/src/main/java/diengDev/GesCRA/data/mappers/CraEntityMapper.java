package diengDev.GesCRA.data.mappers;

import diengDev.GesCRA.data.entities.CraEntity;
import diengDev.GesCRA.data.entities.UtilisateurEntity;
import diengDev.GesCRA.domain.models.CraModel;
import org.springframework.stereotype.Component;

@Component
public class CraEntityMapper {

    public CraModel toModel(CraEntity entity) {
        if (entity == null) {
            return null;
        }

        return CraModel.builder()
                .id(entity.getId())
                .mois(entity.getMois())
                .annee(entity.getAnnee())
                .statut(entity.getStatut())
                .dateSoumission(entity.getDateSoumission())
                .dateValidation(entity.getDateValidation())
                .motifDecision(entity.getMotifDecision())
                .utilisateurId(entity.getUtilisateur() != null ? entity.getUtilisateur().getId() : null)
                .build();
    }

    public CraEntity toEntity(CraModel model, UtilisateurEntity utilisateur) {
        if (model == null) {
            return null;
        }

        return CraEntity.builder()
                .id(model.getId())
                .mois(model.getMois())
                .annee(model.getAnnee())
                .statut(model.getStatut())
                .dateSoumission(model.getDateSoumission())
                .dateValidation(model.getDateValidation())
                .motifDecision(model.getMotifDecision())
                .utilisateur(utilisateur)
                .build();
    }

    public void updateEntity(CraEntity entity, CraModel model, UtilisateurEntity utilisateur) {
        entity.setMois(model.getMois());
        entity.setAnnee(model.getAnnee());
        entity.setStatut(model.getStatut());
        entity.setDateSoumission(model.getDateSoumission());
        entity.setDateValidation(model.getDateValidation());
        entity.setMotifDecision(model.getMotifDecision());
        entity.setUtilisateur(utilisateur);
    }
}