package MoteurGraphique.Panels;

import MoteurDeJeu.Malus;
import MoteurDeJeu.Pieces.Piece;
import MoteurDeJeu.Plateau;

import javax.swing.*;
import java.awt.*;


public class TetrisPanel extends JPanel {


        private Plateau plateau;
        private Piece nextPiece;
        private int score,score2;
        private Malus malusReceived;
        private  boolean isMulti;

        public TetrisPanel(Plateau plateau, Piece nextPiece, int score, int score2, Malus malusReceived, boolean isMulti) {

            this.plateau=plateau;
            this.nextPiece=nextPiece;
            this.score=score;
            this.score2=score2;
            this.malusReceived=malusReceived;
            this.isMulti=isMulti;
            initComponents();
    }

        @SuppressWarnings("unchecked")
        private void initComponents() {
        setLayout(new BorderLayout());
        addMenu();
        setVisible(true);
    }

    private void addMenu() {
        setLayout(new GridLayout());

        GamePanel  gp= new GamePanel(plateau);

        SidePanel sp= new SidePanel(nextPiece,  score,  score2, malusReceived, isMulti);

        add(gp);
        add(sp);
    }

}


