package MoteurDeJeu;

import MoteurDeJeu.Pieces.Piece;

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

        for (int i=0; i < largeur; i++){
            if(tab[i][0] < 0) {
                ret = true;
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

        for (int j=0; j < hauteur; j++){
            if(tab[0][j] < 0){
                ret = true;
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

        for (int j=0; j < hauteur; j++){
            if(tab[largeur-1][j] < 0){
                ret = true;
            }
        }

        return ret;
    }

    //------------------
    // Ajout de piece
    //------------------

    // Ajoute une piece centré en i,j
    public void addPiece(Piece piece, int i, int j){
        if (i>0 && j<hauteur-1 && piece.tab[0][0]!=0) tab[i-1][j+1] = piece.tab[0][0] * -1;
        if ( j<hauteur-1 && piece.tab[0][1]!=0) tab[i][j+1] = piece.tab[0][1] * -1;
        if (i<largeur-1 && j<hauteur-1 && piece.tab[0][2]!=0) tab[i+1][j+1] = piece.tab[0][2] * -1;

        if (i>0 && piece.tab[1][0]!=0) tab[i-1][j] = piece.tab[1][0] * -1;
        if (piece.tab[1][1]!=0) tab[i][j] = piece.tab[1][1] * -1;
        if (i<largeur-1 && piece.tab[1][2]!=0) tab[i+1][j] = piece.tab[1][2] * -1;

        if (i>0 && j>0 && piece.tab[2][0]!=0) tab[i-1][j-1] = piece.tab[2][0] * -1;
        if (j>0 && piece.tab[2][1]!=0) tab[i][j-1] = piece.tab[2][1] * -1;
        if (i<largeur-1 && j>0 && piece.tab[2][2]!=0) tab[i+1][j-1] = piece.tab[2][2] * -1;
    }

    // Vérifie si l'on peut ajouter la piece en i,j (i != 0, i!= largeur-1, j != 0
    public boolean canAddPiece(Piece piece, int i, int j){

        // hors de bornes
        if(i < 0 || i > largeur-1 || j <= 0 || j >= hauteur-1){
            return false;
        }

        // dépasse à gauche
        if (i==0){
            if (piece.tab[0][0] + piece.tab[1][0] + piece.tab[2][0] == 0){
                if (piece.tab[0][1] != 0 && tab[i][j+1]!=0 ) return false;
                if (piece.tab[0][2] != 0 && tab[i+1][j+1]!=0 ) return false;

                if (piece.tab[1][1] != 0 && tab[i][j]!=0 ) return false;
                if (piece.tab[1][2] != 0 && tab[i+1][j]!=0 ) return false;

                if (piece.tab[2][1] != 0 && tab[i][j-1]!=0 ) return false;
                if (piece.tab[2][2] != 0 && tab[i+1][j-1]!=0 ) return false;

                return true;
            }
            else{
                return false;
            }
        }

        // dépasse à droite
        if (i==largeur-1){
            if (piece.tab[0][2] + piece.tab[1][2] + piece.tab[2][2] == 0){
                if (piece.tab[0][0] != 0 && tab[i-1][j+1]!=0 ) return false;
                if (piece.tab[0][1] != 0 && tab[i][j+1]!=0 ) return false;

                if (piece.tab[1][0] != 0 && tab[i-1][j]!=0 ) return false;
                if (piece.tab[1][1] != 0 && tab[i][j]!=0 ) return false;

                if (piece.tab[2][0] != 0 && tab[i-1][j-1]!=0 ) return false;
                if (piece.tab[2][1] != 0 && tab[i][j-1]!=0 ) return false;

                return true;
            }
            else {
                return false;
            }
        }

        // Verifie les colisions

        if (piece.tab[0][0] != 0 && tab[i-1][j+1]!=0 ) return false;
        if (piece.tab[0][1] != 0 && tab[i][j+1]!=0 ) return false;
        if (piece.tab[0][2] != 0 && tab[i+1][j+1]!=0 ) return false;

        if (piece.tab[1][0] != 0 && tab[i-1][j]!=0 ) return false;
        if (piece.tab[1][1] != 0 && tab[i][j]!=0 ) return false;
        if (piece.tab[1][2] != 0 && tab[i+1][j]!=0 ) return false;

        if (piece.tab[2][0] != 0 && tab[i-1][j-1]!=0 ) return false;
        if (piece.tab[2][1] != 0 && tab[i][j-1]!=0 ) return false;
        if (piece.tab[2][2] != 0 && tab[i+1][j-1]!=0 ) return false;

        return true;
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

    //Convertit le bloc tombant en structure
    public void stopPiece(){
        for (int i=0; i < largeur; i++){
            for (int j=0; j < hauteur; j++){
                if (tab[i][j] < 0){
                    tab[i][j] = -1 * tab[i][j];
                }
            }
        }
    }

    // Renvoi si la structure a atteint le haut
    public boolean topReached() {
        for (int i=0; i<largeur; i++){
            if (tab[i][hauteur-1] > 0 ) return true;
        }

        return false;
    }


    // Retire la piece du plateau
    public void removePiece() {
        for (int i=0; i < largeur; i++){
            for (int j=0; j < hauteur; j++){
                if (tab[i][j] < 0){
                    tab[i][j] = 0;
                }
            }
        }
    }

    // Pour l'affichage dans la console
    public String toString(){
        String ret = "";

        for (int j=hauteur-1; j >= 0; j--){
            for (int i=0; i < largeur; i++){
                ret += tab[i][j];
            }
            ret += "\n";
        }

        return ret;
    }
}
