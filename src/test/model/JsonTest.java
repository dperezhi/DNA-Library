package model;

/*
 Citation
 Title: JsonSerializationDemo
 Author: Paul Carter
 Date: 24 Oct, 2023
 Code version: Java 11
 Availability: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
 */

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkDnaDetails(String name, String sequence, String organism, Dna dna) {
        assertEquals(name, dna.getName());
        assertEquals(sequence, dna.getNucleotideSequence());
        assertEquals(organism, dna.getOrganism());
    }
}
