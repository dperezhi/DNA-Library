package ui.panels.workspace;

import model.DnaFolder;
import ui.GUI;
import ui.Main;

import javax.swing.*;
import java.awt.*;

public class WorkSpace extends JPanel {
    private DnaFolder dnaFolder;
    private JFrame masterFrame;
    private MainContent displayWorkspace;
    private GUI masterGui;


    public WorkSpace(DnaFolder dnaFolder, JFrame masterFrame, GUI masterGui) {
        //JPanel p2 = new JPanel();
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
