package ui.panels.buttonFunctionality.popup;

import exceptions.InvalidCharForNucSeqException;
import model.Dna;
import model.DnaFolder;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public abstract class AddDnaFrame extends JFrame {
    private JPanel panel;
    private DnaFolder dnaFolder;
    private Dna dna;
    private JFrame frame;
    JTextField nameEntry;
    JTextField organismEntry;

    public AddDnaFrame(DnaFolder dnaFolder) {
        super("Add DNA to the library!");
        this.dnaFolder = dnaFolder;
        this.frame = this;
        //this.frame = Objects.requireNonNullElse(frame, this);
        this.dna = new Dna();

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        panel.setLayout(new GridLayout(0,1));

        nameSection();
        organismSection();
        //nucleotideSection();

        //dnaFolder.addDna(dna);

        /*this.add(panel, BorderLayout.CENTER);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.pack();
        this.setSize(290, 350);
        this.setVisible(true);*/
    }

    public void nameSection() {
        panel.add(new JLabel("What is the name for this DNA? "));
        nameEntry = new JTextField("   Enter the text...");
        //JButton nameButton = new GetNameFromUser(dna, nameEntry);
        panel.add(nameEntry);
        //panel.add(nameButton);
    }

    public void organismSection() {
        panel.add(new JLabel("From what organism does this DNA come from? "));
        organismEntry = new JTextField("   Enter the text...");
        //JButton organismButton = new GetOrganismFromUser(dna, organismEntry);
        panel.add(organismEntry);
        //panel.add(organismButton);
    }

    public abstract void nucleotideSection();

    public JTextField getNameEntry() {
        return nameEntry;
    }

    public JTextField getOrganismEntry() {
        return organismEntry;
    }

    public JPanel getPanel() {
        return panel;
    }

    public DnaFolder getDnaFolder() {
        return dnaFolder;
    }

    public JFrame getFrame() {
        return frame;
    }

    public Dna getDna() {
        return dna;
    }
}
