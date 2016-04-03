package MoteurGraphique.Panels;

import MoteurDeJeu.Malus;
import MoteurDeJeu.Pieces.Piece;
import MoteurDeJeu.Plateau;
import MoteurGraphique.Events.MenuEvent;

import javax.swing.*;
import java.awt.*;

public class SoloGamePanel extends JPanel {

    private Plateau plateau;
    private Piece nextPiece;
    private int score,score2;
    private Malus malus;
    private boolean isMulti;



    public SoloGamePanel(Plateau plateau, Piece nextPiece, int score, int score2, Malus malusReceived, boolean isMulti) {
        initComponents();
        this.plateau=plateau;
        this.nextPiece=nextPiece;
        this.score=score;
        this.score2=score2;
        this.malus=malusReceived;
        this.isMulti=isMulti;
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        setLayout(new BorderLayout());
        addMenu();
        setVisible(true);
    }

    private void addMenu() {
        setLayout(new GridLayout());


        GamePanel gp = new GamePanel(plateau);
        SidePanel sp = new SidePanel(nextPiece,score,score2,malus,isMulti);

        add(gp);
        add(sp);
    }

}
