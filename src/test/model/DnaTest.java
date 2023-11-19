package model;

import exceptions.InvalidCharForNucSeqException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DnaTest {

    private Dna dna1;
    private Dna dna2;
    private Dna dna3;
    private Dna dna4;
    private Dna dna5;

    @BeforeEach
    void setUp() {
        try {
            dna1 = new Dna("test1", "ATGATGATGATG", "B.Subtilis");
            dna2 = new Dna("test2", "TTT", "B.Subtilis");
            dna3 = new Dna("test3", "ATTAGTAT", "E.coli");
            dna4 = new Dna("test4", "GCGAGAGTAA", "E.coli");
            dna5 = new Dna("test5", "ATGATGXDSATG", "E.coli");
        } catch (InvalidCharForNucSeqException e) {
            fail("No exception should be thrown");
        }
    }

    @Test
    void testConstructor() {
        assertEquals("test1", dna1.getName());
        assertEquals("ATGATGATGATG", dna1.getNucelotideSequence());
        assertEquals("B.Subtilis", dna1.getOrganism());
        assertEquals("MMMM", dna1.getProteinSequence());


        assertEquals("test3", dna3.getName());
        assertEquals("ATTAGTAT", dna3.getNucelotideSequence());
        assertEquals("E.coli", dna3.getOrganism());
        assertEquals("IS", dna3.getProteinSequence());

        assertEquals("MMXM", dna5.getProteinSequence());

    }

    @Test
    void testToString() {
        String expected = "Sequence='ATGATGATGATG', name='test1', organism='B.Subtilis', proteinSequence='MMMM'";
        assertEquals(expected, dna1.toString());
    }

}
