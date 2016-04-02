package MoteurGraphique.Panels;

import MoteurGraphique.Events.MenuEvent;
import MoteurGraphique.HighScore.HighScoreManager;

import javax.swing.*;
import java.awt.*;

public class ScoresPanel extends JPanel {



    private JButton menuButton;
    private HighScoreManager hm;

    public ScoresPanel(Dimension size) {
        setSize(size);
        initComponents();
    }


    private void initComponents() {

        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        add(Box.createHorizontalGlue());

        setBackground(Color.BLACK);
        menuButton = new JButton();

        menuButton.setText("MAIN MENU");
        menuButton.setBackground(new Color(0, 32, 48));
        menuButton.setForeground(Color.LIGHT_GRAY);

        hm = new HighScoreManager();
        JTextField scoreText= new JTextField();
        scoreText.setText("");
        getHighScores();
        String str=hm.getHighscoreString();
        String textStr[] = str.split("\\r?\\n");


        add(menuButton);
            for(int i=0; i< 5;i++){
                JLabel lab= new JLabel();
                lab.setText(scoreText.getText()+"\n"+textStr[i]);
                lab.setFont(new java.awt.Font("Helvetica", Font.BOLD, 26));
                lab.setForeground(Color.GREEN);
                lab.setAlignmentY(CENTER_ALIGNMENT);
                add(lab);
                System.out.println(textStr[i]);
            }

       // scoreText.setText();


       // add(scoreText);

    }

    public void setMenuEventListeners(MenuEvent.Listener listener) {
        menuButton.addActionListener(event -> listener.onMenuEvent(MenuEvent.ItemType.menu));

    }

    public void getHighScores()
    {
        HighScoreManager hm = new HighScoreManager();

        // Change here later !!
        hm.addScore("Görkem",240);
        hm.addScore("Alice",300);
        hm.addScore("Maxime",220);
        hm.addScore("X",100);
        hm.addScore("Y",270);

        System.out.print(hm.getHighscoreString().split(System.getProperty("line.separator")));
    }

}
