package diengDev.GesCRA.data.adapters;

import diengDev.GesCRA.data.entities.CraEntity;
import diengDev.GesCRA.data.entities.UtilisateurEntity;
import diengDev.GesCRA.data.mappers.CraEntityMapper;
import diengDev.GesCRA.data.mappers.JourCraEntityMapper;
import diengDev.GesCRA.data.repositories.CraJpaRepository;
import diengDev.GesCRA.data.repositories.JourCraJpaRepository;
import diengDev.GesCRA.data.repositories.UtilisateurJpaRepository;
import diengDev.GesCRA.domain.dataports.CraDataPort;
import diengDev.GesCRA.domain.models.CraModel;
import diengDev.GesCRA.domain.models.JourCraModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CraDataAdapter implements CraDataPort {

    private final CraJpaRepository craJpaRepository;
    private final JourCraJpaRepository jourCraJpaRepository;
    private final UtilisateurJpaRepository utilisateurJpaRepository;
    private final CraEntityMapper craEntityMapper;
    private final JourCraEntityMapper jourCraEntityMapper;

    @Override
    public CraModel save(CraModel craModel) {
        UtilisateurEntity utilisateur = utilisateurJpaRepository.findById(craModel.getUtilisateurId())
                .orElseThrow(() -> new IllegalArgumentException("Utilisateur introuvable"));

        CraEntity entity;

        if (craModel.getId() != null && craJpaRepository.existsById(craModel.getId())) {
            entity = craJpaRepository.findById(craModel.getId()).orElseThrow();
            craEntityMapper.updateEntity(entity, craModel, utilisateur);
        } else {
            entity = craEntityMapper.toEntity(craModel, utilisateur);
        }

        CraEntity saved = craJpaRepository.save(entity);

        CraModel result = craEntityMapper.toModel(saved);
        List<JourCraModel> jours = jourCraJpaRepository.findByCraId(saved.getId())
                .stream()
                .map(jourCraEntityMapper::toModel)
                .toList();
        result.setJours(jours);

        return result;
    }

    @Override
    public Optional<CraModel> findById(UUID id) {
        return craJpaRepository.findById(id).map(entity -> {
            CraModel model = craEntityMapper.toModel(entity);
            List<JourCraModel> jours = jourCraJpaRepository.findByCraId(entity.getId())
                    .stream()
                    .map(jourCraEntityMapper::toModel)
                    .toList();
            model.setJours(jours);
            return model;
        });
    }

    @Override
    public Optional<CraModel> findByUtilisateurIdAndMoisAndAnnee(UUID utilisateurId, Integer mois, Integer annee) {
        return craJpaRepository.findByUtilisateurIdAndMoisAndAnnee(utilisateurId, mois, annee)
                .map(entity -> {
                    CraModel model = craEntityMapper.toModel(entity);
                    List<JourCraModel> jours = jourCraJpaRepository.findByCraId(entity.getId())
                            .stream()
                            .map(jourCraEntityMapper::toModel)
                            .toList();
                    model.setJours(jours);
                    return model;
                });
    }

    @Override
    public List<CraModel> findAll() {
        return craJpaRepository.findAll()
                .stream()
                .map(entity -> {
                    CraModel model = craEntityMapper.toModel(entity);
                    List<JourCraModel> jours = jourCraJpaRepository.findByCraId(entity.getId())
                            .stream()
                            .map(jourCraEntityMapper::toModel)
                            .toList();
                    model.setJours(jours);
                    return model;
                })
                .toList();
    }
}