package diengDev.GesCRA.web.controllers;

import diengDev.GesCRA.config.CustomUserDetailsService;
import diengDev.GesCRA.config.JwtService;
import diengDev.GesCRA.dtos.reponse.AuthResponse;
import diengDev.GesCRA.dtos.request.LoginRequest;
import diengDev.GesCRA.endpoints.AuthEndpoints;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController implements AuthEndpoints {

    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService customUserDetailsService;
    private final JwtService jwtService;

    @Override
    public AuthResponse login(@Valid LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.motDePasse()
                )
        );

        UserDetails userDetails = customUserDetailsService.loadUserByUsername(request.email());
        String token = jwtService.generateToken(userDetails);

        String role = userDetails.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .findFirst()
                .orElse("COLLABORATEUR");

        return new AuthResponse(
                token,
                role,
                userDetails.getUsername(),
                "Connexion réussie"
        );
    }
}