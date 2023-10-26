package ui;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        try {
            DnaLibraryApp dnaLibraryApp = new DnaLibraryApp();
        } catch (FileNotFoundException e) {
            System.out.println("Error. File not found!");
        }
    }
}
