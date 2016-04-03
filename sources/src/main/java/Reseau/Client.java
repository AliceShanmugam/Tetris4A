package Reseau;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;

public class Client extends Thread{

    // Configuration réseau
    final static int port = 9666;
    final static int taille_max = 1024;
    static byte buffer[] = new byte[taille_max];

    // IP du joueur adverse et message
    private InetAddress ip;
    private String message;


    public Client(InetAddress ip, String message){
        this.ip = ip;
        this.message = message;
    }

    public void run() {
        try {
            // Préparation du message
            InetAddress serveur = ip;
            int length = message.length();
            byte buffer[] = message.getBytes();
            DatagramSocket socket = new DatagramSocket();
            DatagramPacket donneesEmises = new DatagramPacket(buffer, length, serveur, port);

            System.out.println(ip==null);

            // Envoi
            socket.setSoTimeout(10000);
            socket.send(donneesEmises);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
