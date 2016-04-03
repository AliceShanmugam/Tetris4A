package MoteurGraphique.Events;

import MoteurGraphique.MoteurGraphique;
import Reseau.Reseau;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ReseauEvent extends Thread{

    private Reseau reseau;
    private MoteurGraphique moteurGraphique;

    public ReseauEvent(MoteurGraphique moteurGraphique){
        reseau = new Reseau();
        this.moteurGraphique = moteurGraphique;
    }

    @Override
    public void run() {
        super.run();

        while(reseau.ip == null){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        moteurGraphique.ip = reseau.ip;
        moteurGraphique.play = true;

        reseau.stop();
    }

    public void sendInvitation(String ip) {
        try {
            reseau.sendInvitation(InetAddress.getByName(ip));
        } catch (UnknownHostException ignored) {
        }
    }
}
