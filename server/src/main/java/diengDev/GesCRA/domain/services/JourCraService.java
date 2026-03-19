package diengDev.GesCRA.domain.services;

import diengDev.GesCRA.domain.dataports.JourCraDataPort;
import diengDev.GesCRA.domain.models.JourCraModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class JourCraService {

    private final JourCraDataPort jourCraDataPort;

    public JourCraModel ajouterJour(JourCraModel jour) {
        return jourCraDataPort.save(jour);
    }

    public JourCraModel getJour(UUID id) {
        return jourCraDataPort.findById(id)
                .orElseThrow(() -> new RuntimeException("Jour CRA introuvable"));
    }

    public List<JourCraModel> listerJours() {
        return jourCraDataPort.findAll();
    }
    public JourCraModel modifierJour(JourCraModel jour) {
        JourCraModel existing = jourCraDataPort.findById(jour.getId())
                .orElseThrow(() -> new RuntimeException("Jour CRA introuvable"));

        jour.setId(existing.getId());
        return jourCraDataPort.save(jour);
    }
}