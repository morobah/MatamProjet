# MatamprojectTest

MatamprojectTest est une application Spring Boot pour la gestion des équipes dans un contexte sportif.

## Table des Matières

- [Technologies Utilisées](#technologies-utilisées)
- [Configuration](#configuration)
    - [Prérequis](#prérequis)
    - [Installation](#installation)
- [Lancement de l'Application](#lancement-de-lapplication)
- [Utilisation](#utilisation)
    - [Points de Terminaison](#points-de-terminaison)
    - [Exemples d'Utilisation](#exemples-dutilisation)


## Technologies Utilisées

- Java 17
- Spring Boot 3.2.1
- Spring Data JPA
- Spring Web
- H2 Database (pour le développement)
- Maven

## Configuration

### Prérequis

Assurez-vous d'avoir Java et Maven installés sur votre machine.

### Installation

1. Clonez le dépôt :
   ```sh
   git clone https://lien-vers-votre-repo.git

2. Naviguez vers le répertoire du projet : 
   ```sh
   cd matamprojectTest
3. Naviguez vers le répertoire du projet :
   ```sh
   mvn clean install
## Lancement de l'Application
Lancez l'application avec la commande suivante :

mvn spring-boot:run

# Utilisation
### Points de Terminaison
Méthode	URI	Description

| Méthode | URI                | Description               |
|---------|--------------------|---------------------------|
| GET     | /api/equipes       | Récupérer toutes les équipes|
| POST    | /api/equipes       | Ajouter une équipe        |
| GET     | /api/equipes/{id}  | Récupérer une équipe par ID|
| DELETE  | /api/equipes/{id}  | Supprimer une équipe par ID|
| PUT     | /api/equipes/{id}  | Mettre à jour une équipe par ID|

## Exemples d'Utilisation
## Ajouter une nouvelle équipe

Pour ajouter une nouvelle équipe, utilisez la commande cURL suivante :
```sh
curl -X POST -H "Content-Type: application/json" -d '{"nomEquipe": "Équipe A", "acronyme": "EA", "budget": 100000.0}' http://localhost:8087/api/equipes  

