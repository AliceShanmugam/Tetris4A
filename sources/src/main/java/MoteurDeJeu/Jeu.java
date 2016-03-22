package MoteurDeJeu;

import MoteurDeJeu.Pieces.Piece;

public class Jeu {

    // Game speed (in ms)
    private int speed;

    // Score du joueur
    private int score;

    // vrai si jeu est fini
    private boolean finish;

    // Plateau du jeu
    private Plateau plateau;

    // Prochane piece à tomber
    private Piece nextPiece;

    public Jeu(){
        this.speed = 1000;
        this.score = 0;
        this.finish = false;
        this.plateau = new Plateau();
    }


    // Fait avancer le jeu d'une étape
    public void go() {

    }


    // Getters et Setters
    public int getSpeed() {
        return speed;
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public int getScore() {
        return score;
    }

    public boolean isFinish() {
        return finish;
    }

    public Piece getNextPiece() {
        return nextPiece;
    }
}
