package MoteurDeJeu;

import MoteurDeJeu.Pieces.Piece;
import MoteurGraphique.MoteurGraphique;

public class Jeu {

    // Game speed (in ms)
    private int speed;

    // Score du joueur
    private int score;

    // vrai si jeu est fini
    private boolean finish;

    // Plateau du jeu
    private Plateau plateau;

    // Factory de pièces
    private PieceFactory pieceFactory;

    //Variables de jeu
    private Piece nextPiece;
    private Piece currentPiece;
    private int iPiece;
    private int jPiece;
    private boolean fall;
    private int lastSpeed;

    public Jeu(MoteurGraphique moteurGraphique){
        this.speed = 400;
        this.score = 0;
        this.finish = false;
        this.fall = false;
        this.plateau = new Plateau();
        this.pieceFactory = new PieceFactory();
        this.nextPiece = pieceFactory.getRandomPiece();

        this.iPiece = Plateau.largeur/2;
        this.jPiece = Plateau.hauteur-2;
        this.currentPiece = pieceFactory.getRandomPiece();
        this.plateau.addPiece(currentPiece, iPiece, jPiece);

        moteurGraphique.setJeu(this);
    }


    // Fait avancer le jeu d'une étape
    public void go() {

        // Fait tomber le bloc
        if (!plateau.contactBottom()) {
            plateau.gravity();
            jPiece--;
        }

        // Si le bloc arrive en bas
        if (plateau.contactBottom()){

            // Le transforme en structure
            plateau.stopPiece();

            // Fait exploser les lignes
            score += 100 * plateau.explose();

            // Si la structure touche le haut -> fin de partie
            if (plateau.topReached()) {
                finish = true;
            }

            // Ajoute le bloc en haut
            iPiece = Plateau.largeur/2;
            jPiece = Plateau.hauteur-2;
            if ( !finish && plateau.canAddPiece(nextPiece, iPiece, jPiece)){
                currentPiece = nextPiece;
                plateau.addPiece(currentPiece, iPiece, jPiece);
            }
            else {
                // Si ne peut pas ajouter -> fin de partie
                finish = true;
            }

            nextPiece = pieceFactory.getRandomPiece();

            // Stop de la chute si il y'a lieu
            if (fall){
                fall = false;
                speed = lastSpeed;
            }

            // Accélère le jeu petit à petit
            if (speed>200) speed -= 5;
        }
    }

    // Fait tomber la piece rapidement
    public void fall() {
        if (!fall){
            fall = true;
            lastSpeed = speed;
            speed = 25;
        }
    }

    // Methodes de controle des pièces

    public void left() {
        if(!plateau.contactLeft()){
            plateau.moveLeft();
            iPiece--;
        }
    }

    public void right() {
        if(!plateau.contactRight()){
            plateau.moveRight();
            iPiece++;
        }
    }

    public void rotationLeft() {
        currentPiece.rotation_left();
        plateau.removePiece();

        if(plateau.canAddPiece(currentPiece, iPiece, jPiece)){
            plateau.addPiece(currentPiece, iPiece, jPiece);
        }
        else {
            currentPiece.rotation_right();
            plateau.addPiece(currentPiece, iPiece, jPiece);
        }
    }

    public void rotationRight() {
        currentPiece.rotation_right();
        plateau.removePiece();

        if(plateau.canAddPiece(currentPiece, iPiece, jPiece)){
            plateau.addPiece(currentPiece, iPiece, jPiece);
        }
        else {
            currentPiece.rotation_left();
            plateau.addPiece(currentPiece, iPiece, jPiece);
        }
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
