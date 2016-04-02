package MoteurGraphique.HighScore;

/**
 * Created by asusss on 2.04.2016.
 */
import java.io.Serializable;

public class Score  implements Serializable {
    private int score;
    private String naam;

    public int getScore() {
        return score;
    }

    public String getNaam() {
        return naam;
    }

    public Score(String naam, int score) {
        this.score = score;
        this.naam = naam;
    }
}