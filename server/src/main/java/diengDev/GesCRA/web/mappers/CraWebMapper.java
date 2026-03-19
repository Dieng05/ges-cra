package diengDev.GesCRA.web.mappers;

import diengDev.GesCRA.domain.models.CraModel;
import diengDev.GesCRA.dtos.request.CreateCraRequest;
import diengDev.GesCRA.dtos.request.UpdateCraRequest;
import diengDev.GesCRA.dtos.reponse.CraResponse;
import org.springframework.stereotype.Component;

@Component
public class CraWebMapper {

    private final JourCraWebMapper jourCraWebMapper;

    public CraWebMapper(JourCraWebMapper jourCraWebMapper) {
        this.jourCraWebMapper = jourCraWebMapper;
    }

    public CraModel toModel(CreateCraRequest request) {
        if (request == null) {
            return null;
        }

        return CraModel.builder()
                .mois(request.mois())
                .annee(request.annee())
                .utilisateurId(request.utilisateurId())
                .build();
    }

    public CraModel toModel(UpdateCraRequest request) {
        if (request == null) {
            return null;
        }

        return CraModel.builder()
                .mois(request.mois())
                .annee(request.annee())
                .statut(request.statut())
                .dateSoumission(request.dateSoumission())
                .dateValidation(request.dateValidation())
                .motifDecision(request.motifDecision())
                .utilisateurId(request.utilisateurId())
                .build();
    }

    public CraResponse toResponse(CraModel model) {
        if (model == null) {
            return null;
        }

        return new CraResponse(
                model.getId(),
                model.getMois(),
                model.getAnnee(),
                model.getStatut(),
                model.getDateSoumission(),
                model.getDateValidation(),
                model.getMotifDecision(),
                model.getUtilisateurId(),
                model.getJours().stream().map(jourCraWebMapper::toResponse).toList()
        );
    }
}