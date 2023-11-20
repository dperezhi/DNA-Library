package ui.panels.buttonFunctionality.popup;

import model.DnaFolder;
import ui.panels.sidebar.DnaDisplayed;

import javax.swing.*;
import java.awt.*;

public class AddDnaFrameInvalidCharacter extends AddDnaFrame {
    public AddDnaFrameInvalidCharacter(DnaFolder dnaFolder, DnaDisplayed updateDnaDisplayPanel) {
        super(dnaFolder, updateDnaDisplayPanel);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        nucleotideSection();

        this.add(super.getPanel(), BorderLayout.CENTER);
        this.pack();
        this.setSize(450, 600);
        this.setVisible(true);
    }

    public void nucleotideSection() {
        super.getPanel().add(new JLabel("What is the nucleotide sequence (valid characters: A,T,G,C,N)? "));
        JTextField nucleotideEntry = new JTextField("   Enter the text...");
        JButton addDnaButton = new GetDnaInfoFromUser(super.getDna(), getNameEntry(), getOrganismEntry(),
                nucleotideEntry, getDnaFolder(), getFrame(), getUpdateDnaDisplayPanel());
        super.getPanel().add(nucleotideEntry);
        super.getPanel().add(addDnaButton);
        super.getPanel().add(new JLabel("Invalid Character(s) Detected. Try Again!"));
    }
}
