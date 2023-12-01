package ui;


import java.io.FileNotFoundException;

//Creates a new instance of the DNA Library App
public class Main {
    public static void main(String[] args) {

        new GUI();

        try {
            new DnaLibraryConsoleApp();
        } catch (FileNotFoundException e) {
            System.out.println("Error. File not found!");
        }

    }
}
