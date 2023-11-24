package ui.panels.workspace;

import model.DnaFolder;
import ui.GUI;
import ui.Main;

import javax.swing.*;
import java.awt.*;

// represents a panel within the GUI frame in which the main content of the DNAs can be observed and also the file menu
public class WorkSpace extends JPanel {
    private DnaFolder dnaFolder;
    private JFrame masterFrame;
    private MainContent displayWorkspace;
    private GUI masterGui;

    //MODIFIES: this
    //EFFECTS: creates the workspace panel
    public WorkSpace(DnaFolder dnaFolder, JFrame masterFrame, GUI masterGui) {
        this.dnaFolder = dnaFolder;
        this.masterGui = masterGui;
        this.masterFrame = masterFrame;
        this.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        this.setLayout(new GridLayout(0,1));
        this.setBackground(Color.red);

        this.add(new FileMenu(dnaFolder, masterFrame),BorderLayout.CENTER);
        displayWorkspace = new MainContent(masterGui);
        this.add(displayWorkspace,BorderLayout.CENTER);
    }
}
