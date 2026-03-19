package diengDev.GesCRA.domain.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MissionModel {

    private UUID id;
    private String titre;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String description;
    private String motif;
    private BigDecimal tjm;
    private Boolean active;
}