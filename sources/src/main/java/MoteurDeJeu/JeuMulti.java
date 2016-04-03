package MoteurDeJeu;

import MoteurGraphique.MoteurGraphique;

public class JeuMulti extends Jeu {

    // Malus envoyé par le joueur adverse
    private Malus malusReceived = null;

    // Malus envoyé par le joueur adverse
    private Malus malusSent = null;

    public JeuMulti(MoteurGraphique moteurGraphique) {
        super(moteurGraphique);
    }

    public void setMalusReceived(Malus malus) {
        this.malusReceived = malus;
    }

    public Malus getMalus() {
        return malusSent;
    }

    public Malus getMalusReceived() {
        Malus ret = malusReceived;
        malusReceived = null;
        return ret;
    }
}
