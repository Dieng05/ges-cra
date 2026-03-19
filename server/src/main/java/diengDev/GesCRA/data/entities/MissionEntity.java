package diengDev.GesCRA.data.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "missions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MissionEntity {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @Column(nullable = false)
    private String titre;

    @Column(nullable = false)
    private LocalDate dateDebut;

    private LocalDate dateFin;

    @Column(length = 2000)
    private String description;

    private String motif;

    @Column(precision = 10, scale = 2)
    private BigDecimal tjm;

    @Column(nullable = false)
    private Boolean active;

    @OneToMany(mappedBy = "mission", fetch = FetchType.LAZY)
    @JsonIgnore
    @Builder.Default
    private List<UtilisateurEntity> utilisateurEntities = new ArrayList<>();

    @OneToMany(mappedBy = "mission", fetch = FetchType.LAZY)
    @JsonIgnore
    @Builder.Default
    private List<AssignmentEntity> assignments = new ArrayList<>();

    @OneToMany(mappedBy = "mission", fetch = FetchType.LAZY)
    @JsonIgnore
    @Builder.Default
    private List<JourCraEntity> joursCra = new ArrayList<>();
}