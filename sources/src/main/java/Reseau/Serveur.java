package Reseau;


import MoteurDeJeu.Malus;
import MoteurDeJeu.MalusFactory;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Serveur extends Thread{

    // Configuration réseau
    final static int port = 9666;
    final static int taille_max = 1024;
    static byte buffer[] = new byte[taille_max];
    private DatagramSocket socket = null;

    // Instance de reseau
    private Reseau reseau;

    public boolean stop = false;


    public Serveur(Reseau reseau) {
        this.reseau = reseau;
    }

    public void run() {
        try {
            // Preparation
            String message = "";
            int taille = 0;
            socket = new DatagramSocket(port);

            while (!stop) {
                // Reception
                DatagramPacket paquet = new DatagramPacket(buffer, buffer.length);
                socket.receive(paquet);

                taille = paquet.getLength();
                message = new String(paquet.getData(), 0, taille);

                // Traitement

                switch(message){
                    // Reception d'invitation
                    case "invitation" :
                        reseau.receiveInvitation(paquet.getAddress());
                        Client client = new Client(paquet.getAddress(), "okinvitation");
                        client.start();
                        break;

                    // Reception de confirmation d'invitation
                    case "okinvitation" :
                        reseau.receiveInvitation(paquet.getAddress());
                        break;

                    // Reception du signale de fin de partie
                    case "finish" :
                        reseau.receiveFinish();
                        break;

                    // Reception du malus "Blind"
                    case "Blind" :
                        MalusFactory factory = new MalusFactory();
                        Malus malus = factory.createMalus("Blind");
                        reseau.receiveMalus(malus);
                        break;

                    // Reception du malus "Reverse"
                    case "Reverse" :
                        factory = new MalusFactory();
                        malus = factory.createMalus("Reverse");
                        reseau.receiveMalus(malus);
                        break;

                    default :
                        // Reception du score
                        try {
                            int score = Integer.parseInt(message);
                            reseau.receiveScore(score);
                        } catch (NumberFormatException nfe) {
                            System.out.print("Message recus invalide : "+message);
                        }
                }
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void interrupt(){
        super.interrupt();
        this.socket.close();
    }
}
