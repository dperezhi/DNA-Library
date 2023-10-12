package ui;

import model.Dna;
import model.DnaList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        DnaList list = new DnaList();
        System.out.println("A DNA list has been created for you!");
        boolean key = true;
        System.out.println("Add a DNA sequence:");
        addSequence(list);
        do {
            System.out.println("Do you want to add a another DNA sequence?");
            String answer = in.nextLine();
            if (answer.equalsIgnoreCase("yes")) {
                addSequence(list);
            } else {
                key = false;
            }
        } while (key);
        mainMenu(list);
        in.close();
    }

    public static void addSequence(DnaList list) {
        Scanner in = new Scanner(System.in);
        System.out.println("What is the title of the sequence? ");
        String name = in.nextLine();
        System.out.println("What are the nucleotides? ");
        String sequence = in.nextLine();
        System.out.println("What is the organism of origin? ");
        String organism = in.nextLine();
        Dna dna = new Dna(name, sequence, organism);
        list.addDna(dna);
        System.out.println("Protein Translation: " + dna.getProteinSequence());
        in.close();
    }

    public static void menuDisplay(DnaList list) {
        System.out.println("Main Menu");
        System.out.println("These are the current DNAs in your list: ");
        showDnaList(list);
        System.out.println("Choose one of the following options (1, 2, 3, or 4):");
        System.out.println("(1) Add MoClo flanks to a sequence");
        System.out.println("(2) Add a DNA Sequence");
        System.out.println("(3) Modify a DNA Sequence");
        System.out.println("(4) Close");
    }

    public static boolean menuDecision(String answer, DnaList list) {
        switch (answer) {
            case "1":
                addMoClo(list);
                break;
            case "2":
                addSequence(list);
                break;
            case "3":
                modifySequence(list);
                break;
            case "4":
                return true;
            default:
                System.out.println("Invalid input!");
        }
        return false;
    }

    public static void mainMenu(DnaList list) {
        Scanner in = new Scanner(System.in);
        boolean over = false;
        do {
            menuDisplay(list);
            String answer = in.nextLine();
            over = menuDecision(answer, list);
            if (!again()) {
                over = true;
            }
        } while (!over);
        in.close();
    }

    public static boolean again() {
        Scanner in = new Scanner(System.in);
        System.out.println("Do you want to continue on the Software?");
        String answer = in.nextLine();
        return answer.equalsIgnoreCase("yes");
    }

    public static void showDnaList(DnaList list) {
        System.out.println(list.showListNames());
    }


    public static void addMoClo(DnaList list) {
        Scanner in = new Scanner(System.in);
        System.out.println("What is the name of the DNA sequence do you want to add MoClo flanks? ");
        String name = in.nextLine();
        Dna dna = list.findDna(name);
        System.out.println(dna.toString());
        if (list.addMoClo(name)) {
            System.out.println("Successful!");
            System.out.println("New Sequence");
            System.out.println(dna.toString());
        } else {
            System.out.println("Failure. An Invalid Input was detected!");
        }
        in.close();
    }

    public static void modifySequence(DnaList list) {
        Scanner in = new Scanner(System.in);
        System.out.println("What is the name of the DNA sequence do you want to modify? ");
        String name = in.nextLine();
        System.out.println("What do you want to modify (Sequence, Name, or Organism)? ");
        System.out.println("(1) sequence, (2) name, and (3) organism");
        String modified = in.nextLine();
        System.out.println("What is the new content? ");
        String newContent = in.nextLine();
        if (list.modifyDna(name, modified, newContent)) {
            System.out.println("Successful!");
        } else {
            System.out.println("Failure. An Invalid Input was detected!");
        }
        in.close();
    }
}
