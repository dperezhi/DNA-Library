package model;

import exceptions.InvalidCharForNucSeqException;
import org.json.JSONObject;
import persistence.Writable;

// Represents a DNA having a sequence, name, organism and length
public class Dna implements Writable {
    private NucleotideSequence nucleotideSequence;                            //DNA sequence
    private String name;                                          //DNA name
    private String organism;                                      //DNA sequence Origin organism
    private ProteinSequence proteinSequence;                      //Protein sequence

    /*
     * EFFECTS: Empty DNA object
     */
    public Dna() {
        this.name = "new";
    }

    /*
     * REQUIRES: sequence is 3 or more characters in length and only contains A,G,C,T
     * MODIFIES: this
     * EFFECTS: sequence string is set to sequence; name string is set to string
     *          the length is set to the sequence length; Organism is set. The protein sequence is generated.
     */
    public Dna(String name, String nucleotideSequence, String organism) throws InvalidCharForNucSeqException {
        this.nucleotideSequence = new NucleotideSequence(nucleotideSequence);
        this.name = name;
        this.organism = organism;
        proteinSequence = new ProteinSequence(nucleotideSequence);
    }

    //EFFECTS: returns a string with all the field values of the DNA object
    public String toString() {
        String sequenceString = "Sequence='" + nucleotideSequence.getNucleotideSequence();
        String result = '\'' + ", name='" + name + '\'' + ", organism='" + organism + '\'';
        return sequenceString + result + ", proteinSequence='" + proteinSequence.getProteinSequence() + "'";
    }


    /*
     * JSON SAVE AND LOAD SYSTEM
     */

    @Override
    // EFFECTS: creates a JSON Dna Object, citation -https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("sequence", nucleotideSequence.getNucleotideSequence());
        json.put("organism", organism);
        return json;
    }


    /*
     * GETTERS AND SETTERS
     */

    //EFFECTS: gets nucleotide sequence
    public String getNucleotideSequence() {
        return nucleotideSequence.getNucleotideSequence();
    }

    //MODIFIES: this
    //EFFECTS: set the a new value for sequence
    public void setNucleotideSequence(String nucleotideSequence) throws InvalidCharForNucSeqException {
        this.nucleotideSequence = new NucleotideSequence(nucleotideSequence);
    }

    //EFFECTS: gets name
    public String getName() {
        return name;
    }

    //MODIFIES: this
    //EFFECTS: set the a new value for name
    public void setName(String name) {
        this.name = name;
    }

    //EFFECTS: gets organism
    public String getOrganism() {
        return organism;
    }

    //MODIFIES: this
    //EFFECTS: set the a new value for organism
    public void setOrganism(String organism) {
        this.organism = organism;
    }

    //EFFECTS: gets protein sequence
    public String getProteinSequence() {
        return proteinSequence.getProteinSequence();
    }
}