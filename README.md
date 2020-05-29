# 8INF853 - Projet

## Structure du projet
```
|- documents/       # rapports, diagrammes, spécifications, etc.
|- StableManager/   # Java EE application (projet IntelliJ avec support de Maven)
```

## Environnement recommandé
- [Oracle JDK 8 Update 144](https://www.oracle.com/java/technologies/javase/javase8-archive-downloads.html) (*Java SE Development Kit 8u144*)
- [GlassFish 5.0.1](https://javaee.github.io/glassfish/download)
- [IntelliJ IDEA 2020.1.1 ULTIMATE](https://www.jetbrains.com/idea/download/#section=linux)

Les dépendances aux librairies externes sont gérées via Maven (installation automatique). Nous utilisons en particulier les technologies suivantes :
- `Apache Struts2`
- `Spring Security`
- `MySQL`

## User stories
- [ ] Employés
    - [ ] Connexion / déconnexion
    - [ ] Voir un profil utilisateur
    - [ ] Modifier son profil
    - [ ] Voir son planning
    - [ ] Modifier son planning
    - [ ] Voir ses prochains cours
- [ ] Chevaux
    - [ ] Voir la liste des chevaux
    - [ ] Voir un cheval: carte d'identité, dossier médical, locations
    - [ ] Créer un cheval
    - [ ] Modifier sa carte d'identité
    - [ ] Ajouter une entrée à son dossier médical
    - [ ] Suppimer le cheval
- [ ] Materiel
    - [ ] Voir la liste du materiel
    - [ ] Voir un materiel: carte d'identité, locations
    - [ ] Créer un materiel
    - [ ] Modifier sa carte d'identité
    - [ ] Suppimer le materiel
- [ ] Corrals
    - [ ] Voir la liste du materiel
    - [ ] Voir un corral: carte d'identité, locations
    - [ ] Créer un corral
    - [ ] Modifier sa carte d'identité
    - [ ] Suppimer le corral
- [ ] Recherche des ressources
    - [ ] Interface de recherche simple
    - [ ] Interface de recherche avancée avec options (recherche croisée)
- [ ] Locations
    - [ ] Voir la liste des locations
    - [ ] Voir la liste des locations filtrées par ressources
    - [ ] Voir une location
    - [ ] Créer une location
    - [ ] Modifier une location
    - [ ] Supprimer une location
    - [ ] Imprimer la facture d'une location
- [ ] Cours
    - [ ] Voir la liste des cours
    - [ ] Voir un cours : status (reservé ou non), description, participant
    - [ ] Créer un cours
    - [ ] Modifier un cours
    - [ ] Supprimer un cours
    - [ ] Imprimer la facture lié au cours


## Auteurs
- [Romain Guillot - romain.guillot1@uqac.ca](mailto:romain.guillot1@uqac.ca)
- [Olivier Baurain - olivier.baurain1@uqac.ca](mailto:olivier.baurain1@uqac.ca)
