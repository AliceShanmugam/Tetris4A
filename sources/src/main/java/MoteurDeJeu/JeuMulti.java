package MoteurDeJeu;

import MoteurDeJeu.Malus.Malus;
import MoteurGraphique.MoteurGraphiqueMulti;

public class JeuMulti extends Jeu {

    // Malus envoyé par le joueur adverse
    private Malus malusReceived = null;

    // Malus envoyé par le joueur adverse
    private Malus malusSent = null;

    public JeuMulti(MoteurGraphiqueMulti moteurGraphique) {

    }

    public void setMalusReceived(Malus malus) {
        this.malusReceived = malus;
    }

    public Object getMalus() {
        return malusSent;
    }
}
