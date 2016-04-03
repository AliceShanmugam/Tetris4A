
package MoteurGraphique;

import MoteurDeJeu.Jeu;
import MoteurDeJeu.Malus;
import MoteurDeJeu.Pieces.Piece;
import MoteurDeJeu.Plateau;
import MoteurGraphique.Events.MenuEvent;
import MoteurGraphique.Events.ReseauEvent;

import javax.swing.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class MoteurGraphique {

    protected MainFrame frame;
    private MenuEvent.Listener menuListener;

    // Vaut true si la patie doit etre lancé
    public boolean play = false;
    public InetAddress ip = null;


    public MoteurGraphique(){
        javax.swing.SwingUtilities.invokeLater(this::createAndShowGUI);
    }

    public void createAndShowGUI() {
        frame = new MainFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Tetris!");

        frame.getContentPane();
        //Display the window.
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        showMainMenuScreen();
    }

    private void showMainMenuScreen() {

        menuListener = itemType -> {
            switch (itemType) {
                case play:
                    showPlayerTypeScreen();
                    break;
                case scores:
                    showScoresScreen();
                    break;
                case credits:
                    showCreditsScreen();
                    break;
            }
        };

        frame.showMainMenu(menuListener);
    }

    private void showCreditsScreen() {
        menuListener = itemType -> {
            switch (itemType) {
                case menu:
                    showMainMenuScreen();
                    break;
            }
        };

        frame.showCreditsPanel(menuListener);
    }

    private void showScoresScreen() {
        menuListener = itemType -> {
            switch (itemType) {
                case menu:
                    showMainMenuScreen();
                    break;
            }
        };
        frame.showScoresPanel(menuListener);
    }

    private void showPlayerTypeScreen() {

        menuListener = itemType -> {
            switch (itemType) {
                case playSolo:
                    this.play = true;
                    break;
                case playMulti:
                    showMultiPlayerScreen();
                    break;
                case menu:
                    showMainMenuScreen();
                    break;
            }
        };

        frame.showPlayerTypePanel(menuListener);
    }

    private void showMultiPlayerScreen() {

        ReseauEvent reseauEvent = new ReseauEvent(this);
        reseauEvent.start();

        String ip = null;
        try {
            ip = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }


        frame.showMultiPlayerPanel(reseauEvent, ip);
    }

    public void showEndScreenSolo(int score) {

        frame.showResultPanel(menuListener,score,-1,false);
    }

    public void showEndScreenMulti(int score1, int score2, boolean victory) {
        frame.showResultPanel(menuListener,score1,score2,victory);
    }

    public void showGame(Plateau plateau, Piece nextPiece, int score, int score2, Malus malusReceived, boolean isMulti) {
            frame.showGamePanel(plateau, nextPiece, score,  score2, malusReceived,  isMulti);

    }


    public void setJeu(Jeu jeu){
        frame.jeu = jeu;
    }
}
