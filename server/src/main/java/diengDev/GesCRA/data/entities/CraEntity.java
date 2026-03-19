package diengDev.GesCRA.data.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import diengDev.GesCRA.enums.StatutCRA;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "cras")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CraEntity {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @Column(nullable = false)
    private Integer mois;

    @Column(nullable = false)
    private Integer annee;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatutCRA statut;

    private LocalDateTime dateSoumission;

    private LocalDateTime dateValidation;

    @Column(length = 1000)
    private String motifDecision;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "utilisateur_id", nullable = false)
    private UtilisateurEntity utilisateur;

    @OneToMany(mappedBy = "cra", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    @Builder.Default
    private List<JourCraEntity> jours = new ArrayList<>();
}