package ui.panels.buttonfunctionality.popup.adddna;

import model.DnaFolder;
import ui.panels.sidebar.DnaDisplayed;

import javax.swing.*;
import java.awt.*;

// represents a pop-up frame that is initially created when user wants to add a new DNA to their library
public class AddDnaFrameInitial extends AddDnaFrameAbstract {

    //MODIFIES: this
    //EFFECTS: creates a new AddDnaFrameInitial where user can add a new DNA
    public AddDnaFrameInitial(DnaFolder dnaFolder, DnaDisplayed updateDnaDisplayPanel) {
        super(dnaFolder, updateDnaDisplayPanel);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        nucleotideSection();

        this.add(super.getPanel(), BorderLayout.CENTER);
        this.pack();
        this.setSize(450, 600);
        this.setVisible(true);
    }

    //MODIFIES: super
    //EFFECTS: adds labels and text fields for the nucleotide entry of the DNA to the panel
    public void nucleotideSection() {
        super.getPanel().add(new JLabel("What is the DNA sequence (valid characters: A, T, G, C, N)? "));
        JTextField nucleotideEntry = new JTextField("   Enter the text...");
        JButton addDnaButton;
        addDnaButton = new GetDnaInfoFromUser(getNameEntry(), getOrganismEntry(),nucleotideEntry,
                getDnaFolder(), getFrame(), getUpdateDnaDisplayPanel());
        super.getPanel().add(nucleotideEntry);
        super.getPanel().add(addDnaButton);
    }
}
