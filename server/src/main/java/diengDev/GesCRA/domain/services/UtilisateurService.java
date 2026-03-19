package diengDev.GesCRA.domain.services;

import diengDev.GesCRA.domain.dataports.UtilisateurDataPort;
import diengDev.GesCRA.domain.models.UtilisateurModel;
import diengDev.GesCRA.enums.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UtilisateurService {

    private final UtilisateurDataPort utilisateurDataPort;

    public UtilisateurModel creerUtilisateur(UtilisateurModel utilisateur) {

        if (utilisateur.getEmail() == null || utilisateur.getEmail().isBlank()) {
            throw new RuntimeException("Email obligatoire");
        }

        if (utilisateurDataPort.existsByEmail(utilisateur.getEmail())) {
            throw new RuntimeException("Email déjà utilisé");
        }

        utilisateur.setActif(true);

        if (utilisateur.getRole() == null) {
            utilisateur.setRole(Role.COLLABORATEUR);
        }

        return utilisateurDataPort.save(utilisateur);
    }

    public UtilisateurModel modifierUtilisateur(UUID id, UtilisateurModel utilisateur) {

        UtilisateurModel existing = utilisateurDataPort.findById(id)
                .orElseThrow(() -> new RuntimeException("Utilisateur introuvable"));

        if (existing.getRole() == Role.ADMIN) {
            throw new RuntimeException("Modification interdite pour un administrateur");
        }

        if (utilisateur.getNom() != null) {
            existing.setNom(utilisateur.getNom());
        }

        if (utilisateur.getPrenom() != null) {
            existing.setPrenom(utilisateur.getPrenom());
        }

        if (utilisateur.getStatutCollaborateur() != null) {
            existing.setStatutCollaborateur(utilisateur.getStatutCollaborateur());
        }

        if (utilisateur.getTypeContrat() != null) {
            existing.setTypeContrat(utilisateur.getTypeContrat());
        }

        if (utilisateur.getSeniorite() != null) {
            existing.setSeniorite(utilisateur.getSeniorite());
        }

        if (utilisateur.getSalaire() != null) {
            existing.setSalaire(utilisateur.getSalaire());
        }

        if (utilisateur.getActif() != null) {
            existing.setActif(utilisateur.getActif());
        }

        existing.setMissionId(utilisateur.getMissionId());
        existing.setMissionTitre(utilisateur.getMissionTitre());

        return utilisateurDataPort.save(existing);
    }

    public List<UtilisateurModel> listerUtilisateurs() {
        return utilisateurDataPort.findAll()
                .stream()
                .filter(u -> u.getRole() == Role.COLLABORATEUR)
                .toList();
    }

    public UtilisateurModel getUtilisateur(UUID id) {
        UtilisateurModel utilisateur = utilisateurDataPort.findById(id)
                .orElseThrow(() -> new RuntimeException("Utilisateur introuvable"));

        if (utilisateur.getRole() == Role.ADMIN) {
            throw new RuntimeException("Accès interdit à cet utilisateur");
        }

        return utilisateur;
    }

    public void supprimerUtilisateur(UUID id) {
        UtilisateurModel utilisateur = utilisateurDataPort.findById(id)
                .orElseThrow(() -> new RuntimeException("Utilisateur introuvable"));

        if (utilisateur.getRole() == Role.ADMIN) {
            throw new RuntimeException("Suppression interdite pour un administrateur");
        }

        utilisateurDataPort.deleteById(id);
    }

    public UtilisateurModel activerUtilisateur(UUID id) {
        UtilisateurModel utilisateur = getUtilisateur(id);
        utilisateur.setActif(true);
        return utilisateurDataPort.save(utilisateur);
    }

    public UtilisateurModel desactiverUtilisateur(UUID id) {
        UtilisateurModel utilisateur = getUtilisateur(id);
        utilisateur.setActif(false);
        return utilisateurDataPort.save(utilisateur);
    }
}