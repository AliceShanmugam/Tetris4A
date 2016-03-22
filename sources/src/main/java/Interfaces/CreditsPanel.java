package Interfaces;

import javax.swing.*;
import java.awt.*;

/**
 * Created by asusss on 22.03.2016.
 */
public class CreditsPanel extends JPanel {

    // Variables declaration
    private javax.swing.JLabel gorkemLabel;
    private javax.swing.JLabel aliceLabel;
    private javax.swing.JLabel maximeLabel;
    private javax.swing.JLabel projectLabel;

    private JButton menuButton;

    public CreditsPanel(Dimension size) {
        setSize(size);
        initComponents();
    }


    private void initComponents() {

        setBackground(Color.BLACK);
        //  setLayout(new BoxLayout( BoxLayout.PAGE_AXIS));
        projectLabel = new javax.swing.JLabel();
        gorkemLabel = new javax.swing.JLabel();
        aliceLabel = new javax.swing.JLabel();
        maximeLabel = new javax.swing.JLabel();
        menuButton = new JButton();

        projectLabel.setFont(new java.awt.Font("Helvetica", Font.BOLD, 26)); // NOI18N
        projectLabel.setText("A Tetris Project");
        projectLabel.setForeground(Color.BLUE);

        aliceLabel.setFont(new java.awt.Font("Helvetica", Font.BOLD, 24)); // NOI18N
        aliceLabel.setText("Alice Shanmugam");
        aliceLabel.setForeground(Color.GREEN);


        gorkemLabel.setFont(new java.awt.Font("Helvetica", Font.BOLD, 24)); // NOI18N
        gorkemLabel.setText("Görkem Çamlı");
        gorkemLabel.setForeground(Color.GREEN);

        maximeLabel.setFont(new java.awt.Font("Helvetica", Font.BOLD, 24)); // NOI18N
        maximeLabel.setText("Maxime Fernandez");
        maximeLabel.setForeground(Color.GREEN);

        menuButton.setText("MAIN MENU");
        menuButton.setBackground(new Color(0, 32, 48));
        menuButton.setForeground(Color.LIGHT_GRAY);

//        g.setFont(new Font("Helvetica", Font.BOLD, 18));
//        +			g.setColor(Color.GREEN);
//        +			g.drawString("BERKCAN GUREL",60,BOARD_WIDTH/2-50);
//        +			g.setColor(new Color(0, 32, 48));
//        +        	g.fillRect(30, BOARD_WIDTH/2 + 50, BOARD_WIDTH-80, 40);
//        +        	g.setColor(Color.WHITE);
//        +        	g.drawString("MAIN MENU",100,BOARD_WIDTH/2 +75);

    /*    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(projectLabel)
                                .addComponent(aliceLabel)
                                .addComponent(gorkemLabel)
                                .addComponent(maximeLabel)));*/
     /*   add(projectLabel);
        add(aliceLabel);
        add(gorkemLabel);
        add(maximeLabel);*/


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()

                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(gorkemLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(projectLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(aliceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(maximeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(menuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(60, 60, 60))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()

                                .addComponent(projectLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(gorkemLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(aliceLabel)
                                .addComponent(maximeLabel)
                                .addComponent(menuButton))

        );
    }

    public void setMenuEventListeners(MenuEvent.Listener listener) {
        menuButton.addActionListener(event -> listener.onMenuEvent(MenuEvent.ItemType.menu));

    }
}