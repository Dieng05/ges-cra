package diengDev.GesCRA.domain.models;

import diengDev.GesCRA.enums.StatutCRA;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CraModel {
    private UUID id;
    private Integer mois;
    private Integer annee;
    private StatutCRA statut;
    private LocalDateTime dateSoumission;
    private LocalDateTime dateValidation;
    private String motifDecision;
    private UUID utilisateurId;
    private List<JourCraModel> jours;
}