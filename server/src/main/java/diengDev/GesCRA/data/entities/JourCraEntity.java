package diengDev.GesCRA.data.entities;

import diengDev.GesCRA.enums.TypeJour;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "jours_cra")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JourCraEntity {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @Column(nullable = false)
    private LocalDate dateJour;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TypeJour typeJour;

    @Column(length = 1000)
    private String commentaire;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cra_id", nullable = false)
    private CraEntity cra;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private MissionEntity mission;
}