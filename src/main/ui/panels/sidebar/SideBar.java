package ui.panels.sidebar;

import model.DnaFolder;

import javax.swing.*;
import java.awt.*;

public class SideBar extends JPanel {
    private DnaFolder dnaFolder;
    private DnaDisplayed updateDnaDisplayPanel;

    public SideBar(DnaFolder dnaFolder) {
        this.dnaFolder = dnaFolder;
        this.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        this.setLayout(new GridLayout(0,1));
        this.setBackground(Color.green);
        this.setSize(new Dimension(250,500));

        DnaDisplayed updateDnaDisplayPanel = new DnaDisplayed(dnaFolder);
        this.add(new Header(dnaFolder, updateDnaDisplayPanel), BorderLayout.CENTER);
        this.add(updateDnaDisplayPanel, BorderLayout.CENTER);
    }
}
