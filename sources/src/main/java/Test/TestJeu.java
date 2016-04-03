package Test;

import MoteurDeJeu.Jeu;
import MoteurDeJeu.Malus;
import MoteurDeJeu.Plateau;
import MoteurGraphique.MoteurGraphique;
import Reseau.Client;
import Reseau.Reseau;

import java.net.InetAddress;
import java.net.UnknownHostException;

import static org.assertj.core.api.Assertions.assertThat;

public class TestJeu {

    public static void TestPlateau(){

        // initialistion


        Plateau plateau = new Plateau();


        // Test des colisions

        plateau.tab[0][0] = -1;

        try {
            assertThat(plateau.contactBottom()).isTrue();
            assertThat(plateau.contactLeft()).isTrue();
            assertThat(plateau.contactRight()).isFalse();
        }
        catch (AssertionError e){
            e.printStackTrace();
            System.out.print("Echec : Erreur de colision\n");
        }

        plateau.tab[0][0] = 0;
        plateau.tab[Plateau.largeur-1][0] = -1;

        try {
            assertThat(plateau.contactBottom()).isTrue();
            assertThat(plateau.contactLeft()).isFalse();
            assertThat(plateau.contactRight()).isTrue();
        }
        catch (AssertionError e){
            e.printStackTrace();
            System.out.print("Echec : Erreur de colision\n");
        }

        plateau.tab[0][0] = 0;
        plateau.tab[Plateau.largeur-1][0] = 0;
        plateau.tab[1][1] = -1;

        try {
            assertThat(plateau.contactBottom()).isFalse();
            assertThat(plateau.contactLeft()).isFalse();
            assertThat(plateau.contactRight()).isFalse();
        }
        catch (AssertionError e){
            e.printStackTrace();
            System.out.print("Echec : Erreur de colision\n");
        }

        // Test déplacement

        plateau.gravity();

        try {
            assertThat(plateau.tab[1][1]).isEqualTo(0);
            assertThat(plateau.tab[1][0]).isEqualTo(-1);
        }
        catch (AssertionError e){
            e.printStackTrace();
            System.out.print("Echec : Erreur de gravity\n");
        }

        plateau.moveRight();

        try {
            assertThat(plateau.tab[1][0]).isEqualTo(0);
            assertThat(plateau.tab[2][0]).isEqualTo(-1);
        }
        catch (AssertionError e){
            e.printStackTrace();
            System.out.print("Echec : Erreur de moveRight\n");
        }

        plateau.moveLeft();

        try {
            assertThat(plateau.tab[2][0]).isEqualTo(0);
            assertThat(plateau.tab[1][0]).isEqualTo(-1);
        }
        catch (AssertionError e){
            e.printStackTrace();
            System.out.print("Echec : Erreur de moveLeft\n");
        }
    }
}
