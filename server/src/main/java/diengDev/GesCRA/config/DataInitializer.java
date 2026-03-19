package diengDev.GesCRA.config;

import diengDev.GesCRA.data.entities.*;
import diengDev.GesCRA.data.repositories.*;
import diengDev.GesCRA.enums.*;
import diengDev.GesCRA.enums.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Configuration
@RequiredArgsConstructor
public class DataInitializer {

    private final PasswordEncoder passwordEncoder;

    @Bean
    CommandLineRunner initData(
            UtilisateurJpaRepository utilisateurJpaRepository,
            MissionJpaRepository missionJpaRepository,
            AssignmentJpaRepository assignmentJpaRepository,
            CraJpaRepository craJpaRepository,
            JourCraJpaRepository jourCraJpaRepository
    ) {
        return args -> {

            if (missionJpaRepository.count() > 0) return;

            MissionEntity m1 = missionJpaRepository.save(MissionEntity.builder()
                    .titre("Projet BNP Paribas")
                    .dateDebut(LocalDate.now().minusMonths(6))
                    .dateFin(LocalDate.now().plusMonths(6))
                    .description("Développement fullstack d'une plateforme de gestion de crédits")
                    .motif("Renfort équipe Dev")
                    .tjm(new BigDecimal("580.00"))
                    .active(true)
                    .build());

            MissionEntity m2 = missionJpaRepository.save(MissionEntity.builder()
                    .titre("Projet AXA Assurances")
                    .dateDebut(LocalDate.now().minusMonths(4))
                    .dateFin(LocalDate.now().plusMonths(8))
                    .description("Maintenance applicative et évolutions du SI sinistres")
                    .motif("Support applicatif")
                    .tjm(new BigDecimal("510.00"))
                    .active(true)
                    .build());

            MissionEntity m3 = missionJpaRepository.save(MissionEntity.builder()
                    .titre("Projet Société Générale")
                    .dateDebut(LocalDate.now().minusMonths(3))
                    .dateFin(LocalDate.now().plusMonths(9))
                    .description("Migration vers microservices Spring Boot / Kubernetes")
                    .motif("Transformation digitale")
                    .tjm(new BigDecimal("620.00"))
                    .active(true)
                    .build());

            MissionEntity m4 = missionJpaRepository.save(MissionEntity.builder()
                    .titre("Projet Orange Business")
                    .dateDebut(LocalDate.now().minusMonths(8))
                    .dateFin(LocalDate.now().minusMonths(1))
                    .description("Développement d'une API REST de gestion des abonnements")
                    .motif("Renfort projet critique")
                    .tjm(new BigDecimal("490.00"))
                    .active(false)
                    .build());

            MissionEntity m5 = missionJpaRepository.save(MissionEntity.builder()
                    .titre("Projet Total Energies")
                    .dateDebut(LocalDate.now().minusMonths(2))
                    .dateFin(LocalDate.now().plusMonths(10))
                    .description("Data engineering et pipelines ETL pour le suivi énergétique")
                    .motif("Expertise Data")
                    .tjm(new BigDecimal("650.00"))
                    .active(true)
                    .build());

            UtilisateurEntity u1 = utilisateurJpaRepository.save(UtilisateurEntity.builder()
                    .nom("Martin").prenom("Sophie")
                    .email("admin@gescra.com")
                    .motDePasse(passwordEncoder.encode("admin123"))
                    .actif(true).role(Role.ADMIN)
                    .statutCollaborateur(StatutCollaborateur.EN_MISSION)
                    .typeContrat(TypeContrat.CDI).seniorite(Seniorite.EXPERT)
                    .salaire(new BigDecimal("5200.00")).mission(m1)
                    .build());

            UtilisateurEntity u2 = utilisateurJpaRepository.save(UtilisateurEntity.builder()
                    .nom("Dieng").prenom("Ahmadou")
                    .email("ahmadou.dieng@gescra.com")
                    .motDePasse(passwordEncoder.encode("collab123"))
                    .actif(true).role(Role.COLLABORATEUR)
                    .statutCollaborateur(StatutCollaborateur.EN_MISSION)
                    .typeContrat(TypeContrat.CDI).seniorite(Seniorite.CONFIRME)
                    .salaire(new BigDecimal("2800.00")).mission(m1)
                    .build());

            UtilisateurEntity u3 = utilisateurJpaRepository.save(UtilisateurEntity.builder()
                    .nom("Lefebvre").prenom("Thomas")
                    .email("thomas.lefebvre@gescra.com")
                    .motDePasse(passwordEncoder.encode("collab123"))
                    .actif(true).role(Role.COLLABORATEUR)
                    .statutCollaborateur(StatutCollaborateur.EN_MISSION)
                    .typeContrat(TypeContrat.PORTAGE).seniorite(Seniorite.EXPERT)
                    .salaire(new BigDecimal("3500.00")).mission(m2)
                    .build());

            UtilisateurEntity u4 = utilisateurJpaRepository.save(UtilisateurEntity.builder()
                    .nom("Nguyen").prenom("Linh")
                    .email("linh.nguyen@gescra.com")
                    .motDePasse(passwordEncoder.encode("collab123"))
                    .actif(true).role(Role.COLLABORATEUR)
                    .statutCollaborateur(StatutCollaborateur.INTERCONTRAT)
                    .typeContrat(TypeContrat.INDEPENDANT).seniorite(Seniorite.JUNIOR)
                    .salaire(new BigDecimal("2200.00")).mission(null)
                    .build());

            UtilisateurEntity u5 = utilisateurJpaRepository.save(UtilisateurEntity.builder()
                    .nom("Bernard").prenom("Kevin")
                    .email("kevin.bernard@gescra.com")
                    .motDePasse(passwordEncoder.encode("collab123"))
                    .actif(true).role(Role.COLLABORATEUR)
                    .statutCollaborateur(StatutCollaborateur.EN_MISSION)
                    .typeContrat(TypeContrat.CDI).seniorite(Seniorite.CONFIRME)
                    .salaire(new BigDecimal("4200.00")).mission(m5)
                    .build());


        };
    }
}