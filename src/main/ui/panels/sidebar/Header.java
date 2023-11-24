package ui.panels.sidebar;

import model.DnaFolder;
import ui.panels.buttonfunctionality.AddDnaToLibrary;

import javax.swing.*;
import java.awt.*;

// represent a Panel which serves as the header within the sidebar panel
public class Header extends JPanel {
    private DnaFolder dnaFolder;
    private DnaDisplayed updateDnaDisplayPanel;

    //MODIFIES: this
    //EFFECTS: creates a new Header with an option to add new DNAs to the Dna Library
    public Header(DnaFolder dnaFolder, DnaDisplayed updateDnaDisplayPanel) {
        this.dnaFolder = dnaFolder;
        this.updateDnaDisplayPanel = updateDnaDisplayPanel;
        this.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        this.setLayout(new GridLayout(0,1));
        this.setBackground(Color.blue);

        this.add(topPanel());
        this.add(bottomPanel());
    }

    //EFFECTS: sets up a new panel within the Header in which the Icon, title, and add Dna button are displayed
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

        AddDnaToLibrary addDnaButton = new AddDnaToLibrary(dnaFolder, updateDnaDisplayPanel);
        topPanel.add(addDnaButton);

        return topPanel;
    }

    //EFFECTS: sets up a new panel within the Header in which the search bar is displayed
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
