package diengDev.GesCRA.endpoints;

import diengDev.GesCRA.dtos.reponse.CraResponse;
import diengDev.GesCRA.dtos.request.DecisionCraRequest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "CRA Admin", description = "Opérations d'administration des CRA")
@RequestMapping("/api/admin/cras")
public interface AdminCraEndpoints {

    @Operation(description = "Lister tous les CRA")
    @ApiResponse(responseCode = "200", description = "Liste des CRA récupérée avec succès")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<CraResponse> findAll();

    @Operation(description = "Approuver un CRA")
    @ApiResponse(responseCode = "200", description = "CRA approuvé avec succès")
    @PostMapping("/{id}/approve")
    @ResponseStatus(HttpStatus.OK)
    CraResponse approve(@PathVariable UUID id);

    @Operation(description = "Rejeter un CRA avec motif")
    @ApiResponse(responseCode = "200", description = "CRA rejeté avec succès")
    @PostMapping("/{id}/reject")
    @ResponseStatus(HttpStatus.OK)
    CraResponse reject(@PathVariable UUID id, @RequestBody DecisionCraRequest request);

    @Operation(description = "Invalider un CRA avec motif")
    @ApiResponse(responseCode = "200", description = "CRA invalidé avec succès")
    @PostMapping("/{id}/invalidate")
    @ResponseStatus(HttpStatus.OK)
    CraResponse invalidate(@PathVariable UUID id, @RequestBody DecisionCraRequest request);
}