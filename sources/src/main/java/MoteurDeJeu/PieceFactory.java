package MoteurDeJeu;
import java.util.Random;

public class PieceFactory {
    PieceFactory() {
        //generation nombre random
        int[][] newPiece = new int[4][16];
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 16; j++) {
                    newPiece[i][j] = 0;

                }
            }


        Random rand = new Random();
        int nombre = rand.nextInt(7) + 1;


    }
}
