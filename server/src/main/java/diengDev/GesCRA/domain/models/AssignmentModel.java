package diengDev.GesCRA.domain.models;

import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssignmentModel {
    private UUID id;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private UUID utilisateurId;
    private UUID missionId;
}