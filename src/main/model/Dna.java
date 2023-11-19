package model;

import exceptions.InvalidCharForNucSeqException;
import org.json.JSONObject;
import persistence.Writable;

// Represents a DNA having a sequence, name, organism and length
public class Dna implements Writable {
    private NucleotideSequence nucelotideSequence;                            //DNA sequence
    private String name;                                          //DNA name
    private String organism;                                      //DNA sequence Origin organism
    private ProteinSequence proteinSequence;                      //Protein sequence

    /*
     * REQUIRES: sequence is 3 or more characters in length and only contains A,G,C,T
     * MODIFIES: this
     * EFFECTS: sequence string is set to sequence; name string is set to string
     *          the length is set to the sequence length; Organism is set. The protein sequence is generated.
     */
    public Dna(String name, String nucelotideSequence, String organism) throws InvalidCharForNucSeqException {
        this.nucelotideSequence = new NucleotideSequence(nucelotideSequence);
        this.name = name;
        this.organism = organism;
        proteinSequence = new ProteinSequence(nucelotideSequence);
    }

    //EFFECTS: returns a string with all the field values of the DNA object
    public String toString() {
        String result = "Sequence='" + nucelotideSequence.getNucleotideSequence() + '\'' + ", name='" + name + '\'' + ", organism='" + organism + '\'';
        return result + ", proteinSequence='" + proteinSequence.getProteinSequence() + "'";
    }


    /*
     * JSON SAVE AND LOAD SYSTEM
     */

    @Override
    // EFFECTS: creates a JSON Dna Object, citation -https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("sequence", nucelotideSequence.getNucleotideSequence());
        json.put("organism", organism);
        return json;
    }


    /*
     * GETTERS AND SETTERS
     */

    //EFFECTS: gets nucleotide sequence
    public String getNucelotideSequence() {
        return nucelotideSequence.getNucleotideSequence();
    }

    //MODIFIES: this
    //EFFECTS: set the a new value for sequence
    public void setNucelotideSequence(String nucelotideSequence) throws InvalidCharForNucSeqException {
        this.nucelotideSequence = new NucleotideSequence(nucelotideSequence);
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