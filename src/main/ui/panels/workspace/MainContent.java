package ui.panels.workspace;

import model.DnaFolder;
import model.Dna;
import ui.GUI;

import javax.swing.*;
import java.awt.*;

public class MainContent extends JPanel {
    private DnaFolder dnaFolder;
    private Dna dna;
    private GUI masterGui;
    private JLabel emptyLabel;

    /*public MainContent(DnaFolder dnaFolder, GUI masterGui) {
        //displayDnaInfo = new JPanel();
        this.dnaFolder = dnaFolder;
        this.masterGui = masterGui;
        this.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        this.setLayout(new GridLayout(0,1));
        this.setBackground(Color.orange);

        // needs to be interactive
        //this.add(displayNucleotides(1));
        //this.add(displayPepetides(1));
        //this.add(displayLength(1));

        // p1.add(p1,BorderLayout.CENTER);
        masterGui.setWorkSpacePanel(this);
    }*/

    public MainContent(GUI masterGui) {
        this.masterGui = masterGui;
        this.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        this.setLayout(new GridLayout(0,1));
        this.setBackground(Color.orange);

        emptyLabel = new JLabel("Empty: nothing selected yet!");
        this.add(emptyLabel);
        masterGui.setWorkSpacePanel(this);
    }

    public void update(Dna dna) {
        this.dna = dna;
        this.removeAll();
        this.revalidate();
        this.repaint();
        //this.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        //this.setLayout(new GridLayout(0,1));
        //this.setBackground(Color.orange);

        this.add(displayNucleotides(dna));
        this.add(displayPepetides(dna));
        this.add(displayLength(dna));
    }

    // remove INDEX parameter and change dnaFolder.getDnaFolder().get(index) for dna
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

    public JPanel displayPepetides(Dna dna) {
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
