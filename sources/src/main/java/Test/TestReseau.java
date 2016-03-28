package Test;

import MoteurDeJeu.Malus;
import Reseau.Reseau;
import Reseau.Client;

import java.net.InetAddress;
import java.net.UnknownHostException;

import static org.assertj.core.api.Assertions.assertThat;

public class TestReseau {

    public static void Test(){

        // initialistion
        InetAddress ip = null;
        try {
            ip = InetAddress.getByName(InetAddress.getLocalHost().getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        Reseau reseau = new Reseau();


        // Test invitation à soi meme
        reseau.sendInvitation(ip);

        try {
            Thread.sleep(1000);
            assertThat(reseau.ip).isEqualTo(ip);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        catch (AssertionError e){
            e.printStackTrace();
            System.out.print("Echec : Invitation n'a pas réussi\n");
        }

        // Test mis a jour score
        Client client = new Client(ip, "4242");
        client.start();

        try {
            Thread.sleep(1000);
            assertThat(reseau.getOtherScore()).isEqualTo(4242);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        catch (AssertionError e){
            e.printStackTrace();
            System.out.print("Echec : Mis à jour score n'a pas réussi\n");
        }

        // Test mis a jour finish
        client = new Client(ip, "finish");
        client.start();

        try {
            Thread.sleep(1000);
            assertThat(reseau.isFinish()).isEqualTo(true);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        catch (AssertionError e){
            e.printStackTrace();
            System.out.print("Echec : Signal fin de partie n'a pas réussi\n");
        }

        // test d'envoi score et malus à soi meme

        Malus malus = new Malus("Blind",1000);
        reseau.update(6262,malus, true);

        try {
            Thread.sleep(1000);
            assertThat(reseau.getOtherScore()).isEqualTo(6262);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        catch (AssertionError e){
            e.printStackTrace();
            System.out.print("Echec : Envoi du score n'a pas réussi\n");
        }

        try {
            Thread.sleep(1000);
            assertThat(reseau.getMalus().name).isEqualTo("Blind");
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        catch (AssertionError e){
            e.printStackTrace();
            System.out.print("Echec : Envoi du malus n'a pas réussi\n");
        }

        try {
            Thread.sleep(1000);
            assertThat(reseau.getMalus()).isEqualTo(null);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        catch (AssertionError e){
            e.printStackTrace();
            System.out.print("Echec : Malus n'a pas été réinitialisé\n");
        }

        try {
            Thread.sleep(1000);
            assertThat(reseau.isFinish()).isEqualTo(true);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        catch (AssertionError e){
            e.printStackTrace();
            System.out.print("Echec : Envoi du finish n'a pas réussi\n");
        }

        reseau.stop();
    }
}
