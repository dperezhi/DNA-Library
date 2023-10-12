package model;

import java.util.ArrayList;

public class DnaList {
    private ArrayList<Dna> dnaList;

    public DnaList() {
        dnaList = new ArrayList<>();
    }

    public boolean addDna(Dna dna) {
        if (!dnaList.contains(dna)) {
            dnaList.add(dna);
            return true;
        }
        return false;
    }

    public String showListNames() {
        StringBuilder listNames = new StringBuilder();
        boolean first = true;
        for (Dna dna : dnaList) {
            if (!first) {
                listNames.append(", ").append(dna.getName());
            } else {
                listNames.append(dna.getName());
                first = false;
            }
        }
        return listNames.toString();
    }

    public Dna findDna(String name) {
        Dna chosen;
        for (Dna dna : dnaList) {
            if (dna.getName().equalsIgnoreCase(name)) {
                chosen = dna;
                return chosen;
            }
        }
        return null;
    }

    public boolean modifyDna(String name, String whatIsModified, String newContent) {
        Dna dnaToModify;
        if ((dnaToModify = findDna(name)) == null) {
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

    public boolean addMoClo(String name) {
        Dna dnaToModify;
        if ((dnaToModify = findDna(name)) == null) {
            return false;
        }
        dnaToModify.setSequence("ctca" + dnaToModify.getSequence() + "cgcg");
        return true;
    }
}
