package Interfaces;

import MoteurDeJeu.JeuController;

import javax.swing.*;
import java.awt.*;

/**
 * Created by asusss on 22.03.2016.
 */
public class ChoosePlayerPanel extends JPanel {

    private JButton multiButton;
    private JButton soloButton;

    public ChoosePlayerPanel(Dimension size) {
        setSize(size);
        initComponents();
    }

    private void initComponents() {

        setBackground(Color.BLACK);

        multiButton = new JButton();
        soloButton = new JButton();

        soloButton.setText("SOLO GAME");
        soloButton.setBackground(new Color(0, 32, 48));
        soloButton.setForeground(Color.LIGHT_GRAY);
        soloButton.setForeground(Color.GREEN);

        multiButton.setText("MULTI GAME");
        multiButton.setBackground(new Color(0, 32, 48));
        multiButton.setForeground(Color.LIGHT_GRAY);
        multiButton.setForeground(Color.GREEN);


        add(soloButton);
        add(multiButton);

        setLayout(new GridBagLayout());

    }

    public boolean isSoloClicked()
    {
        return soloButton.getModel().isSelected();
    }


    public void setMenuEventListeners(MenuEvent.Listener listener) {
        soloButton.addActionListener(event -> listener.onMenuEvent(MenuEvent.ItemType.play));
       if(soloButton.getModel().isSelected())

    }
}
