# Rapport Documentation

## Contrainte principale

### backend :
    Spring Boot (Java)
    Spring Boot (Java)
    Architecture Clean Architecture
    API REST
    Sécurité JWT (JSON Web Token)
### Frontend
    Angular
    Bibliothèques utilisées :
    PrimeNG : bibliothèque de composants UI pour Angular
    PrimeFlex : bibliothèque CSS utilitaire pour la mise en page
### Base de données
    PostgreSQL
## Architecture du projet
   ### Hexagonale et modulaire 
    - Module Api-Rest (declaration des contrats interface)
      (enums, dtos, endpoints)


    - Module Server   (code métier)
    avec isolation des couche :
    - domain (models, services, dataports)
    - data (entities, repositories, adapters, mappers (entity to model et model to entities)
    - web (controllers, mappers (dtos to models et models to dtos)
    - couche config

    - front angular 'single page'
     couche core ( models, services, gards, interceptors)
     couche features (pages)
     couche shared composant partager)

## réaliser 

    ### mise en place de l'architecture
    ### modelisations de la base de données
    ### connexion avec génération de token jwt avec deux role : admin et collaborateur
    ### crud collaborateur
    ### Auth + guards

## reste a faire
    ### CRUD Missions
    ### Affectations missions
    ### Workflow CRA :
    ### Règles 22–28
    ### API validation admin
    ### Dashboard Collaborateur :
    ### Vue mensuelle CRA
    ### Remplissage rapide
    ### Gestion erreurs métier
  
## percepectives
    ### Dockerisation
    ### mise en place d'un design patern état pour la gestion des etats sur le workflow de CRA. 
