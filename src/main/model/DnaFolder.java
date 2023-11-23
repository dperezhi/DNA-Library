package model;

import exceptions.InvalidCharForNucSeqException;
import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;

// Represents a DNA list with an arbitrary number of DNA objects
public class DnaFolder implements Writable {
    private final ArrayList<Dna> dnaFolder;
    private String name = "default";

    // EFFECTS: creates DNA folder with default name
    public DnaFolder() {
        dnaFolder = new ArrayList<>();
    }

    // EFFECTS: creates DNA folder with a given name
    public DnaFolder(String name) {
        this();
        this.name = name;
    }

    // MODIFIES: this
    // EFFECTS: adds DNA sequence to folder
    public boolean addDna(Dna dna) {
        if (!dnaFolder.contains(dna)) {
            dnaFolder.add(dna);
            return true;
        }
        return false;
    }

    // EFFECTS: Displays names of all DNAs in folder
    public String getDnaNames() {
        StringBuilder dnaNames = new StringBuilder();
        boolean first = true;
        for (Dna dna : dnaFolder) {
            if (!first) {
                dnaNames.append(", ").append(dna.getName());
            } else {
                dnaNames.append(dna.getName());
                first = false;
            }
        }
        return dnaNames.toString();
    }

    // EFFECTS: returns DNA based on name call
    public Dna findDnaByName(String name) {
        Dna chosen;
        for (Dna dna : dnaFolder) {
            if (dna.getName().equalsIgnoreCase(name)) {
                chosen = dna;
                return chosen;
            }
        }
        return null;
    }

    // MODIFIES: this
    // EFFECTS: modifies DNA fields based on user preference
    public boolean modifyDnaDetails(String name, String whatIsModified, String newContent)
            throws InvalidCharForNucSeqException {
        Dna dnaToModify;
        if ((dnaToModify = findDnaByName(name)) == null) {
            return false;
        }
        switch (whatIsModified) {
            case "1":
                dnaToModify.setNucleotideSequence(newContent);
                break;
            case "2":
                dnaToModify.setName(newContent);
                break;
            case "3":
                dnaToModify.setOrganism(newContent);
                break;
            default:
                return false;
        }
        return true;
    }

    // MODIFIES: this
    // EFFECTS: adds MoClo ends to DNA sequence
    public boolean addMoClo(String name) throws InvalidCharForNucSeqException {
        Dna dnaToModify;
        if ((dnaToModify = findDnaByName(name)) == null) {
            return false;
        }
        dnaToModify.setNucleotideSequence("ctca" + dnaToModify.getNucleotideSequence() + "cgcg");
        return true;
    }

    //getter and setters
    public ArrayList<Dna> getDnaFolder() {
        return dnaFolder;
    }

    @Override
    // EFFECTS: creates a JSON DnaFolder Object, citation -https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("DNA Sequences", dnaSequencesToJson());
        return json;
    }

    // EFFECTS: returns dna sequence in this Dna Folder as a JSON array
    private JSONArray dnaSequencesToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Dna dna : dnaFolder) {
            jsonArray.put(dna.toJson());
        }

        return jsonArray;
    }

    //EFFECTS: returns name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
