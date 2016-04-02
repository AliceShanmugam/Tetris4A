package MoteurDeJeu.Pieces;

public class Piece {
    public int[][] tab;
    public static int largeur = 3;

    public Piece(){
        tab = new int[largeur][largeur];

        for (int i=0;i<largeur;i++){
            for (int j=0;j<largeur;j++){
                tab[i][j]=0;
            }
        }
    }

    public void rotation_right(){

        int[][] ret = new int[largeur][largeur];

        for (int i=0;i<largeur;i++){
            for (int j=0;j<largeur;j++){
                ret[i][j] = tab[largeur - j - 1][i];
            }
        }

        tab = ret;
    }

    public void rotation_left(){

        int[][] ret = new int[largeur][largeur];

        for (int i=0;i<largeur;i++){
            for (int j=0;j<largeur;j++){
                ret[i][j] = tab[j][largeur - i - 1];
            }
        }

        tab = ret;
    }

    public String toString(){
        String ret = "";

        for (int i=0;i<largeur;i++){
            for (int j=0;j<largeur;j++){
               ret += tab[i][j];
            }
            ret += "\n";
        }

        return ret;
    }


}
