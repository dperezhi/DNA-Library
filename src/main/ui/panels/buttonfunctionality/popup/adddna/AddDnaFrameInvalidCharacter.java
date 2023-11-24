package ui.panels.buttonfunctionality.popup.adddna;

import model.DnaFolder;
import ui.panels.sidebar.DnaDisplayed;

import javax.swing.*;
import java.awt.*;

// represents a pop-up frame that is created only if the user inputs a nucleotide sequence with an invalid character.
// when adding a new DNA to their library
public class AddDnaFrameInvalidCharacter extends AddDnaFrameAbstract {

    //MODIFIES: this
    //EFFECTS: creates a new AddDnaFrameInvalidCharacter where user can add a new DNA
    public AddDnaFrameInvalidCharacter(DnaFolder dnaFolder, DnaDisplayed updateDnaDisplayPanel) {
        super(dnaFolder, updateDnaDisplayPanel);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        nucleotideSection();

        this.add(super.getPanel(), BorderLayout.CENTER);
        this.pack();
        this.setSize(450, 600);
        this.setVisible(true);
    }

    //MODIFIES: super
    //EFFECTS: adds labels and text fields for the nucleotide entry of the DNA to the panel, while warning user to not
    //         input invalid characters
    public void nucleotideSection() {
        super.getPanel().add(new JLabel("What is the nucleotide sequence (valid characters: A,T,G,C,N)? "));
        JTextField nucleotideEntry = new JTextField("   Enter the text...");
        JButton addDnaButton = new GetDnaInfoFromUser(getNameEntry(), getOrganismEntry(),
                nucleotideEntry, getDnaFolder(), getFrame(), getUpdateDnaDisplayPanel());
        super.getPanel().add(nucleotideEntry);
        super.getPanel().add(addDnaButton);
        super.getPanel().add(new JLabel("Invalid Character(s) Detected. Try Again!"));
    }
}
