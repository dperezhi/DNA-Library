package ui.panels.workspace;

import model.DnaFolder;

import javax.swing.*;
import java.awt.*;

public class MainContent extends JPanel {
    DnaFolder dnaFolder;

    public MainContent(DnaFolder dnaFolder) {
        //displayDnaInfo = new JPanel();
        this.dnaFolder = dnaFolder;
        this.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        this.setLayout(new GridLayout(0,1));
        this.setBackground(Color.orange);

        // needs to be interactive
        this.add(displayNucleotides(1));
        this.add(displayPepetides(1));
        this.add(displayLength(1));

        // p1.add(p1,BorderLayout.CENTER);
    }

    public JPanel displayNucleotides(int index) {
        JPanel displayNucSeq = new JPanel();
        displayNucSeq.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        displayNucSeq.setLayout(new GridLayout(0,1));
        displayNucSeq.setBackground(Color.PINK);

        JLabel l1 = new JLabel("Nucleotide Sequence: ");
        displayNucSeq.add(l1);

        String nucleotideSequence = "5' - " + dnaFolder.getDnaFolder().get(index).getNucleotideSequence() + " - 3'";
        JLabel labelForNucSeq = new JLabel(nucleotideSequence);
        displayNucSeq.add(labelForNucSeq);
        return displayNucSeq;
    }

    public JPanel displayPepetides(int index) {
        JPanel displayProteinSeq = new JPanel();
        displayProteinSeq.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        displayProteinSeq.setLayout(new GridLayout(0,1));
        displayProteinSeq.setBackground(Color.green);

        JLabel l1 = new JLabel("Protein Sequence: ");
        displayProteinSeq.add(l1);

        String proteinSequence = "N - " + dnaFolder.getDnaFolder().get(index).getProteinSequence() + " - C";
        JLabel labelForProteinSeq = new JLabel(proteinSequence);
        displayProteinSeq.add(labelForProteinSeq);
        return displayProteinSeq;
    }

    public JPanel displayLength(int index) {
        JPanel p11 = new JPanel();
        p11.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        p11.setLayout(new GridLayout(0,2));
        p11.setBackground(Color.GRAY);

        String bpLength = "" + dnaFolder.getDnaFolder().get(index).getNucleotideSequence().length();
        JLabel labelBpLength = new JLabel("Length: " + bpLength + " bp");
        p11.add(labelBpLength);
        return p11;
    }

}
