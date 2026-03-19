package diengDev.GesCRA.endpoints;

import diengDev.GesCRA.dtos.reponse.CraResponse;
import diengDev.GesCRA.dtos.reponse.JourCraResponse;
import diengDev.GesCRA.dtos.request.CreateCraRequest;
import diengDev.GesCRA.dtos.request.UpdateJourCraRequest;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "CRA Collaborateur", description = "Opérations liées aux CRA du collaborateur")
@RequestMapping("/api/cra")
public interface CraEndpoints {

    @Operation(description = "Créer un CRA mensuel")
    @ApiResponse(responseCode = "201", description = "CRA créé avec succès")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    CraResponse create(@RequestBody CreateCraRequest request);

    @Operation(description = "Récupérer un CRA par son identifiant")
    @ApiResponse(responseCode = "200", description = "CRA récupéré avec succès")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    CraResponse findById(@PathVariable UUID id);

    @Operation(description = "Récupérer le CRA d'un utilisateur pour un mois et une année")
    @ApiResponse(responseCode = "200", description = "CRA récupéré avec succès")
    @GetMapping("/me")
    @ResponseStatus(HttpStatus.OK)
    CraResponse findByUtilisateurMoisAnnee(
            @RequestParam UUID utilisateurId,
            @RequestParam Integer mois,
            @RequestParam Integer annee
    );

    @Operation(description = "Soumettre un CRA")
    @ApiResponse(responseCode = "200", description = "CRA soumis avec succès")
    @PostMapping("/{id}/submit")
    @ResponseStatus(HttpStatus.OK)
    CraResponse submit(@PathVariable UUID id);

    @Operation(description = "Mettre à jour un jour du CRA")
    @ApiResponse(responseCode = "200", description = "Jour du CRA mis à jour avec succès")
    @PutMapping("/{craId}/jours/{jourId}")
    @ResponseStatus(HttpStatus.OK)
    JourCraResponse updateJour(
            @PathVariable UUID craId,
            @PathVariable UUID jourId,
            @RequestBody UpdateJourCraRequest request
    );
}