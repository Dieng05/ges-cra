package diengDev.GesCRA.domain.dataports;

import diengDev.GesCRA.domain.models.UtilisateurModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UtilisateurDataPort {
    UtilisateurModel save(UtilisateurModel model);
    List<UtilisateurModel> findAll();
    Optional<UtilisateurModel> findById(UUID id);
    Optional<UtilisateurModel> findByEmail(String email);
    boolean existsByEmail(String email);
    void deleteById(UUID id);
}