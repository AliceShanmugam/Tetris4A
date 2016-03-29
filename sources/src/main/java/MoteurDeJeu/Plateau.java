package MoteurDeJeu;

public class Plateau {
    public int[][] tab;
    public static int hauteur = 20;
    public static int largeur = 10;

    public Plateau(){
        tab = new int[largeur][hauteur];
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
