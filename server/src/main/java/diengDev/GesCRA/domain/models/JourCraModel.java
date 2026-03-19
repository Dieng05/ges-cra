package diengDev.GesCRA.domain.models;

import diengDev.GesCRA.enums.TypeJour;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JourCraModel {

    private UUID id;
    private LocalDate dateJour;
    private TypeJour typeJour;
    private String commentaire;
    private UUID craId;
    private UUID missionId;
}