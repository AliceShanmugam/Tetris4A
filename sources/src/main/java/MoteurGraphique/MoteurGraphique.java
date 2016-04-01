
package MoteurGraphique;

import MoteurDeJeu.Malus;
import MoteurDeJeu.Pieces.Piece;
import MoteurDeJeu.Plateau;
import MoteurGraphique.Events.MenuEvent;

import javax.swing.*;
import java.net.InetAddress;

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
            }
        };

        frame.showPlayerTypePanel(menuListener);
    }

    private void showMultiPlayerScreen() {

    }

    public void showEndScreenSolo(int score) {

    }

    public void showEndScreenMulti(int score1, int score2, boolean victory) {

    }

    public void showGameSolo(Plateau plateau, Piece nextPiece, int score) {
        frame.showGameSoloPanel();
    }

    public void showGameMulti(Plateau plateau, Piece nextPiece, int score, int score2, Malus malusReceived) {

    }
}
