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
        JPanel menuWrapper = new JPanel();
        menuWrapper.setLayout(new BoxLayout(menuWrapper, BoxLayout.Y_AXIS));
        text = new JLabel();

        text.setFont(new java.awt.Font("Helvetica", Font.BOLD, 26)); // NOI18N
        text.setText("Solo Game");
        text.setForeground(Color.BLUE);

        menuWrapper.add(text);
        add(menuWrapper, BorderLayout.CENTER);
    }

}
