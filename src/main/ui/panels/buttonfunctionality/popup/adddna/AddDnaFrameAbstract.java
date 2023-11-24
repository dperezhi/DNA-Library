package ui.panels.buttonfunctionality.popup.adddna;

import model.Dna;
import model.DnaFolder;
import ui.panels.sidebar.DnaDisplayed;

import javax.swing.*;
import java.awt.*;

// represents an abstract class in which a pop-up frame is created to prompt the user to add a new DNA
public abstract class AddDnaFrameAbstract extends JFrame {
    private JPanel panel;
    private DnaFolder dnaFolder;
    private JFrame frame;
    private DnaDisplayed updateDnaDisplayPanel;
    private JTextField nameEntry;
    private JTextField organismEntry;

    //MODIFIES: this
    //EFFECTS: sets up a AddDnaFrameAbstract where the user can input details of a new DNA
    public AddDnaFrameAbstract(DnaFolder dnaFolder, DnaDisplayed updateDnaDisplayPanel) {
        super("Add DNA to the library!");
        this.dnaFolder = dnaFolder;
        this.updateDnaDisplayPanel = updateDnaDisplayPanel;
        this.frame = this;

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        panel.setLayout(new GridLayout(0,1));

        nameSection();
        organismSection();
    }

    //MODIFIES: this
    //EFFECTS: adds labels and text fields for the name entry of the DNA to the panel
    public void nameSection() {
        panel.add(new JLabel("What is the name for this DNA? "));
        nameEntry = new JTextField("   Enter the text...");
        panel.add(nameEntry);
    }

    //MODIFIES: this
    //EFFECTS: adds labels and text fields for the organism entry of the DNA to the panel
    public void organismSection() {
        panel.add(new JLabel("From what organism does this DNA come from? "));
        organismEntry = new JTextField("   Enter the text...");
        panel.add(organismEntry);
    }

    //EFFECTS: abstract method for the nucleotide section of the panel
    public abstract void nucleotideSection();

    //EFFECTS: returns the name of the entry
    public JTextField getNameEntry() {
        return nameEntry;
    }

    //EFFECTS: returns the organism of the entry
    public JTextField getOrganismEntry() {
        return organismEntry;
    }

    //EFFECTS: returns the dna display panel for which the DNA addition will be seen
    public DnaDisplayed getUpdateDnaDisplayPanel() {
        return updateDnaDisplayPanel;
    }

    //EFFECTS: returns the pop-up panel in which the addition of the DNA will take place
    public JPanel getPanel() {
        return panel;
    }

    //EFFECTS: returns the dnaFolder in which the DNA will be added
    public DnaFolder getDnaFolder() {
        return dnaFolder;
    }

    //EFFECTS: returns the pop-up frame in which the addition of the DNA will take place
    public JFrame getFrame() {
        return frame;
    }
}
