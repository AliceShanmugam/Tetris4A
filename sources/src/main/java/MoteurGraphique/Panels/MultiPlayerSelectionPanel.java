package MoteurGraphique.Panels;

import MoteurGraphique.Events.MenuEvent;

import javax.swing.*;
import java.awt.*;

public class MultiPlayerSelectionPanel extends JPanel {

    private JButton invitationButton;
    private JLabel myIp;
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
        menuWrapper.setLayout(new BoxLayout(menuWrapper, BoxLayout.Y_AXIS));

        invitationButton = new JButton();
        myIp = new JLabel("My ip : "+ip);
        textField = new JTextField ();

        setButtons();

        menuWrapper.add(myIp);
        menuWrapper.add(textField);
        menuWrapper.add(invitationButton);

        add(menuWrapper, BorderLayout.CENTER);
    }

    public void setButtons()
    {
        setBackground(Color.BLACK);

        myIp.setFont(new java.awt.Font("Helvetica", Font.BOLD, 16));
        myIp.setForeground(Color.BLUE);
        myIp.setBackground(new Color(0, 32, 48));
        myIp.setAlignmentX(Component.CENTER_ALIGNMENT);

        invitationButton.setPreferredSize( new Dimension( 200, 24 ) );
        invitationButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        invitationButton.setText("SEND INVITATION");
        invitationButton.setForeground(Color.GREEN);
        invitationButton.setBackground(new Color(0, 32, 48));
        invitationButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    }


    public void setMenuEventListeners(MenuEvent.Listener listener) {
        invitationButton.addActionListener(event -> listener.onMenuEvent(MenuEvent.ItemType.sendInvitation));
    }

}
