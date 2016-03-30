package Interfaces;

import javax.swing.*;
import java.awt.*;

/**
 * Created by asusss on 22.03.2016.
 */
public class MainFrame extends JFrame {

    final int WIDTH = 680;
    final int HEIGHT = 876;

    public MainFrame() {
        initComp();
    }

    private void initComp()
    {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout(WIDTH, HEIGHT));
        Dimension size = new Dimension(WIDTH, HEIGHT);
        setSize(size);
        setMinimumSize(size);
        setMaximumSize(size);




        setVisible(true);

    }

    public void showMainMenu(MenuEvent.Listener listener) {
        MainMenuPanel menuPanel = new MainMenuPanel();
        replacePanel(menuPanel);
        menuPanel.setMenuEventListeners(listener);
    }

    public void showCreditsPanel() {
        replacePanel(new CreditsPanel(getContentSize()));
    }

    public void showPlayerTypePanel() {
        replacePanel(new ChoosePlayerPanel(getContentSize()));
    }

    public void showScoresPanel() {
          replacePanel(new ScoresPanel(getContentSize()));
    }

    public void replacePanel(Component component) {
        getContentPane().removeAll();
        getContentPane().add(component);
        revalidate();
    }

    public Dimension getContentSize() {
        return new Dimension(WIDTH, HEIGHT);
    }

}