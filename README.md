# Controle-Atelier-4

# Activité-Pratique-N-2-JEE

## Dans cet atelier nous avons:

1. Installer IntelliJ Ultimate
2. Créer un projet Spring Initializer avec les dépendances JPA, H2, Spring Web et Lombock
3. Créer l'entité JPA Patient ayant les attributs :
       - id de type Long
       - nom de type String
       - dateNaissanec de type Date
       - malade de type boolean
       - score de type int
4. Configurer l'unité de persistance dans le ficher application.properties 
5. Créer l'interface JPA Repository basée sur Spring data
6. Tester quelques opérations de gestion de patients :
    - Ajouter des patients
    - Consulter tous les patients
    - Consulter un patient
    - Chercher des patients
    - Mettre à jour un patient 
    - supprimer un patient
7. Migrer de H2 Database vers MySQL 

## Les dependances utilisées dans cet atelier sont:
 -Lombok : Un outil de bibliothèque Java qui génère du code pour minimiser le code ‘boilerplate’. La bibliothèque remplace le code ‘boilerplate’ par des annotations faciles à utiliser (Exemples : @NoArgsConstructor, @Getter, @Setter…). 
 
 -Spring Web : pour créer des applications Web, y compris RESTful, à l'aide de Spring MVC. Utilise Apache Tomcat comme conteneur intégré par défaut.
 
 -Spring DATA JPA : Pour conserver les données dans ‘SQL stores‘ avec Java Persistance API à l’aide de Spring Data et Hibernate. C'est un module qui facilite le ORM basé sur JPA. Il est utilisé avec les bases de données relationnelles.
 
  -H2 Database : Une base de données intégrée, open source et en mémoire. C'est un système de gestion de base de données relationnelle écrit en Java. C'est une application client/serveur et elle est généralement utilisée dans les tests unitaires.
  
  -MySQL : MySQL est l'un des systèmes de bases de données relationnelles les plus populaires et il est souvent utilisé dans les applications Spring Boot.
