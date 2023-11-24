package ui.panels.sidebar;

import model.Dna;
import model.DnaFolder;
import ui.Main;
import ui.panels.buttonfunctionality.DisplayDnaToWorkspaceButton;
import ui.panels.workspace.MainContent;

import javax.swing.*;
import java.awt.*;

// represents a panel within the SideBar panel in which all the name's of the DNAs within the DNA folder can be seen
public class DnaDisplayed extends JPanel {
    private DnaFolder dnaFolder;
    private MainContent displayPanel;

    //MODIFIES: this
    //EFFECTS: creates the panel in which all DNAs within the dnaFolder can be observed
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

    //MODIFIES: this
    //EFFECTS: adds a new DNA panel/button within the DNADisplay panel
    public void addExtraDnaToInterface() {
        this.add(addDnaToInterface(dnaFolder.getDnaFolder().size() - 1));
    }

    //EFFECTS: creates a new DNA button/panel within the DnaDisplayed Panel, represented by the DNA name
    public JButton addDnaToInterface(int index) {
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
        JMenuItem menuItem1 = new JMenuItem("Modify DNA");
        JMenuItem menuItem2 = new JMenuItem("Add MoClo flanks... to be implemented");
        menu.add(menuItem1);
        menu.add(menuItem2);
        menuBar2.add(menu);
        dnaEntryPanel.add(menuBar2);
        return dnaButton;
    }

}
