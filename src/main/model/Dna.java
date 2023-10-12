package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

// Represents a DNA  having a sequence, name, organism and length
public class Dna {
    private String sequence;
    private String name;
    private String organism;
    private int length;
    private String proteinSequence;

    /*
     * REQUIRES: sequence has a non-zero length and only contains A,G,C,T
     * EFFECTS: sequence string is set to sequence; name string is set to string
     *          the length is set to the sequence length. author and organism
     *          remain null.
     */
    public Dna(String name, String sequence, String organism) {
        this.sequence = sequence;
        this.name = name;
        length = sequence.length();
        this.proteinSequence = makeProteinSequence();
        this.organism = organism;
    }


    public String makeProteinSequence() {
        String path = "./src/main/content/amino-acid-codons.csv";
        String line = "";
        ArrayList<String> codons = new ArrayList<>();
        ArrayList<String> aminoAcids = new ArrayList<>();
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(path));
            while ((line = fileReader.readLine()) != null) {
                String[] data = line.split(",");
                codons.add(data[0]);
                aminoAcids.add(data[1]);
            }
        } catch (Exception e) {
            e.getMessage();
            e.toString();
        }
        return determineAminoAcidChain(codons, aminoAcids);
    }

    public String determineAminoAcidChain(ArrayList<String> codons, ArrayList<String> aminoAcids) {
        String polypeptide = "";
        int lowerIndex = 0;
        int higherIndex = 3;
        String translatableSequence = sequence;
        ;
        int value;
        if ((value = length % 3) != 0) {
            translatableSequence = sequence.substring(0, (length - value));
        }
        for (int i = 3; i <= length; i += 3) {
            String codon = translatableSequence.substring(lowerIndex, higherIndex);
            int index = 0;
            for (String templateCodon : codons) {
                if (templateCodon.equalsIgnoreCase(codon)) {
                    break;
                }
                index++;
            }
            polypeptide += aminoAcids.get(index);
            lowerIndex += 3;
            higherIndex += 3;
        }
        return polypeptide;
    }

    public String toString() {
        String result = "Sequence='" + sequence + '\'' + ", name='" + name + '\'' + ", organism='" + organism + '\'';
        return result + "proteinSequence='" + proteinSequence;
    }

    //Getters and Setters
    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrganism() {
        return organism;
    }

    public void setOrganism(String organism) {
        this.organism = organism;
    }

    public String getProteinSequence() {
        return proteinSequence;
    }
}
