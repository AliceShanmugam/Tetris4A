# Tetris4A

## Architecture

Nous avons architecturé notre logiciel de la manière suivante :

Le programme est divisé en 4 packages et une classe mère. La classe mère instancie les objets principaux des différents packages et gère le fonctionnement globale du programme.

Nous avons 3 packages chacun spécialisé dans sa tâche :
- Package moteur de jeu : Ce package contient tout ce qui est en lien avec le jeu: le plaeau de jeu, les pieces, le score, etc.
- Package moteur graphique : Ce package gère toute la partie affichage des différentes interfaces et de l'affichage du jeu.
- Package reseau : Ce package s'occupe de la partie communiction avec un joueur distant pour une partie multijoueur.

De plus nous avons aussi développé un package test qui contient tous les tests unitaires en AssertJ.

Voici une représentation de l'architecture globale de l'application :

IMAGE

### Package moteur de jeu

Le package est architecturé de la façon suivante :

IMAGE

La classe Jeu définit un moteur de jeu dans sa généralité : Il contient un plateau de jeu, une prochaine piece à tomber, un score, etc.

Les classes JeuSolo et JeuMulti sont des spécialisations de cette classe, par exemple JeuMulti intégre un deuxième score et sait gérer les malus.

Un plateau de jeu définit ce qu'est un plateau tetris, ce plateau sera envoyé au moteur graphqiue pour u'il soit affiché.

Les pieces sont gérés par PieceFactory, nous détaillons sont fonctionnement dans la partie "Exercice Desing Patern".

Les Malus sont gérés par MalusFactory.

### Package moteur graphique

Ce package a un fonctionnement 

### Package moteur réseau

### Package test

## Exercice Design Pattern / Solid
