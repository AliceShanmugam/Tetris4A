package MoteurGraphique;

import MoteurDeJeu.Malus;
import MoteurDeJeu.Pieces.Piece;
import MoteurDeJeu.Plateau;
import MoteurGraphique.Panels.*;
import MoteurGraphique.Events.MenuEvent;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    final int WIDTH = 680;
    final int HEIGHT = 876;

    public MainFrame() {
        initComp();
    }

    private void initComp()
    {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout(WIDTH, HEIGHT));
        Dimension size = new Dimension(WIDTH, HEIGHT);
        setSize(size);
        setMinimumSize(size);
        setMaximumSize(size);

        setVisible(true);
    }

    public void showMainMenu(MenuEvent.Listener listener) {
        MainMenuPanel menuPanel = new MainMenuPanel();
        replacePanel(menuPanel);
        menuPanel.setMenuEventListeners(listener);
    }

    public void showCreditsPanel(MenuEvent.Listener listener) {
        CreditsPanel creditsPanel = new CreditsPanel(getContentSize());
        replacePanel(creditsPanel);
        creditsPanel.setMenuEventListeners(listener);
    }

    public void showScoresPanel(MenuEvent.Listener listener) {
        ScoresPanel panel = new ScoresPanel(getContentSize());
        replacePanel(panel);
        panel.setMenuEventListeners(listener);
    }

    public void showPlayerTypePanel(MenuEvent.Listener listener) {
        PlayerSelectionPanel menuPanel = new PlayerSelectionPanel();
        replacePanel(menuPanel);
        menuPanel.setMenuEventListeners(listener);
    }

<<<<<<< HEAD
    public void showGameSoloPanel(Plateau plateau, Piece nextPiece, int score, int score2, Malus malusReceived, boolean isMulti) {
        SoloGamePanel panel = new SoloGamePanel(plateau, nextPiece, score,  score2, malusReceived,  isMulti);
        replacePanel(panel);
    }

    public void showGameMultiPanel(Plateau plateau, Piece nextPiece, int score, int score2, Malus malusReceived, boolean isMulti) {
        MultiGamePanel panel = new MultiGamePanel(plateau, nextPiece, score,  score2, malusReceived,  isMulti);
||||||| merged common ancestors
    public void showGameSoloPanel() {
        SoloGamePanel panel = new SoloGamePanel();
=======
    public void showMultiPlayerPanel(MenuEvent.Listener listener) {
        MultiPlayerSelectionPanel panel = new MultiPlayerSelectionPanel();
        replacePanel(panel);
        panel.setMenuEventListeners(listener);
    }

    public void showGameSoloPanel() {
        SoloGamePanel panel = new SoloGamePanel();
>>>>>>> 2a52e88836de9f52e95c9ebe1ca746b31aab59e4
        replacePanel(panel);
    }

    public void replacePanel(Component component) {
        getContentPane().removeAll();
        getContentPane().add(component);
        revalidate();
    }

    public Dimension getContentSize() {
        return new Dimension(WIDTH, HEIGHT);
    }

}