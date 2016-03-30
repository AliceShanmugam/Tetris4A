
package MoteurDeJeu;
/**
 * Created by asusss on 22.03.2016.
 */


import Interfaces.MainFrame;
import Interfaces.MainMenuPanel;
import Interfaces.MenuEvent;

import javax.swing.*;

public class JeuController {

    protected MainFrame frame;
    private MenuEvent.Listener menuListener;
    private MenuEvent.Listener menuListener2;
    private boolean ready;
    private boolean solo;
    private String ip;

    public JeuController()
    {
        createAndShowGUI();
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
                case menu:
                    showMenuScreen();
                    break;
            }
        };

        frame.showMainMenu(menuListener);
    }

    private void showMenuScreen() {
        frame.showMainMenu(menuListener2);
    }

    private void showCreditsScreen() {
        frame.showCreditsPanel();
    }

    private void showScoresScreen() {
             frame.showScoresPanel();
    }
    private void showPlayerTypeScreen() {
         frame.showPlayerTypePanel();
    }


    public boolean isReady() {
        return ready;
    }


    public void setReady(boolean ready) {
        this.ready = ready;
    }
}
