package Reseau;

import MoteurDeJeu.Malus.Malus;

public class Reseau {

    // Score du joueur adverse
    private int otherScore = 0;

    // Malus envoyé par le joueur adverse
    private Malus malusReceived = null;

    // Malus a envoyé au joueur adverse
    private Malus malusToSend = null;

    // Vrai si le joueur adverse a perdu
    private boolean finish = false;

    // IP du joueur adverse
    private String ip;

    public Reseau(String ip) {
        this.ip = ip;
    }

    // Renvoi le malus et le réinitialise
    public Malus getMalus() {
        return malusReceived;
    }

    // Envoi un malus au joueur adverse
    public void setMalus(Malus malus) {
        malusToSend = malus;
    }

    // Getters and Setters

    public int getOtherScore() {
        return otherScore;
    }

    public boolean isFinish() {
        return finish;
    }
}
