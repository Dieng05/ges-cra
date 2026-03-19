package diengDev.GesCRA.endpoints;

import diengDev.GesCRA.dtos.reponse.UtilisateurResponse;
import diengDev.GesCRA.dtos.request.CreateUtilisateurRequest;
import diengDev.GesCRA.dtos.request.UpdateUtilisateurRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Utilisateurs", description = "Opérations liées aux collaborateurs et administrateurs")
@RequestMapping("/api/admin/utilisateurs")
public interface UtilisateurEndpoints extends CrudEndpoints<
        UUID,
        CreateUtilisateurRequest,
        UpdateUtilisateurRequest,
        UtilisateurResponse> {

    @Operation(description = "Activer un utilisateur")
    @ApiResponse(responseCode = "200", description = "Utilisateur activé avec succès")
    @PatchMapping("/{id}/activer")
    @ResponseStatus(HttpStatus.OK)
    UtilisateurResponse activer(@PathVariable UUID id);

    @Operation(description = "Désactiver un utilisateur")
    @ApiResponse(responseCode = "200", description = "Utilisateur désactivé avec succès")
    @PatchMapping("/{id}/desactiver")
    @ResponseStatus(HttpStatus.OK)
    UtilisateurResponse desactiver(@PathVariable UUID id);
}