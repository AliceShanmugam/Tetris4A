package MoteurGraphique.Panels;

import MoteurGraphique.Events.MenuEvent;

import javax.swing.*;
import java.awt.*;

public class SoloGamePanel extends JPanel {

    private javax.swing.JLabel text;

    public SoloGamePanel() {
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
