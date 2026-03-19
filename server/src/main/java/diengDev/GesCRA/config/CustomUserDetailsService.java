package diengDev.GesCRA.config;

import diengDev.GesCRA.data.entities.UtilisateurEntity;
import diengDev.GesCRA.data.repositories.UtilisateurJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UtilisateurJpaRepository utilisateurJpaRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UtilisateurEntity utilisateur = utilisateurJpaRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur introuvable : " + username));

        return new User(
                utilisateur.getEmail(),
                utilisateur.getMotDePasse(),
                Boolean.TRUE.equals(utilisateur.getActif()),
                true,
                true,
                true,
                List.of(new SimpleGrantedAuthority("ROLE_" + utilisateur.getRole().name()))
        );
    }
}