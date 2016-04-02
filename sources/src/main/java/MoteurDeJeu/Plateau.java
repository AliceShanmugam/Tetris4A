package MoteurDeJeu;

public class Plateau {
    public int[][] tab;
    public static int hauteur = 20;
    public static int largeur = 12;

    public Plateau(){
        tab = new int[largeur][hauteur];
        for (int i=0; i < largeur; i++){
            for (int j=0; j < hauteur; j++){
                tab[i][j] = 0;
            }
        }
    }

    //----------------------
    //Deplacement de pièces
    //----------------------

    // Fait tomber la piece de 1 cran renvoi true si la piece a toucher le bas
    public void gravity(){

        for (int i=0; i < largeur; i++){
            for (int j=1; j < hauteur; j++){
                if(tab[i][j] < 0){
                    tab[i][j-1] = tab[i][j];
                    tab[i][j] = 0;
                }
            }
        }

    }

    // Fait bouger la piece vers la gauche
    public void moveLeft(){

        for (int i=1; i < largeur; i++){
            for (int j=0; j < hauteur; j++){
                if(tab[i][j] < 0){
                    tab[i-1][j] = tab[i][j];
                    tab[i][j] = 0;
                }
            }
        }

    }

    // Fait bouger la piece vers la droite
    public void moveRight(){

        for (int i=largeur-2; i >= 0; i--){
            for (int j=0; j < hauteur; j++){
                if(tab[i][j] < 0){
                    tab[i+1][j] = tab[i][j];
                    tab[i][j] = 0;
                }
            }
        }

    }

    //----------------------
    //Verification de contact
    //----------------------

    // Verifie si il y'a contact en bas
    public boolean contactBottom() {
        boolean ret = false;

        for (int i=0; i < largeur; i++){
            for (int j=1; j < hauteur; j++){
                if(tab[i][j] < 0 && tab[i][j-1] > 0){
                    ret = true;
                }
            }
        }

        return ret;
    }

    // Verifie si il y'a contact à gauche
    public boolean contactLeft(){
        boolean ret = false;

        for (int i=1; i < largeur; i++){
            for (int j=0; j < hauteur; j++){
                if(tab[i][j] < 0 && tab[i-1][j] > 0){
                    ret = true;
                }
            }
        }

        return ret;
    }

    // Verifie si il y'a contact à droite
    public boolean contactRight(){
        boolean ret = false;

        for (int i=largeur-2; i >= 0; i--){
            for (int j=0; j < hauteur; j++){
                if(tab[i][j] < 0 && tab[i+1][j] > 0){
                    ret = true;
                }
            }
        }

        return ret;
    }


    //-------------------
    // Autre méthodes
    //-------------------

    // Fait exploser les lignes et reajuste le plateau
    public int explose() {
        int ret = 0;
        int c;

        for (int j=0; j < hauteur; j++){

            c = 0;

            // Recherche de lignes pleines
            for (int i=0; i < largeur; i++){
                if (tab[i][j] > 0){
                    c++;
                }
            }

            // Si ligne pleine, elle est détruite et le dessus est décalé
            if (c == largeur){
                for (int i=0; i < largeur; i++){
                    tab[i][j] = 0;
                }

                for (int t=j+1; t < hauteur; t++){
                    for (int i=0; i < largeur; i++){
                        tab[i][t-1] = tab[i][t];
                    }
                }

                for (int i=0; i < largeur; i++){
                    tab[i][hauteur-1] = 0;
                }

                j--;
                ret++;
            }
        }

        return ret;
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
