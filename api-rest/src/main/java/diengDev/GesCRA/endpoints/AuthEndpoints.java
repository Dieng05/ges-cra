package diengDev.GesCRA.endpoints;

import diengDev.GesCRA.dtos.reponse.AuthResponse;
import diengDev.GesCRA.dtos.request.LoginRequest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Authentification", description = "Opérations liées à l'authentification JWT")
@RequestMapping("/api/auth")
public interface AuthEndpoints {

    @Operation(description = "Se connecter à l'application")
    @ApiResponse(responseCode = "200", description = "Connexion réussie")
    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    AuthResponse login(@Valid @RequestBody LoginRequest request);
}