package diengDev.GesCRA.web.controllers;

import diengDev.GesCRA.domain.models.JourCraModel;
import diengDev.GesCRA.domain.services.CraService;
import diengDev.GesCRA.domain.services.JourCraService;
import diengDev.GesCRA.dtos.request.CreateCraRequest;
import diengDev.GesCRA.dtos.request.UpdateJourCraRequest;
import diengDev.GesCRA.dtos.reponse.CraResponse;
import diengDev.GesCRA.dtos.reponse.JourCraResponse;
import diengDev.GesCRA.endpoints.CraEndpoints;
import diengDev.GesCRA.web.mappers.CraWebMapper;
import diengDev.GesCRA.web.mappers.JourCraWebMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class CraController implements CraEndpoints {

    private final CraService craService;
    private final JourCraService jourCraService;
    private final CraWebMapper craWebMapper;
    private final JourCraWebMapper jourCraWebMapper;

    @Override
    public CraResponse create(@Valid CreateCraRequest request) {
        return craWebMapper.toResponse(
                craService.creerCra(
                        craWebMapper.toModel(request)
                )
        );
    }

    @Override
    public CraResponse findById(UUID id) {
        return craWebMapper.toResponse(
                craService.getCra(id)
        );
    }

    @Override
    public CraResponse findByUtilisateurMoisAnnee(UUID utilisateurId, Integer mois, Integer annee) {
        return craWebMapper.toResponse(
                craService.getCraByUtilisateurEtPeriode(utilisateurId, mois, annee)
        );
    }

    @Override
    public CraResponse submit(UUID id) {
        return craWebMapper.toResponse(
                craService.soumettreCra(id)
        );
    }

    @Override
    public JourCraResponse updateJour(UUID craId, UUID jourId, @Valid UpdateJourCraRequest request) {
        JourCraModel model = jourCraWebMapper.toModel(request);
        model.setId(jourId);
        model.setCraId(craId);

        return jourCraWebMapper.toResponse(
                jourCraService.modifierJour(model)
        );
    }
}