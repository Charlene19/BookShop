# BookShop

<!--
*** Thanks for checking out the Best-README-Template. If you have a suggestion
*** that would make this better, please fork the repo and create a pull request
*** or simply open an issue with the tag "enhancement".
*** Thanks again! Now go create something AMAZING! :D
***
***
***
*** To avoid retyping too much info. Do a search and replace for the following:
*** github_username, repo_name, twitter_handle, email, project_title, project_description
-->



<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->
[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]




<!-- PROJECT LOGO -->
<br />
<p align="center">
  <a href="https://github.com/Charlene19/secondeBrain">
    <img src="https://github.com/Charlene19/secondBrain/blob/master/static/img/sdbn.png" alt="Logo" width="80" height="80">
  </a>

  <h3 align="center">BookShop Back</h3>

  <p align="center">
    Application de back-end d'une librairie en ligne. Persistance de données avec JPA sur une base de données SQL Server. Et une interface graphique avec Java FX. 
    <br />
    <a href="https://github.com/Charlene19/secondBrain"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://github.com/Charlene19/BookShop/issues">Report Bug</a>
    ·
    <a href="href="https://github.com/Charlene19/BookShop/issues">Request Feature</a>
  </p>
</p>



<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary><h2 style="display: inline-block">Table of Contents</h2></summary>
  <ol>
    <li>
      <a href="#about-the-project">À propos du projet</a>
      <ul>
        <li><a href="#built-with">Built avec</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Démarrer le projet</a>
      <ul>
        <li><a href="#prérequis">Prérequis</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contribuer</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgements">À savoir</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

![Product Name Screen Shot](https://github.com/Charlene19/Charlene19/blob/main/PortFolio/bACKbs.gif)

BookShop back est une application de gestion de commande d'une librairie monté avec Java 11, Java FX et une base de données SQL Server. Cette application permet de consulter les stocks, ajouter des livres, retirer des livres de la base de données et d'en modifier. Ce CRUD est aussi disponible pour les clients. 
L'application se veut respecteuse des codes UX. Et a une interface assez agréable. 
Une fonction signalant les commandes problèmatiques non-réglées est aussi présente. 


### Built With

* [Java 8 ](https://www.oracle.com/fr/java/technologies/javase-jdk11-downloads.html)
* [Glassfish](https://javaee.github.io/glassfish/)
* [SQL Server](https://www.microsoft.com/fr-fr/sql-server/sql-server-2019)
* [Java FX](https://openjfx.io/)
* [Hibernate](https://hibernate.org/)


<!-- GETTING STARTED -->
## Démarrer le projet

Afin de démarrer le projet, il est nécessaire d'avoir une base de données relationnelle. Les jeu de données ne sont pas disponible mais sont disponibles à la demande. 
Selon votre version de Java, il faudra installer OpenFX, JavaFX n'étant plus une librairie à partir de Java 9.

### Prérequis

* Java 

* OpenFX si > Java 8 

* GlassFish

* Hibernate 

* Jeu de données



### Installation

Mon template peut aussi servir de base :

1. Cloner le repo
   ```sh
   git clone https://github.com/Charlene19/BookShop.git
   ```
2. Démarrer le serveur GlassFish (Ou Tomcat config à modifier)
  
3. Lier le projet à votre base de données avec Hibernate



<!-- USAGE EXAMPLES -->
## Usage

L'application de gestion est diponible mais offre une certaine sécurité puisqu'il faut se logger pour pouvoir accèder aux données : 

![Login](https://github.com/Charlene19/BookShop/blob/master/BookShop/src/views/loginBookShop.png)

Une fois connecté, l'accès à toutes les fonctions est offert :

![Création commande](https://github.com/Charlene19/BookShop/blob/master/BookShop/src/views/creaCommande.png)







<!-- CONTACT -->
## Contact

Je suis joignable via mon [site](https://charlene19.github.io/)


Project Link:  Link: [https://github.com/Charlene19/BookShop/](https://github.com/Charlene19/BookShop/)


<!-- ACKNOWLEDGEMENTS -->
## Acknowledgements

* [Template ReadMe](https://github.com/Charlene19/Best-README-Template/edit/master/README.md)





<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/Charlene19/BookShop.svg?style=for-the-badge
[contributors-url]: https://github.com/Charlene19/BookShop/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/Charlene19/BookShop.svg?style=for-the-badge
[forks-url]: https://github.com/Charlene19/BookShop/network/members
[stars-shield]: https://img.shields.io/github/stars/Charlene19/BookShop.svg?style=for-the-badge
[stars-url]: https://github.com/Charlene19/BookShop/stargazers
[issues-shield]: https://img.shields.io/github/issues/Charlene19/BookShop.svg?style=for-the-badge
[issues-url]: https://github.com/Charlene19/BookShop/issues
[license-shield]: https://img.shields.io/github/license/Charlene19/BookShop.svg?style=for-the-badge
[license-url]: https://github.com/Charlene19/BookShop/blob/master/LICENSE.txt

