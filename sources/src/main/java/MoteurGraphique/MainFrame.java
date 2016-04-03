package MoteurGraphique;

import MoteurDeJeu.Jeu;
import MoteurDeJeu.Malus;
import MoteurDeJeu.Pieces.Piece;
import MoteurDeJeu.Plateau;
import MoteurGraphique.Panels.*;
import MoteurGraphique.Events.MenuEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainFrame extends JFrame implements KeyListener {

    final int WIDTH = 680;
    final int HEIGHT = 876;
    public Jeu jeu = null;

    private Plateau plateau;
    private Piece nextPiece;
    private int score;
    private int score2;
    private Malus malusReceived;
    private boolean isMulti;


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

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

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

    public void updatePlateau(Plateau newPlateau){
        showGamePanel(newPlateau, nextPiece, score, score2, malusReceived, isMulti);
    }

    public void showGamePanel(Plateau plateau, Piece nextPiece, int score, int score2, Malus malusReceived, boolean isMulti) {

        this.plateau = plateau;
        this.nextPiece = nextPiece;
        this.score = score;
        this.score2 = score2;
        this.malusReceived = malusReceived;
        this.isMulti = isMulti;

        if (isMulti) {
            SoloGamePanel panel = new SoloGamePanel(plateau, nextPiece, score, score2, malusReceived, isMulti);
            replacePanel(panel);
        } else {
            MultiGamePanel panel = new MultiGamePanel(plateau, nextPiece, score, score2, malusReceived, isMulti);
            replacePanel(panel);
        }
    }

    public void showResultPanel(MenuEvent.Listener listener,int score, int score2, boolean victory) {

        EndGamePanel panel = new EndGamePanel(score,score2,victory);
        replacePanel(panel);
        panel.setMenuEventListeners(listener);

    }


    public void showMultiPlayerPanel(MenuEvent.Listener listener, String ip) {
        MultiPlayerSelectionPanel panel = new MultiPlayerSelectionPanel(ip);
        replacePanel(panel);
        panel.setMenuEventListeners(listener);
    }


    public void replacePanel(Component component) {
        getContentPane().removeAll();
        getContentPane().add(component);
        revalidate();
    }

    public Dimension getContentSize() {
        return new Dimension(WIDTH, HEIGHT);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (jeu != null){
            switch (e.getKeyCode()){
                case 37:
                    jeu.left();
                    updatePlateau(jeu.getPlateau());
                    break;
                case 39:
                    jeu.right();
                    updatePlateau(jeu.getPlateau());
                    break;
                case 40:
                    jeu.rotationLeft();
                    updatePlateau(jeu.getPlateau());
                    break;
                case 38:
                    jeu.rotationRight();
                    updatePlateau(jeu.getPlateau());
                    break;
                case 32:
                    jeu.fall();
                    break;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}