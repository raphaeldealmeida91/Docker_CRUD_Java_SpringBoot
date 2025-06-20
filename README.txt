# Projet Docker + Spring Boot

## Démarrage de l'application

1. Assurez-vous d'avoir Docker et Docker Compose installés.
   cd docker
   docker compose up --build

3. Cela va :
   - Construire et démarrer un conteneur PostgreSQL avec la base de données.
   - Construire et démarrer l'application Spring Boot sur le port 8080.

4. L'application sera accessible via : http://localhost:8080

---

## Remplacer le projet Spring Boot

Le dossier `app/` contient le projet Spring Boot actuel (avec Maven, Java 17, et dépendances courantes).

Pour utiliser un autre projet Spring Boot :

1. Supprimez le contenu actuel dans `app/`.
2. Placez votre nouveau projet Spring Boot dans ce dossier.
3. Par défaut, il doit utiliser :
   - Java 17
   - Maven comme outil de build
   - Dépendances typiques telles que Spring Web, Spring Data JPA, et PostgreSQL Driver
4. Modifiez le Dockerfile si besoin (ex : nom du jar généré).
5. Relancez `docker compose up --build` pour reconstruire et redémarrer l'application.

---

## Variables d'environnement

Les variables suivantes sont utilisées pour la configuration :

- POSTGRES_DB : nom de la base PostgreSQL (ex : mydb)
- POSTGRES_USER : utilisateur PostgreSQL (ex : myuser)
- POSTGRES_PASSWORD : mot de passe PostgreSQL
- DB_HOST : nom du service PostgreSQL dans Docker Compose (ex : db)
- DB_PORT : port PostgreSQL (ex : 5432)
- DB_NAME : nom de la base à utiliser (ex : mydb)

Ces variables sont définies dans un fichier `.env` ou dans l'environnement shell.

---

## Notes

- La base de données est persistée dans un volume Docker nommé `pgdata`.
- Si vous modifiez la structure des entités JPA, pensez à gérer les migrations de la base.
- Le port 8080 est exposé pour l'accès HTTP à l'application Spring Boot.

