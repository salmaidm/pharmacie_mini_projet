# 🏥 PharmaHOSS – Système de Gestion de Pharmacie

![Java](https://img.shields.io/badge/Java-17+-ED8B00?logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?logo=spring&logoColor=white)
![JavaFX](https://img.shields.io/badge/JavaFX-17+-007ACC?logo=openjdk&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-8.0-4479A1?logo=mysql&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-3.x-C71A36?logo=apache-maven&logoColor=white)

**PharmaHOSS** est une application de gestion complète dédiée aux pharmacies, conçue pour automatiser les opérations quotidiennes : gestion des utilisateurs, produits, stocks, ventes, ordonnances, commandes fournisseurs et rapports analytiques.

L’application suit une architecture **MVC (Modèle-Vue-Contrôleur)** avec :
- **Backend** : API RESTful développée avec **Spring Boot**
- **Frontend** : Interface graphique riche en **JavaFX**
- **Base de données** : **MySQL** pour la persistance des données

---

## 👥 Équipe de développement

| Membre | Rôle |
|--------|------|
| **Salma Id Mhand** | Gestion des utilisateurs & sécurité (authentification, rôles, permissions) |
| **Hajar Benzakour** | Gestion des produits & fournisseurs (catalogue, approvisionnement) |
| **Oumaima Chihab** | Gestion des ventes & ordonnances (transactions, validation médicale) |
| **Salaheddine Ennani** | Gestion des commandes & rapports (statistiques, historiques, export) |

---

## 🛠️ Technologies utilisées

- **Langage** : Java 17+
- **Backend** : Spring Boot, Spring Data JPA, Spring Security
- **Frontend** : JavaFX, Scene Builder
- **Base de données** : MySQL
- **Gestion de dépendances** : Maven
- **IDE recommandé** : IntelliJ IDEA

---

## 🚀 Guide de démarrage

### Prérequis

- [JDK 17 ou supérieur](https://adoptium.net/)
- [Maven](https://maven.apache.org/)
- [MySQL 8.0+](https://www.mysql.com/)
- [Scene Builder](https://gluonhq.com/products/scene-builder/) (optionnel mais recommandé)

---

### 1. Configuration de la base de données

1. Créez une base de données MySQL :
   ```sql
   CREATE DATABASE pharma_hoss;
