# Tetris4A

## Architecture

Nous avons architecturé notre logiciel de la manière suivante :

Le programme est divisé en 4 packages et une classe mère. La classe mère instancie les objets principaux des différents packages et gère le fonctionnement global du programme.

Nous avons 3 packages chacun spécialisé dans sa tâche :
- Package moteur de jeu : Ce package contient tout ce qui est en lien avec le jeu: le plateau de jeu, les pièces, le score, etc.
- Package moteur graphique : Ce package gère toute la partie affichage des différentes interfaces et de l'affichage du jeu.
- Package réseau : Ce package s'occupe de la partie communication avec un joueur distant pour une partie multijoueur.

De plus nous avons aussi développé un package test qui contient tous les tests unitaires en AssertJ.

Voici une représentation de l'architecture globale de l'application :

![alt tag](doc/package.png)

Cette architecture nous a permis de séparer notre projet en 3 différentes problématiques : Les graphismes, la logique du jeu et le réseau. Ainsi chacun peut se concentrer uniquement sur sa tâche. Le main permet de faire travailler ensemble les trois parties.

### Package moteur de jeu

Le package est architecturé de la façon suivante :

![alt tag](doc/moteurJeu.png)

La classe Jeu définit un moteur de jeu dans sa généralité : Il contient un plateau de jeu, une prochaine pièce à tomber, un score, etc.

Les classes JeuSolo et JeuMulti sont des spécialisations de cette classe, par exemple JeuMulti intègre un deuxième score et sait gérer les malus.

Un plateau de jeu définit ce qu'est un plateau tetris, ce plateau sera envoyé au moteur graphqiue pour qu'il soit affiché.

Les pieces sont gérés par la classe PieceFactory, nous détaillerons son fonctionnement dans la partie "Exercice Desing Patern".

Les Malus sont gérés par la classe MalusFactory.

### Package moteur graphique

Ce package a un fonctionnement assez simple, la classe MoteurGraphique se charge d'invoquer l'interface graphique et de lancer la frame principale MainFrame qui se charge d'afficher les vues nécessaires. Les vues sont dans le dossier Panels et les différents types d'événements sont définis dans le dossier Events.

![alt tag](doc/moteurgraphique.png)

### Package moteur réseau

Nous avons conçu la partie réseau comme une application P2P simple.

Nous détaillerons son fonctionnement dans la partie exercice.

### Package test

Le package Test contient les tests unitaires du projet. Une classe MainTest permet de lancer les tests contenu dans les différentes classes du package.

![alt tag](doc/test.png)

## Exercice Design Pattern / Solid

### Jeu, JeuSolo et JeuMulti

### Pieces et Factory

### Reseau

