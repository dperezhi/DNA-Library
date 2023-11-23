package ui.panels.sidebar;

import model.Dna;
import model.DnaFolder;
import ui.Main;
import ui.panels.buttonfunctionality.DisplayDnaToWorkspaceButton;
import ui.panels.workspace.MainContent;

import javax.swing.*;
import java.awt.*;

public class DnaDisplayed extends JPanel {
    private DnaFolder dnaFolder;
    private MainContent displayPanel;

    public DnaDisplayed(DnaFolder dnaFolder, MainContent displayPanel) {
        this.dnaFolder = dnaFolder;
        this.displayPanel = displayPanel;
        this.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        this.setLayout(new GridLayout(0,1));
        this.setBackground(Color.MAGENTA);

        for (int i = 0; i < dnaFolder.getDnaFolder().size(); i++) {
            this.add(addDnaToInterface(i));
        }
    }

    public void addExtraDnaToInterface() {
        this.add(addDnaToInterface(dnaFolder.getDnaFolder().size() - 1));
    }

    public JButton addDnaToInterface(int index) { //ui.panels.buttonFunctionality.DisplayDnaToWorkspace
        Dna dna = dnaFolder.getDnaFolder().get(index);
        DisplayDnaToWorkspaceButton dnaButton = new DisplayDnaToWorkspaceButton(dna, displayPanel);
        JPanel dnaEntryPanel = new JPanel();
        dnaButton.add(dnaEntryPanel);

        dnaEntryPanel.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        dnaEntryPanel.setLayout(new GridLayout(0,3));
        dnaEntryPanel.setBackground(Color.red);

        ImageIcon dnaLogo = new ImageIcon("./src/main/img/dna.png");
        dnaLogo.setImage(dnaLogo.getImage().getScaledInstance(35,35, 1));
        JLabel labelForImg = new JLabel(dnaLogo);
        dnaEntryPanel.add(labelForImg);

        String name = dna.getName();
        JLabel labelForName = new JLabel(name);
        dnaEntryPanel.add(labelForName);

        JMenuBar menuBar2 = new JMenuBar();
        JMenu menu = new JMenu("...");
        //ui.panels.buttonFunctionality.ModifyDna
        JMenuItem menuItem1 = new JMenuItem("Modify DNA");
        //ui.panels.buttonFunctionality.AddsMoCloFlanks
        JMenuItem menuItem2 = new JMenuItem("Add MoClo flanks... to be implemented");
        menu.add(menuItem1);
        menu.add(menuItem2);
        menuBar2.add(menu);
        dnaEntryPanel.add(menuBar2);

        return dnaButton;
    }

}
