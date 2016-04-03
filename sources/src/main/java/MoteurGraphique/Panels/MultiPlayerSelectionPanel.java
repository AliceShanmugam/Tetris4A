package MoteurGraphique.Panels;

import MoteurGraphique.Events.ReseauEvent;

import javax.swing.*;
import java.awt.*;

public class MultiPlayerSelectionPanel extends JPanel {

    private JButton invitationButton;
    private JLabel myIp;
    private JLabel text;
    private JTextField textField;

    public MultiPlayerSelectionPanel(String ip) {
        initComponents(ip);
    }

    @SuppressWarnings("unchecked")
    private void initComponents(String ip) {
        setLayout(new BorderLayout());
        addMenu(ip);
        setVisible(true);
    }

    private void addMenu(String ip) {
        JPanel menuWrapper = new JPanel();
        menuWrapper.setLayout(new GridBagLayout());

        invitationButton = new JButton();
        myIp = new JLabel("My IP : " + ip);
        text = new JLabel("Friend IP :");
        textField = new JTextField(10);

        setButtons();

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;

        menuWrapper.add(myIp, gbc);
        gbc.gridy++;
        menuWrapper.add(text, gbc);
        gbc.gridx++;
        menuWrapper.add(textField, gbc);
        gbc.gridx--;
        gbc.gridy++;
        menuWrapper.add(invitationButton, gbc);

        add(menuWrapper, BorderLayout.CENTER);
    }

    public void setButtons()
    {
        setBackground(Color.BLACK);

        myIp.setFont(new java.awt.Font("Helvetica", Font.BOLD, 16));
        myIp.setForeground(Color.BLUE);
        myIp.setBackground(new Color(0, 32, 48));
        myIp.setAlignmentX(Component.CENTER_ALIGNMENT);

        text.setFont(new java.awt.Font("Helvetica", Font.BOLD, 16));
        text.setBackground(new Color(0, 32, 48));
        text.setAlignmentX(Component.CENTER_ALIGNMENT);

        textField.setAlignmentX(Component.CENTER_ALIGNMENT);
        Font bigFont = textField.getFont().deriveFont(Font.PLAIN, 16f);
        textField.setFont(bigFont);

        invitationButton.setText("SEND INVITATION");
        invitationButton.setForeground(Color.GREEN);
        invitationButton.setBackground(new Color(0, 32, 48));
        invitationButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    public void setMenuEventListeners(ReseauEvent reseauEvent) {
        invitationButton.addActionListener(event -> {
            reseauEvent.sendInvitation(textField.getText());
        });
    }

}
