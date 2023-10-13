package ui;

import model.Dna;
import model.DnaFolder;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        DnaFolder folder = new DnaFolder();
        System.out.println("A DNA folder has been created for you!");
        boolean key = true;
        System.out.println("Add a DNA sequence:");
        addSequence(folder, in);
        do {
            System.out.println("Do you want to add a another DNA sequence?");
            String answer = in.nextLine();
            if (answer.equalsIgnoreCase("yes")) {
                addSequence(folder, in);
            } else {
                key = false;
            }
        } while (key);
        mainMenu(folder, in);
        in.close();
    }

    public static void addSequence(DnaFolder folder, Scanner in) {
        System.out.println("What is the title of the sequence? ");
        String name = in.nextLine();
        System.out.println("What are the nucleotides? ");
        String sequence = in.nextLine();
        System.out.println("What is the organism of origin? ");
        String organism = in.nextLine();
        Dna dna = new Dna(name, sequence, organism);
        folder.addDna(dna);
        System.out.println("Protein Translation: " + dna.getProteinSequence());
    }

    public static void menuDisplay(DnaFolder folder) {
        System.out.println("Main Menu");
        System.out.println("These are the current DNAs in your folder: ");
        showDnaFolder(folder);
        System.out.println("Choose one of the following options (1, 2, 3, or 4):");
        System.out.println("(1) Add MoClo flanks to a sequence");
        System.out.println("(2) Add a DNA Sequence");
        System.out.println("(3) Modify a DNA Sequence");
        System.out.println("(4) Close");
    }

    public static boolean menuDecision(String answer, DnaFolder folder, Scanner in) {
        switch (answer) {
            case "1":
                addMoClo(folder, in);
                break;
            case "2":
                addSequence(folder, in);
                break;
            case "3":
                modifyDnaDetails(folder, in);
                break;
            case "4":
                return true;
            default:
                System.out.println("Invalid input!");
        }
        return false;
    }

    public static void mainMenu(DnaFolder folder, Scanner in) {
        boolean over = false;
        do {
            menuDisplay(folder);
            String answer = in.nextLine();
            over = menuDecision(answer, folder, in);
            if (!again(in)) {
                over = true;
            }
        } while (!over);
    }

    public static boolean again(Scanner in) {
        System.out.println("Do you want to continue on the Software?");
        String answer = in.nextLine();
        return answer.equalsIgnoreCase("yes");
    }

    public static void showDnaFolder(DnaFolder folder) {
        System.out.println(folder.getDnaNames());
    }


    public static void addMoClo(DnaFolder folder, Scanner in) {
        System.out.println("What is the name of the DNA sequence do you want to add MoClo flanks? ");
        String name = in.nextLine();
        Dna dna = folder.findDnaByName(name);
        System.out.println(dna.toString());
        if (folder.addMoClo(name)) {
            System.out.println("Successful!");
            System.out.println("New Sequence");
            System.out.println(dna.toString());
        } else {
            System.out.println("Failure. An Invalid Input was detected!");
        }
    }

    public static void modifyDnaDetails(DnaFolder folder, Scanner in) {
        System.out.println("What is the name of the DNA sequence do you want to modify? ");
        String name = in.nextLine();
        System.out.println("What do you want to modify (Sequence, Name, or Organism)? ");
        System.out.println("(1) sequence, (2) name, and (3) organism");
        String modified = in.nextLine();
        System.out.println("What is the new content? ");
        String newContent = in.nextLine();
        if (folder.modifyDnaDetails(name, modified, newContent)) {
            System.out.println("Successful!");
        } else {
            System.out.println("Failure. An Invalid Input was detected!");
        }
    }
}
