package MoteurGraphique.Panels;

import MoteurGraphique.Events.MenuEvent;

import javax.swing.*;
import java.awt.*;

public class PlayerSelectionPanel extends JPanel {

    private JButton playSoloButton;
    private JButton playMultiButton;
    private JButton menuButton;

    public PlayerSelectionPanel() {
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
        playSoloButton = new JButton();
        playMultiButton = new JButton();
        menuButton = new JButton();

        setButtons();

        menuWrapper.add(playSoloButton);
        menuWrapper.add(playMultiButton);
        menuWrapper.add(menuButton);
        add(menuWrapper, BorderLayout.CENTER);
    }

    public void setButtons()
    {
        setBackground(Color.BLACK);


        playSoloButton.setPreferredSize(new Dimension(500,500));
        playSoloButton.setText("PLAY SOLO");
        playSoloButton.setBackground(new Color(0, 32, 48));
        playSoloButton.setForeground(Color.GREEN);
        playSoloButton.setAlignmentX(Component.CENTER_ALIGNMENT);


        playMultiButton.setText("PLAY MULTI");
        playMultiButton.setForeground(Color.GREEN);
        playMultiButton.setBackground(new Color(0, 32, 48));
        playMultiButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        menuButton.setText("MAIN MENU");
        menuButton.setBackground(new Color(0, 32, 48));
        menuButton.setForeground(Color.LIGHT_GRAY);
        menuButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    }


    public void setMenuEventListeners(MenuEvent.Listener listener) {
        playSoloButton.addActionListener(event -> listener.onMenuEvent(MenuEvent.ItemType.playSolo));
        playMultiButton.addActionListener(event -> listener.onMenuEvent(MenuEvent.ItemType.playMulti));
        menuButton.addActionListener(event -> listener.onMenuEvent(MenuEvent.ItemType.menu));
    }

}
