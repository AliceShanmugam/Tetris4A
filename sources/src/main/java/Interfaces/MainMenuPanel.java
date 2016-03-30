package Interfaces;

import javax.swing.*;
import java.awt.*;

/**
 * Created by asusss on 22.03.2016.
 */
public class MainMenuPanel  extends JPanel {

    private JButton playGameButton;
    private JButton creditsButton;
    private JButton scoresButton;

    public MainMenuPanel() {
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
        menuWrapper.setLayout(new GridBagLayout());

        playGameButton = new JButton();
        creditsButton = new JButton();
        scoresButton = new JButton();

        setBackground(Color.BLACK);
        setButtons();

        menuWrapper.add(playGameButton);
        menuWrapper.add(scoresButton);
        menuWrapper.add(creditsButton);
        add(menuWrapper, BorderLayout.CENTER);
    }

    public void setButtons()
    {


        System.out.println("r2dewdw");

        playGameButton.setPreferredSize(new Dimension(500,500));
        playGameButton.setText("PLAY GAME");
        playGameButton.setBackground(new Color(0, 32, 48));
        playGameButton.setForeground(Color.GREEN);
        playGameButton.setAlignmentX(Component.CENTER_ALIGNMENT);


        scoresButton.setText("HIGH SCORES");
        scoresButton.setForeground(Color.GREEN);
        scoresButton.setBackground(new Color(0, 32, 48));
        scoresButton.setAlignmentX(Component.CENTER_ALIGNMENT);


        creditsButton.setText("CREDITS");
        creditsButton.setPreferredSize(new Dimension(100, 100));
        creditsButton.setBackground(new Color(0, 32, 48));
        creditsButton.setForeground(Color.GREEN);
        creditsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        System.out.println("r2dewdw");

        //setLayout(new GridBagLayout());
    }



    public boolean playGameSelected()
    {
        return playGameButton.getModel().isPressed();
    }




    public void setMenuEventListeners(MenuEvent.Listener listener) {
        playGameButton.addActionListener(event -> listener.onMenuEvent(MenuEvent.ItemType.play));

        scoresButton.addActionListener(event -> listener.onMenuEvent(MenuEvent.ItemType.scores));

        creditsButton.addActionListener(event -> listener.onMenuEvent(MenuEvent.ItemType.credits));
    }

}
