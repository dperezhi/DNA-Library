package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

// Represents a protein sequence given a nucleotide sequence
public class ProteinSequence {
    private String proteinSequence;
    private String nucleotideSequence;
    private int length;

    /*
     * REQUIRES: nucleotide sequence is 3 or more characters in length and only contains A,G,C,T
     * MODIFIES: this
     * EFFECTS: The protein sequence is generated based on nucleotide sequence.
     */
    public ProteinSequence(String nucleotideSequence) {
        this.nucleotideSequence = nucleotideSequence;
        this.length = nucleotideSequence.length();
        proteinSequence = makeProteinSequence();
    }


    /*
     * METHODS
     */

    //EFFECTS: returns protein sequence translated from the DNA sequence.
    private String makeProteinSequence() {
        String path = "./src/main/content/amino-acid-codons.csv";
        String line;
        ArrayList<String> codons = new ArrayList<>();
        ArrayList<String> aminoAcids = new ArrayList<>();
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(path));
            while ((line = fileReader.readLine()) != null) {
                String[] data = line.split(",");
                codons.add(data[0]);
                aminoAcids.add(data[1]);
            }
        } catch (IOException e) {
            //System.out.println(e.getMessage());
        }
        return determineAminoAcidChain(codons, aminoAcids);
    }

    //EFFECTS: returns Protein sequence based on codon codes.
    private String determineAminoAcidChain(ArrayList<String> codons, ArrayList<String> aminoAcids) {
        StringBuilder polypeptide = new StringBuilder();
        int lowerIndex = 0;
        int higherIndex = 3;
        String translatableSequence = getTranslatableSequence();
        for (int i = 3; i <= length; i += 3) {
            String codon = translatableSequence.substring(lowerIndex, higherIndex);
            int index = 0;
            for (String templateCodon : codons) {
                if (templateCodon.equalsIgnoreCase(codon)) {
                    break;
                }
                index++;
            }
            if (index == 64) {
                polypeptide.append("X");
            } else {
                polypeptide.append(aminoAcids.get(index));
            }
            lowerIndex += 3;
            higherIndex += 3;
        }
        return polypeptide.toString();
    }

    //EFFECTS: gets translatableSequence from sequence
    public String getTranslatableSequence() {
        String translatableSequence = nucleotideSequence;
        int value;
        if ((value = length % 3) != 0) {
            translatableSequence = nucleotideSequence.substring(0, (length - value));
        }
        return translatableSequence;
    }


    /*
     * GETTERS
     */

    //EFFECTS: gets protein sequence
    public String getProteinSequence() {
        return proteinSequence;
    }

    //EFFECTS: gets nucleotide sequence
    public String getNucleotideSequence() {
        return nucleotideSequence;
    }
}
