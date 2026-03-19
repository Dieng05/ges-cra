package diengDev.GesCRA.web.controllers;

import diengDev.GesCRA.domain.services.UtilisateurService;
import diengDev.GesCRA.dtos.request.CreateUtilisateurRequest;
import diengDev.GesCRA.dtos.request.UpdateUtilisateurRequest;
import diengDev.GesCRA.dtos.reponse.UtilisateurResponse;
import diengDev.GesCRA.endpoints.UtilisateurEndpoints;
import diengDev.GesCRA.web.mappers.UtilisateurWebMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class UtilisateurController implements UtilisateurEndpoints {

    private final UtilisateurService utilisateurService;
    private final UtilisateurWebMapper utilisateurWebMapper;

    @Override
    public UtilisateurResponse create(@Valid CreateUtilisateurRequest request) {
        return utilisateurWebMapper.toResponse(
                utilisateurService.creerUtilisateur(
                        utilisateurWebMapper.toModel(request)
                )
        );
    }

    @Override
    public List<UtilisateurResponse> findAll() {
        return utilisateurService.listerUtilisateurs()
                .stream()
                .map(utilisateurWebMapper::toResponse)
                .toList();
    }

    @Override
    public UtilisateurResponse findById(UUID id) {
        return utilisateurWebMapper.toResponse(
                utilisateurService.getUtilisateur(id)
        );
    }

    @Override
    public UtilisateurResponse update(UUID id, @Valid UpdateUtilisateurRequest request) {
        return utilisateurWebMapper.toResponse(
                utilisateurService.modifierUtilisateur(id, utilisateurWebMapper.toModel(request))
        );
    }

    @Override
    public void delete(UUID id) {
        utilisateurService.supprimerUtilisateur(id);
    }

    @Override
    public UtilisateurResponse activer(UUID id) {
        return utilisateurWebMapper.toResponse(
                utilisateurService.activerUtilisateur(id)
        );
    }

    @Override
    public UtilisateurResponse desactiver(UUID id) {
        return utilisateurWebMapper.toResponse(
                utilisateurService.desactiverUtilisateur(id)
        );
    }
}