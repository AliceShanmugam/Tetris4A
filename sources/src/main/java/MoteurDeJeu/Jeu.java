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

    // Factory de pièces
    private PieceFactory pieceFactory;

    public Jeu(){
        this.speed = 1000;
        this.score = 0;
        this.finish = false;
        this.plateau = new Plateau();
        this.pieceFactory = new PieceFactory();
        this.nextPiece = pieceFactory.getRandomPiece();
        this.plateau.addPiece(pieceFactory.getRandomPiece(), Plateau.largeur/2, Plateau.hauteur-2);
    }


    // Fait avancer le jeu d'une étape
    public void go() {

        // Fait tomber le bloc
        plateau.gravity();

        // Si le bloc arrive en bas
        if (plateau.contactBottom()){

            // Le transforme en structure
            plateau.stopPiece();

            // Fait exploser les lignes
            score += 100 * plateau.explose();

            // Si la structure touche le haut -> fin de partie
            if (plateau.topReached()) {
                finish = true;
                System.out.println("ligne pleine");
            }

            // Ajoute le bloc en haut
            if ( !finish && plateau.canAddPiece(nextPiece, Plateau.largeur/2, Plateau.hauteur-2)){
                plateau.addPiece(nextPiece, Plateau.largeur/2, Plateau.hauteur-2);
            }
            else {
                // Si ne peut pas ajouter -> fin de partie
                finish = true;
                System.out.println("ajout imp");
            }

            nextPiece = pieceFactory.getRandomPiece();
        }

        // Accélère le jeu petit à petit
        speed += 10;
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
