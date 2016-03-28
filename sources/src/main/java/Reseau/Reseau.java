package Reseau;

import MoteurDeJeu.Malus;
import java.net.*;

public class Reseau {

    // Score du joueur adverse
    private int otherScore = 0;

    // Malus envoyé par le joueur adverse
    private Malus malusReceived = null;

    // Vrai si le joueur adverse a perdu
    private boolean finish = false;

    // IP du joueur adverse et mon IP
    public InetAddress ip;

    // Serveur
    Serveur serveur;

    public Reseau() {
        serveur = new Serveur(this);
        serveur.start();
    }

    public void stop(){
        serveur.stop = true;
        serveur.interrupt();
    }


    // Send invitation
    public void sendInvitation(InetAddress ip){
        Client client = new Client(ip, "invitation");
        client.start();
    }


    // Receivers
    public void receiveInvitation(InetAddress ip){
        this.ip = ip;
    }

    public void receiveScore(int score){
        this.otherScore = score;
    }

    public void receiveFinish(){
        this.finish = true;
    }

    public void receiveMalus(Malus malus){
        this.malusReceived = malus;
    }


    // Send score and malus
    public void update(int score, Malus malus, boolean sendFinish) {
        Client client = new Client(ip, String.valueOf(score));
        client.start();

        // Attends que l'envoi soit terminé
        while(client.isAlive()){
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        client = new Client(ip, malus.name);
        client.start();

        // Attend que l'envoi soit terminé
        while(client.isAlive()){
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if(sendFinish){
            client = new Client(ip, "finish");
            client.start();
        }

    }

    // Getters and Setters

    // Renvoi le malus et le réinitialise
    public Malus getMalus() {
        Malus ret = malusReceived;
        malusReceived = null;
        return ret;
    }

    public int getOtherScore() {
        return otherScore;
    }

    public boolean isFinish() {
        return finish;
    }
}
