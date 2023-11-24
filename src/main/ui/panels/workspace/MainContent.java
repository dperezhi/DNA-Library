package ui.panels.workspace;

import model.DnaFolder;
import model.Dna;
import ui.GUI;

import javax.swing.*;
import java.awt.*;

//represents a panel where the main content of the dna library can be seen
public class MainContent extends JPanel {
    private DnaFolder dnaFolder;
    private Dna dna;
    private GUI masterGui;
    private JLabel emptyLabel;


    //MODIFIES: this
    //EFFECTS: create the main content panel within in the workspace
    public MainContent(GUI masterGui) {
        this.masterGui = masterGui;
        this.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        this.setLayout(new GridLayout(0,1));
        this.setBackground(Color.orange);

        emptyLabel = new JLabel("Empty: nothing selected yet!");
        this.add(emptyLabel);
        masterGui.setWorkSpacePanel(this);
    }

    //MODIFIES: this
    //EFFECTS: updates the main content of the DNA display system when the DNA button is pressed
    public void update(Dna dna) {
        this.dna = dna;
        this.removeAll();
        this.revalidate();
        this.repaint();

        this.add(displayNucleotides(dna));
        this.add(displayPeptides(dna));
        this.add(displayLength(dna));
    }

    //EFFECTS: sets up a panel within the main content panel in which the nucleotide seq of the DNA can be observed
    public JPanel displayNucleotides(Dna dna) {
        JPanel displayNucSeq = new JPanel();
        displayNucSeq.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        displayNucSeq.setLayout(new GridLayout(0,1));
        displayNucSeq.setBackground(Color.PINK);

        JLabel l1 = new JLabel("Nucleotide Sequence: ");
        displayNucSeq.add(l1);

        String nucleotideSequence = "5' - " + dna.getNucleotideSequence() + " - 3'";
        JLabel labelForNucSeq = new JLabel(nucleotideSequence);
        displayNucSeq.add(labelForNucSeq);
        return displayNucSeq;
    }

    //EFFECTS: sets up a panel within the main content panel in which the peptide seq of the DNA can be observed
    public JPanel displayPeptides(Dna dna) {
        JPanel displayProteinSeq = new JPanel();
        displayProteinSeq.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        displayProteinSeq.setLayout(new GridLayout(0,1));
        displayProteinSeq.setBackground(Color.green);

        JLabel l1 = new JLabel("Protein Sequence: ");
        displayProteinSeq.add(l1);

        String proteinSequence = "N - " + dna.getProteinSequence() + " - C";
        JLabel labelForProteinSeq = new JLabel(proteinSequence);
        displayProteinSeq.add(labelForProteinSeq);
        return displayProteinSeq;
    }

    //EFFECTS: sets up a panel within the main content panel in which the length of the DNA seq can be observed
    public JPanel displayLength(Dna dna) {
        JPanel p11 = new JPanel();
        p11.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        p11.setLayout(new GridLayout(0,2));
        p11.setBackground(Color.GRAY);

        String bpLength = "" + dna.getNucleotideSequence().length();
        JLabel labelBpLength = new JLabel("Length: " + bpLength + " bp");
        p11.add(labelBpLength);
        return p11;
    }
}
