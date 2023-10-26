package ui;

import model.*;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class DnaLibraryApp {
    private static final String JSON_STORE = "./data/dnaLibrary.json";
    private static Scanner in;
    private static DnaFolder dnaFolder;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    // MODIFIES: this
    // EFFECTS: creates a new DnaLibraryApp
    public DnaLibraryApp() throws FileNotFoundException {
        in = new Scanner(System.in);
        dnaFolder = new DnaFolder();
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        choiceToLoad();
        mainMenu();
        in.close();
    }

    // MODIFIES: this
    // EFFECTS: loads DnaFolder from file
    private void loadDnaFolder() {
        try {
            dnaFolder = jsonReader.read();
            System.out.println("Loaded " + dnaFolder.getName() + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
            startNew();
        }
    }

    // MODIFIES: this
    // EFFECTS: adds new sequences to the default Dna Folder
    public void startNew() {
        System.out.println("A DNA Library has been created for you!\n");
        System.out.println("Add a DNA sequence:");
        addSequence();
        boolean addAnotherSeq = true;
        while (addAnotherSeq) {
            if (addAnotherSeq = choiceYesOrNo("Do you want to add a another DNA sequence")) {
                addSequence();
            } else {
                System.out.println("Loading...");
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: adds new sequences to the Dna Folder
    public void addSequence() {
        System.out.println("    What is the title of the sequence? ");
        String name = in.nextLine();
        System.out.println("    What are the nucleotides? ");
        String sequence = in.nextLine();
        System.out.println("    What is the organism of origin? ");
        String organism = in.nextLine();
        Dna dna = new Dna(name, sequence, organism);
        dnaFolder.addDna(dna);
        System.out.println("    Protein Translation: " + dna.getProteinSequence());
    }

    // EFFECTS: displays menu options
    public void menuDisplay() {
        System.out.println("Main Menu");
        System.out.println("These are the current DNAs in your folder: ");
        showDnaFolder();
        System.out.println("Choose one of the following options (1, 2, 3, or 4):");
        System.out.println("(1) Add MoClo flanks to a sequence");
        System.out.println("(2) Add a DNA Sequence");
        System.out.println("(3) Modify a DNA Sequence");
        System.out.println("(4) Close");
    }

    // EFFECTS: gets decision of user to access menu options
    public boolean menuDecision(String answer) {
        switch (answer) {
            case "1":
                addMoClo();
                break;
            case "2":
                addSequence();
                break;
            case "3":
                modifyDnaDetails();
                break;
            case "4":
                return true;
            default:
                System.out.println("Invalid input!");
        }
        return false;
    }

    // EFFECTS: main menu options
    public void mainMenu() {
        boolean over;
        do {
            menuDisplay();
            String answer = in.nextLine();
            over = menuDecision(answer);
            if (!again()) {
                over = true;
            }
        } while (!over);
        choiceToSave();
        System.out.println("Goodbye!");
    }

    // EFFECTS: asks the user if they want to continue on the software
    public boolean again() {
        return choiceYesOrNo("Do you want to continue on the Software");
    }

    // EFFECTS: shows the names of the DNA sequences
    public void showDnaFolder() {
        System.out.println("[" + dnaFolder.getDnaNames() + "]");
    }

    // EFFECTS: adds MoClo flanks to the DNA sequence
    public void addMoClo() {
        System.out.println("Which of the following DNA sequences do you want to add MoClo flanks?");
        showDnaFolder();
        String name = in.nextLine();
        Dna dna = dnaFolder.findDnaByName(name);
        System.out.println(dna.toString());
        if (dnaFolder.addMoClo(name)) {
            System.out.println("MoClo flanks added Successful!");
            System.out.println("New Sequence: " + dna.getSequence());
        } else {
            System.out.println("Failure. An Invalid Input was detected!");
        }
    }

    // EFFECTS: modifies the DNA sequence's details
    public void modifyDnaDetails() {
        System.out.println("Which of the following DNA sequences do you want to modify?");
        String name = in.nextLine();
        System.out.println("What do you want to modify (Sequence, Name, or Organism)? ");
        System.out.println("(1) sequence, (2) name, and (3) organism");
        String modified = in.nextLine();
        System.out.println("What is the new content? ");
        String newContent = in.nextLine();
        if (dnaFolder.modifyDnaDetails(name, modified, newContent)) {
            System.out.println("Successful!");
            System.out.println(name + " is now: ");
            Dna dna = dnaFolder.findDnaByName(name);
            System.out.println(dna.toString());
        } else {
            System.out.println("Failure. An invalid input was detected!");
        }
    }

    // EFFECTS: asks the user if they want to load the Dna library
    public void choiceToLoad() {
        if (choiceYesOrNo("Do you want to load a DNA Library")) {
            loadDnaFolder();
        } else {
            startNew();
        }
    }

    // EFFECTS: saves the Dna Folder to file
    private void saveDnaFolder() {
        try {
            jsonWriter.open();
            jsonWriter.write(dnaFolder);
            jsonWriter.close();
            System.out.println("Saved " + dnaFolder.getName() + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // EFFECTS: asks the user if they want to save the Dna Library
    public void choiceToSave() {
        if (choiceYesOrNo("Do you want to save your DNA Library")) {
            saveDnaFolder();
        } else {
            System.out.println("Not Saved!");
        }
    }

    public boolean choiceYesOrNo(String message) {
        String answer;
        do {
            System.out.println(message + " ('yes' or 'no')?");
            answer = in.nextLine();
            if (answer.equalsIgnoreCase("yes")) {
                return true;
            } else if (answer.equalsIgnoreCase("no")) {
                return false;
            } else {
                System.out.println("Invalid input. Try again!");
            }
        } while (!answer.equalsIgnoreCase("yes") && !answer.equalsIgnoreCase("no"));
        return false;
    }
}