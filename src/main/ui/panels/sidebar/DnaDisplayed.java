package ui.panels.sidebar;

import model.DnaFolder;

import javax.swing.*;
import java.awt.*;

public class DnaDisplayed extends JPanel {
    DnaFolder dnaFolder;

    public DnaDisplayed(DnaFolder dnaFolder) {
        this.dnaFolder = dnaFolder;
        this.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        this.setLayout(new GridLayout(0,1));
        this.setBackground(Color.MAGENTA);

        for (int i = 0; i < dnaFolder.getDnaFolder().size(); i++) {
            this.add(addDnaToInterface(i));
        }
    }

    public JButton addDnaToInterface(int index) {
        JButton dnaButton = new JButton();
        JPanel dnaEntryPanel = new JPanel();
        dnaButton.add(dnaEntryPanel);

        dnaEntryPanel.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        dnaEntryPanel.setLayout(new GridLayout(0,3));
        dnaEntryPanel.setBackground(Color.red);

        ImageIcon dnaLogo = new ImageIcon("./src/main/img/dna.png");
        dnaLogo.setImage(dnaLogo.getImage().getScaledInstance(35,35, 1));
        JLabel labelForImg = new JLabel(dnaLogo);
        dnaEntryPanel.add(labelForImg);

        String name = dnaFolder.getDnaFolder().get(index).getName();
        JLabel labelForName = new JLabel(name);
        dnaEntryPanel.add(labelForName);

        JMenuBar menuBar2 = new JMenuBar();
        JMenu menu = new JMenu("...");
        JMenuItem menuItem1 = new JMenuItem("Modify DNA");
        JMenuItem menuItem2 = new JMenuItem("Add MoClo flanks... to be implemented");
        menu.add(menuItem1);
        menu.add(menuItem2);
        menuBar2.add(menu);
        dnaEntryPanel.add(menuBar2);

        return dnaButton;
    }

}
