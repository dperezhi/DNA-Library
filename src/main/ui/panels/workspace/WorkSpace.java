package ui.panels.workspace;

import model.DnaFolder;

import javax.swing.*;
import java.awt.*;

public class WorkSpace extends JPanel {
    DnaFolder dnaFolder;

    public WorkSpace(DnaFolder dnaFolder) {
        //JPanel p2 = new JPanel();
        this.dnaFolder = dnaFolder;
        this.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        this.setLayout(new GridLayout(0,1));
        this.setBackground(Color.red);

        this.add(new FileMenu(dnaFolder),BorderLayout.CENTER);
        this.add(new MainContent(dnaFolder),BorderLayout.CENTER);
    }
}
