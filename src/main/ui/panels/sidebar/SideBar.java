package ui.panels.sidebar;

import model.DnaFolder;
import ui.panels.workspace.MainContent;

import javax.swing.*;
import java.awt.*;

// represents a Panel within the GUI in which the Header and Dna Selection Panels can be displayed
public class SideBar extends JPanel {
    private DnaFolder dnaFolder;
    private DnaDisplayed updateDnaDisplayPanel;
    private MainContent displayWorkspace;

    //MODIFIES: this
    //EFFECTS: sets up a the SideBar panel that displays the header and DnaDisplayPanel
    public SideBar(DnaFolder dnaFolder, MainContent displayWorkspace) {
        this.dnaFolder = dnaFolder;
        this.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        this.setLayout(new GridLayout(0,1));
        this.setBackground(Color.green);
        this.setSize(new Dimension(250,500));

        DnaDisplayed updateDnaDisplayPanel = new DnaDisplayed(dnaFolder, displayWorkspace);
        this.add(new Header(dnaFolder, updateDnaDisplayPanel), BorderLayout.CENTER);
        this.add(updateDnaDisplayPanel, BorderLayout.CENTER);
    }
}
