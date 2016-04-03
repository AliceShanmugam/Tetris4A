import MoteurDeJeu.JeuMulti;
import MoteurDeJeu.JeuSolo;
import MoteurDeJeu.Pieces.Piece;
import MoteurDeJeu.Plateau;
import MoteurGraphique.MoteurGraphique;
import Reseau.Reseau;

import java.net.InetAddress;

public class MainClass {


    private static boolean isMulti=false;

    public static void main (String[] args){


        MoteurGraphique moteurGraphique = new MoteurGraphique();

        while(!moteurGraphique.play){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (moteurGraphique.ip == null){
            isMulti=false;
            startSolo(moteurGraphique);
        }
        else{
            isMulti=true;
            startMulti(moteurGraphique, moteurGraphique.ip);
        }

    }

    // Partie Solo
    private static void startSolo(MoteurGraphique moteurGraphique) {

        //Lancement du moteur de jeu solo
        JeuSolo moteurJeu = new JeuSolo(moteurGraphique);


        // Initialisation des variables
        boolean finish = false;
        int score = 0;
        Plateau plateau;
        Piece nextPiece;

        // Coeur du jeu
        while(!finish){

            // On avance l'état du jeu
            moteurJeu.go();

            // On récupère le nouvel état du jeu
            plateau = moteurJeu.getPlateau();
            score = moteurJeu.getScore();
            finish = moteurJeu.isFinish();
            nextPiece = moteurJeu.getNextPiece();

            // On met à jour l'affichage
            moteurGraphique.showGame(plateau, nextPiece, score,-1, null,isMulti);

            // Définit la vitesse du jeu
            try {
                Thread.sleep(moteurJeu.getSpeed());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        // Affichage de l'ecran de fin
        moteurGraphique.showEndScreenSolo(score);
    }

    // Partie Multi
    private static void startMulti(MoteurGraphique moteurGraphique, InetAddress ip) {

        // Lancement du moteur reseau
        Reseau reseau = new Reseau();

        System.out.print("multi");

        //Lancement du moteur de jeu multi
        JeuMulti moteurJeu = new JeuMulti(moteurGraphique);

        // Initialisation des variables
        boolean finish = false;
        boolean victoire = true;
        int score = 0;
        int score2 = 0;
        Plateau plateau;
        Piece nextPiece;

        // Coeur du jeu
        while(!finish){

            // On recupere l'etat du jeu adverse
            score2 = reseau.getOtherScore();

            // On applique un malus si nécessaire
            moteurJeu.setMalusReceived(reseau.getMalus());

            // On avance l'état du jeu
            moteurJeu.go();

            // On récupère le nouvel état du jeu
            plateau = moteurJeu.getPlateau();
            score = moteurJeu.getScore();
            nextPiece = moteurJeu.getNextPiece();

            // Fin de partie si tel est le cas
            if(moteurJeu.isFinish()){
                finish = true;
                victoire = false;
            }
            if(reseau.isFinish()){
                finish = true;
                victoire = true;
            }

            // On met à jour l'affichage
            moteurGraphique.showGame(plateau, nextPiece, score, score2, moteurJeu.getMalusReceived(),isMulti);

            //on envoi les données à l'autre joueur
            reseau.update(score, moteurJeu.getMalus(), moteurJeu.isFinish());

            // Défini la vitesse du jeu
            try {
                Thread.sleep(moteurJeu.getSpeed());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Affichage de l'ecran de fin
        moteurGraphique.showEndScreenMulti(score, score2, victoire);
    }
}



