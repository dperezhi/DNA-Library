package ui.panels.workspace;

import model.DnaFolder;

import javax.swing.*;
import java.awt.*;

public class WorkSpace extends JPanel {
    DnaFolder dnaFolder;
    JFrame masterFrame;

    public WorkSpace(DnaFolder dnaFolder, JFrame masterFrame) {
        //JPanel p2 = new JPanel();
        this.dnaFolder = dnaFolder;
        this.masterFrame = masterFrame;
        this.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        this.setLayout(new GridLayout(0,1));
        this.setBackground(Color.red);

        this.add(new FileMenu(dnaFolder, masterFrame),BorderLayout.CENTER);
        this.add(new MainContent(dnaFolder),BorderLayout.CENTER);
    }
}
