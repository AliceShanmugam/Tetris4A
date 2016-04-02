package MoteurGraphique.HighScore;

/**
 * Created by asusss on 2.04.2016.
 */

import java.util.Comparator;

public class HighScoreComparator implements Comparator<Score> {
    public int compare(Score score1, Score score2) {

        int sc1 = score1.getScore();
        int sc2 = score2.getScore();

        if (sc1 > sc2){
            return -1;
        }else if (sc1 < sc2){
            return +1;
        }else{
            return 0;
        }
    }
}