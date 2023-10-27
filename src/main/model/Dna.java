package model;

import org.json.JSONObject;
import persistence.Writable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

// Represents a DNA having a sequence, name, organism and length
public class Dna implements Writable {
    private String sequence;            //DNA sequence
    private String name;                //DNA name
    private String organism;            //DNA sequence Origin organism
    private final int length;                 //length of DNA sequence
    private final String proteinSequence;     //Protein sequence

    /*
     * REQUIRES: sequence is 3 or more characters in length and only contains A,G,C,T
     * MODIFIES: this
     * EFFECTS: sequence string is set to sequence; name string is set to string
     *          the length is set to the sequence length; Organism is set. The protein sequence is generated and set.
     */
    public Dna(String name, String sequence, String organism) {
        this.sequence = sequence;
        this.name = name;
        length = sequence.length();
        this.proteinSequence = makeProteinSequence();
        this.organism = organism;
    }

    /*
     * EFFECTS: returns protein sequence translated from the DNA sequence.
     */
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
            System.out.println(e.getMessage());
        }
        return determineAminoAcidChain(codons, aminoAcids);
    }

    /*
     * EFFECTS: returns Protein sequence based on codon codes.
     */
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

    /*
     * EFFECTS: gets translatableSequence from sequence
     */
    public String getTranslatableSequence() {
        String translatableSequence = sequence;
        int value;
        if ((value = length % 3) != 0) {
            translatableSequence = sequence.substring(0, (length - value));
        }
        return translatableSequence;
    }

    /*
     * EFFECTS: returns a string with all the field values of the DNA object
     */
    public String toString() {
        String result = "Sequence='" + sequence + '\'' + ", name='" + name + '\'' + ", organism='" + organism + '\'';
        return result + ", proteinSequence='" + proteinSequence + "'";
    }

    //Getters and Setters
    public String getSequence() {
        return sequence;
    }

    /*
     * MODIFIES: this
     * EFFECTS: set the a new value for sequence
     */
    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public String getName() {
        return name;
    }

    /*
     * MODIFIES: this
     * EFFECTS: set the a new value for name
     */
    public void setName(String name) {
        this.name = name;
    }

    /*
     * EFFECTS: gets organism
     */
    public String getOrganism() {
        return organism;
    }

    /*
     * MODIFIES: this
     * EFFECTS: set the a new value for organism
     */
    public void setOrganism(String organism) {
        this.organism = organism;
    }

    /*
     * EFFECTS: gets protein sequence
     */
    public String getProteinSequence() {
        return proteinSequence;
    }


    @Override
    // EFFECTS: creates a JSON Dna Object, citation -https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("sequence", sequence);
        json.put("organism", organism);
        return json;
    }
}