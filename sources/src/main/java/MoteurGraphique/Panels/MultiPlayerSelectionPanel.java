package MoteurGraphique.Panels;

import MoteurGraphique.Events.MenuEvent;

import javax.swing.*;
import java.awt.*;

public class MultiPlayerSelectionPanel extends JPanel {

    private JButton playSoloButton;
    private JButton playMultiButton;
    private JButton menuButton;

    public MultiPlayerSelectionPanel() {
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
        playSoloButton.setText("");
        playSoloButton.setBackground(new Color(0, 32, 48));
        playSoloButton.setForeground(Color.GREEN);
        playSoloButton.setAlignmentX(Component.CENTER_ALIGNMENT);


        playMultiButton.setText("");
        playMultiButton.setForeground(Color.GREEN);
        playMultiButton.setBackground(new Color(0, 32, 48));
        playMultiButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        menuButton.setText("BACK");
        menuButton.setBackground(new Color(0, 32, 48));
        menuButton.setForeground(Color.LIGHT_GRAY);
    }


    public void setMenuEventListeners(MenuEvent.Listener listener) {
        menuButton.addActionListener(event -> listener.onMenuEvent(MenuEvent.ItemType.back));
    }

}
