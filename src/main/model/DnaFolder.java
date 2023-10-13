package model;

import java.util.ArrayList;

public class DnaFolder {
    private ArrayList<Dna> dnaFolder;

    // EFFECTS: creates DNA folder
    public DnaFolder() {
        dnaFolder = new ArrayList<>();
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
    public boolean modifyDnaDetails(String name, String whatIsModified, String newContent) {
        Dna dnaToModify;
        if ((dnaToModify = findDnaByName(name)) == null) {
            return false;
        }
        switch (whatIsModified) {
            case "1":
                dnaToModify.setSequence(newContent);
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
    public boolean addMoClo(String name) {
        Dna dnaToModify;
        if ((dnaToModify = findDnaByName(name)) == null) {
            return false;
        }
        dnaToModify.setSequence("ctca" + dnaToModify.getSequence() + "cgcg");
        return true;
    }

    //getter and setters
    public ArrayList<Dna> getDnaFolder() {
        return dnaFolder;
    }
}
