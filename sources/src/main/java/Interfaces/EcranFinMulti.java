package Interfaces;

public class EcranFinMulti {

    // Score final
    private int score;
    // Score adverese
    private int score2;
    // Vrai si victoire
    private boolean victoire;


    public EcranFinMulti(int score, int score2, boolean victoire) {
        this.score = score;
        this.score2 = score2;
        this.victoire = victoire;
    }

    // Affiche l'ecran
    public void show() {

    }
}
