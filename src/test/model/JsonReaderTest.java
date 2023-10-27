package model;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.ArrayList;
import persistence.JsonReader;

import static org.junit.jupiter.api.Assertions.*;

/*
 Citation
 Title: JsonSerializationDemo
 Author: Paul Carter
 Date: 24 Oct, 2023
 Code version: Java 11
 Availability: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
 */

public class JsonReaderTest extends JsonTest {

    @Test
    void testFileNotFoundReader() {
        JsonReader reader = new JsonReader("./data/notFound.json");
        try {
            reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // TEST PASSED!
        }
    }

    @Test
    void testEmptyDnaFolderReader() {
        JsonReader reader = new JsonReader("./data/testEmptyDnaFolderReader.json");
        try {
            DnaFolder dnaFolder = reader.read();
            assertEquals("Empty", dnaFolder.getName());
            assertEquals(0, dnaFolder.getDnaFolder().size());
        } catch (IOException e) {
            fail("File was not found or couldn't read from file");
        }
    }

    @Test
    void testNormalDnaFolderReader() {
        JsonReader reader = new JsonReader("./data/testNormalDnaFolderReader.json");
        try {
            DnaFolder dnaFolder = reader.read();
            assertEquals("Normal Dna Library", dnaFolder.getName());
            ArrayList<Dna> dnaSeqs = dnaFolder.getDnaFolder();
            checkDnaDetails("lib1","atgatgatg","e.coli",dnaSeqs.get(0));
            checkDnaDetails("lib2","catcatcat","b.sub",dnaSeqs.get(1));
            assertEquals(2, dnaSeqs.size());
        } catch (IOException e) {
            fail("File was not found or couldn't read from file");
        }
    }
}
