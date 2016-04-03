package MoteurDeJeu;

import MoteurGraphique.MoteurGraphique;

public class JeuMulti extends Jeu {

    // Malus envoyé par le joueur adverse
    private Malus malusReceived = null;

    // Malus envoyé par le joueur adverse
    private Malus malusSent = null;
    private int malusTimeOut;

    // Malus facotry
    private MalusFactory malusFactory;

    public JeuMulti(MoteurGraphique moteurGraphique) {
        super(moteurGraphique);
        malusFactory = new MalusFactory();
    }

    public void go(){
        int lastScore = getScore();

        super.go();

        if (getScore()/200 - lastScore/200 > 0){
            malusSent = malusFactory.getRandomMalus();
        }
    }

    public void setMalusReceived(Malus malus) {
        if (malus!=null){
            this.malusReceived = malus;
            this.malusTimeOut = malus.timeout;
        }
    }

    public Malus getMalus() {
        Malus ret = malusSent;
        malusSent = null;
        return ret;
    }

    public Malus getMalusReceived() {
        Malus ret = malusReceived;
        if (malusTimeOut <= 0) {
            malusReceived = null;
        }
        else{
            malusTimeOut--;
        }
        return ret;
    }
}
