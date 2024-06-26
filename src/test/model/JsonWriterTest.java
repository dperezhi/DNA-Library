package model;

import exceptions.InvalidCharForNucSeqException;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import persistence.JsonReader;
import persistence.JsonWriter;

import static org.junit.jupiter.api.Assertions.*;

/*
 Citation
 Title: JsonSerializationDemo
 Author: Paul Carter
 Date: 24 Oct, 2023
 Code version: Java 11
 Availability: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
 */

public class JsonWriterTest extends JsonTest {

    @Test
    void testWriterInvalidFile() {
        try {
            new DnaFolder("Invalid Folder");
            JsonWriter writer = new JsonWriter("./data/*dwq%vdv\0d?@vd  @vd@.json");
            writer.open();
            fail("Exception should be thrown!");
        } catch (FileNotFoundException e) {
            // Test has passed!
        }
    }

    @Test
    void testWriterEmptyWorkroom() {
        try {
            DnaFolder dnaFolder = new DnaFolder("Dna Library Empty Writer");
            JsonWriter writer = new JsonWriter("./data/testEmptyDnaFolderWriter.json");
            writer.open();
            writer.write(dnaFolder);
            writer.close();

            JsonReader reader = new JsonReader("./data/testEmptyDnaFolderWriter.json");
            dnaFolder = reader.read();
            assertEquals("Dna Library Empty Writer", dnaFolder.getName());
            assertEquals(0, dnaFolder.getDnaFolder().size());
        } catch (IOException e) {
            fail("Exceptions should not be thrown!");
        } catch (InvalidCharForNucSeqException e) {
            fail("Exceptions should not be thrown!");
        }
    }

    @Test
    void testWriterGeneralWorkroom() {
        try {
            DnaFolder dnaFolder = new DnaFolder("Dna Library Writer");
            try {
                dnaFolder.addDna(new Dna("dna1","atg","human"));
                dnaFolder.addDna(new Dna("dna2","cat","e.coli"));
                dnaFolder.addDna(new Dna("dna3","tag","b.sub"));
            } catch (InvalidCharForNucSeqException e) {
                fail("No exception should be thrown");
            }
            JsonWriter writer = new JsonWriter("./data/testNormalDnaFolderWriter.json");
            writer.open();
            writer.write(dnaFolder);
            writer.close();

            JsonReader reader = new JsonReader("./data/testNormalDnaFolderWriter.json");
            dnaFolder = reader.read();
            assertEquals("Dna Library Writer", dnaFolder.getName());
            ArrayList<Dna> dnaSeqs = dnaFolder.getDnaFolder();
            checkDnaDetails("dna1","atg","human",dnaSeqs.get(0));
            checkDnaDetails("dna2","cat","e.coli",dnaSeqs.get(1));
            checkDnaDetails("dna3","tag","b.sub",dnaSeqs.get(2));
            assertEquals(3, dnaSeqs.size());
        } catch (IOException e) {
            fail("Exceptions should not be thrown!");
        } catch (InvalidCharForNucSeqException e) {
            fail("Exceptions should not be thrown!");
        }
    }
}
