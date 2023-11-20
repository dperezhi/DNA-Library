package ui.panels.sidebar;

import javax.swing.*;
import java.awt.*;

public class Header extends JPanel {

    public Header() {
        this.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        this.setLayout(new GridLayout(0,1));
        this.setBackground(Color.blue);

        this.add(topPanel());
        this.add(bottomPanel());
    }

    public JPanel topPanel() {
        JPanel topPanel = new JPanel();
        topPanel.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        topPanel.setLayout(new GridLayout(0,3));
        topPanel.setBackground(Color.CYAN);

        ImageIcon logo = new ImageIcon("./src/main/img/logo.png");
        logo.setImage(logo.getImage().getScaledInstance(60,60, 1));
        JLabel labelForImg = new JLabel(logo);
        topPanel.add(labelForImg);

        JLabel l1 = new JLabel("My Library");
        topPanel.add(l1);

        JButton b1 = new JButton("+"); //ui.panels.buttonFunctionality.AddDnaToLibrary
        topPanel.add(b1);

        return topPanel;
    }

    public JPanel bottomPanel() {
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        bottomPanel.setLayout(new GridLayout(0,1));
        bottomPanel.setBackground(Color.YELLOW);

        JLabel l2 = new JLabel("SEARCH BAR: To be implemented...");
        bottomPanel.add(l2);

        return bottomPanel;
    }
}
