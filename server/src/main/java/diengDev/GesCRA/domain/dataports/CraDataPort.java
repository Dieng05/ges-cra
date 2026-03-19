package diengDev.GesCRA.domain.dataports;

import diengDev.GesCRA.domain.models.CraModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CraDataPort {
    CraModel save(CraModel craModel);
    Optional<CraModel> findById(UUID id);
    Optional<CraModel> findByUtilisateurIdAndMoisAndAnnee(UUID utilisateurId, Integer mois, Integer annee);
    List<CraModel> findAll();
}