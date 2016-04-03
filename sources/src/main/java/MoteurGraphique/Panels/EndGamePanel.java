package MoteurGraphique.Panels;

import MoteurGraphique.Events.MenuEvent;
import MoteurGraphique.HighScore.HighScoreManager;

import javax.swing.*;
import java.awt.*;

/**
 * Created by asusss on 3.04.2016.
 */
public class EndGamePanel extends JPanel {



    private JButton menuButton;
    private int score, score2;
    private  boolean victory;

    public EndGamePanel(int score, int score2, boolean victory) {

        this.score=score;
        this.score2=score2;
        this.victory=victory;
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


        JLabel end= new JLabel();
        end.setText("END OF THE GAME");
        end.setFont(new java.awt.Font("Helvetica", Font.BOLD, 32));
        end.setForeground(Color.GREEN);
        end.setAlignmentY(CENTER_ALIGNMENT);
        add(end);

        JLabel lab= new JLabel();
        lab.setText("Your score: " +score);
        lab.setFont(new java.awt.Font("Helvetica", Font.BOLD, 26));
        lab.setForeground(Color.GREEN);
        lab.setAlignmentY(CENTER_ALIGNMENT);
        add(lab);

        if(score2>-1)
        {
            JLabel lab2= new JLabel();
            lab2.setText("Other player's score: " +score2);
            lab2.setFont(new java.awt.Font("Helvetica", Font.BOLD, 26));
            lab2.setForeground(Color.GREEN);
            lab2.setAlignmentY(CENTER_ALIGNMENT);
            add(lab2);

            JLabel lab3= new JLabel();
            String str="";
            if(victory)
                str="You win!";
            else
                str="You Lost!";
            lab3.setText(str);
            lab3.setFont(new java.awt.Font("Helvetica", Font.BOLD, 30));
            lab3.setForeground(Color.GREEN);
            lab3.setAlignmentY(CENTER_ALIGNMENT);
            add(lab3);
        }


    }

    public void setMenuEventListeners(MenuEvent.Listener listener) {
        menuButton.addActionListener(event -> listener.onMenuEvent(MenuEvent.ItemType.menu));

    }

}