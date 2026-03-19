package diengDev.GesCRA.endpoints;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface CrudEndpoints<ID, CREATE_REQ, UPDATE_REQ, RES> {

    @Operation(description = "Créer une ressource")
    @ApiResponse(responseCode = "201", description = "Ressource créée avec succès")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    RES create(@RequestBody CREATE_REQ request);

    @Operation(description = "Lister toutes les ressources")
    @ApiResponse(responseCode = "200", description = "Liste récupérée avec succès")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<RES> findAll();

    @Operation(description = "Récupérer une ressource par son identifiant")
    @ApiResponse(responseCode = "200", description = "Ressource récupérée avec succès")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    RES findById(@PathVariable ID id);

    @Operation(description = "Mettre à jour une ressource")
    @ApiResponse(responseCode = "200", description = "Ressource mise à jour avec succès")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    RES update(@PathVariable ID id, @RequestBody UPDATE_REQ request);

    @Operation(description = "Supprimer une ressource")
    @ApiResponse(responseCode = "204", description = "Ressource supprimée avec succès")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable ID id);
}