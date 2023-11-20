package ui.panels.sidebar;

import model.DnaFolder;

import javax.swing.*;
import java.awt.*;

public class SideBar extends JPanel {
    DnaFolder dnaFolder;
    JPanel updateDnaDisplayPanel;

    public SideBar(DnaFolder dnaFolder) {
        this.dnaFolder = dnaFolder;
        this.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        this.setLayout(new GridLayout(0,1));
        this.setBackground(Color.green);
        this.setSize(new Dimension(250,500));

        this.add(new Header(dnaFolder), BorderLayout.CENTER);
        this.add(new DnaDisplayed(dnaFolder), BorderLayout.CENTER);
    }

    public JPanel getUpdateDnaDisplayPanel() {
        return updateDnaDisplayPanel;
    }

    public void setUpdateDnaDisplayPanel(JPanel updateDnaDisplayPanel) {
        this.updateDnaDisplayPanel = updateDnaDisplayPanel;
    }
}
