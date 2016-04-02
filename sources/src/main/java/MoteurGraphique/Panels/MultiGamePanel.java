package MoteurGraphique.Panels;

import MoteurDeJeu.Malus;
import MoteurDeJeu.Pieces.Piece;
import MoteurDeJeu.Plateau;

import javax.swing.*;
import java.awt.*;

/**
 * Created by asusss on 2.04.2016.
 */
public class MultiGamePanel extends JPanel {

        public MultiGamePanel(Plateau plateau, Piece nextPiece, int score, int score2, Malus malusReceived, boolean isMulti) {
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


        GamePanel  gp= new GamePanel();

        SidePanel sp= new SidePanel();

        add(gp);
        add(sp);
    }

}


