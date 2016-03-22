import Interfaces.AccueilResult;
import Interfaces.EcranAccueil;
import Interfaces.EcranFinMulti;
import Interfaces.EcranFinSolo;
import MoteurDeJeu.JeuMulti;
import MoteurDeJeu.JeuSolo;
import MoteurDeJeu.Pieces.Piece;
import MoteurDeJeu.Plateau;
import MoteurGraphique.MoteurGraphiqueSolo;
import MoteurGraphique.MoteurGraphiqueMulti;
import Reseau.Reseau;

public class MainClass {

    public static void main (String[] args){

        // Lancement de l'ecran d'accueil
        EcranAccueil accueil = new EcranAccueil();

        // On récupère le choix de l'utilisateur
        AccueilResult accueilResult = accueil.start();

        // Lancement du mode solo ou multi
        if (accueilResult.solo) {
            startSolo();
        }
        else {
            startMulti(accueilResult.ip);
        }

    }

    // Partie Solo
    private static void startSolo() {

        // Lancement du moteur graphique en mode solo
        MoteurGraphiqueSolo moteurGraphique = new MoteurGraphiqueSolo();
        moteurGraphique.start();

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
            moteurGraphique.update(plateau, nextPiece, score);

            // Définit la vitesse du jeu
            try {
                Thread.sleep(moteurJeu.getSpeed());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        // Affichage de l'ecran de fin
        EcranFinSolo ecranFin = new EcranFinSolo(score);
        ecranFin.show();
    }

    // Partie Multi
    private static void startMulti(String ip) {

        // Lancement du moteur graphique en mode multi
        MoteurGraphiqueMulti moteurGraphique = new MoteurGraphiqueMulti();
        moteurGraphique.start();

        // Lancement du moteur reseau
        Reseau reseau = new Reseau(ip);

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
            moteurGraphique.update(plateau, nextPiece, score, score2, moteurJeu.getMalus());

            // Défini la vitesse du jeu
            try {
                Thread.sleep(moteurJeu.getSpeed());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Affichage de l'ecran de fin
        EcranFinMulti ecranFin = new EcranFinMulti(score, score2, victoire);
        ecranFin.show();
    }
}



