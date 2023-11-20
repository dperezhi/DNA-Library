package ui.panels.buttonFunctionality.popup;

import model.DnaFolder;

import javax.swing.*;
import java.awt.*;

public class AddDnaFrameInitial extends AddDnaFrame {

    public AddDnaFrameInitial(DnaFolder dnaFolder, JFrame frame) {
        super(dnaFolder, frame);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        nucleotideSection();

        this.add(super.getPanel(), BorderLayout.CENTER);
        this.pack();
        this.setSize(450, 600);
        this.setVisible(true);
    }

    public void nucleotideSection() {
        super.getPanel().add(new JLabel("What is the DNA sequence (valid characters: A, T, G, C, N)? "));
        JTextField nucleotideEntry = new JTextField("   Enter the text...");
        JButton addDnaButton;
        addDnaButton = new GetNucleotideSeqFromUser(super.getDna(), nucleotideEntry, getDnaFolder(), getFrame());
        super.getPanel().add(nucleotideEntry);
        super.getPanel().add(addDnaButton);
    }
}
