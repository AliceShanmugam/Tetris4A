package MoteurGraphique.Panels;

import MoteurGraphique.Events.MenuEvent;

import javax.swing.*;
import java.awt.*;

public class ScoresPanel extends JPanel {



    private JButton menuButton;

    public ScoresPanel(Dimension size) {
        setSize(size);
        initComponents();
    }


    private void initComponents() {

        setBackground(Color.BLACK);
        menuButton = new JButton();

        menuButton.setText("MAIN MENU");
        menuButton.setBackground(new Color(0, 32, 48));
        menuButton.setForeground(Color.LIGHT_GRAY);


        add(menuButton);

    }

    public void setMenuEventListeners(MenuEvent.Listener listener) {
        menuButton.addActionListener(event -> listener.onMenuEvent(MenuEvent.ItemType.menu));

    }
}
