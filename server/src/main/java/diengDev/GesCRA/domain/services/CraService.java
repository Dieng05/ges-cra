package diengDev.GesCRA.domain.services;

import diengDev.GesCRA.domain.dataports.CraDataPort;
import diengDev.GesCRA.domain.models.CraModel;
import diengDev.GesCRA.enums.StatutCRA;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CraService {

    private final CraDataPort craDataPort;

    public CraModel creerCra(CraModel cra) {

        LocalDate today = LocalDate.now(ZoneId.of("Europe/Paris"));

        int day = today.getDayOfMonth();

        if (day < 22 || day > 28) {
            throw new RuntimeException("La déclaration CRA est autorisée uniquement entre le 22 et le 28.");
        }

        cra.setStatut(StatutCRA.BROUILLON);

        return craDataPort.save(cra);
    }

    public CraModel soumettreCra(UUID id) {

        CraModel cra = craDataPort.findById(id)
                .orElseThrow(() -> new RuntimeException("CRA introuvable"));

        cra.setStatut(StatutCRA.SOUMIS);

        return craDataPort.save(cra);
    }

    public CraModel validerCra(UUID id) {

        CraModel cra = craDataPort.findById(id)
                .orElseThrow(() -> new RuntimeException("CRA introuvable"));

        cra.setStatut(StatutCRA.VALIDE);

        return craDataPort.save(cra);
    }

    public CraModel rejeterCra(UUID id, String motif) {

        CraModel cra = craDataPort.findById(id)
                .orElseThrow(() -> new RuntimeException("CRA introuvable"));

        cra.setStatut(StatutCRA.REJETE);
        cra.setMotifDecision(motif);

        return craDataPort.save(cra);
    }

    public List<CraModel> listerCra() {
        return craDataPort.findAll();
    }

    public CraModel getCra(UUID id) {
        return craDataPort.findById(id)
                .orElseThrow(() -> new RuntimeException("CRA introuvable"));
    }

    public CraModel getCraByUtilisateurEtPeriode(UUID utilisateurId, Integer mois, Integer annee) {
        return craDataPort.findByUtilisateurIdAndMoisAndAnnee(utilisateurId, mois, annee)
                .orElseThrow(() -> new RuntimeException("CRA introuvable"));
    }

    public CraModel invaliderCra(UUID id, String motif) {
        CraModel cra = craDataPort.findById(id)
                .orElseThrow(() -> new RuntimeException("CRA introuvable"));

        cra.setStatut(StatutCRA.INVALIDE);
        cra.setMotifDecision(motif);

        return craDataPort.save(cra);
    }
}