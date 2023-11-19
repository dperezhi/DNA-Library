package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProteinSequenceTest {

    private ProteinSequence proteinSequence1;
    private ProteinSequence proteinSequence2;
    private ProteinSequence proteinSequence3;
    private ProteinSequence proteinSequence4;
    private ProteinSequence proteinSequence5;


    @BeforeEach
    void setUp() {
        proteinSequence1 = new ProteinSequence("ATGATGATGATG");
        proteinSequence2 = new ProteinSequence("TTT");
        proteinSequence3 = new ProteinSequence("ATTAGTAT");
        proteinSequence4 = new ProteinSequence("GCGAGAGTAA");
        proteinSequence5 = new ProteinSequence("ATGATGXDSATG");
    }

    @Test
    void testConstructor() {
        assertEquals("ATGATGATGATG", proteinSequence1.getNucleotideSequence());
        assertEquals("ATTAGTAT", proteinSequence3.getNucleotideSequence());
    }

    @Test
    void testProteinSequence() {
        assertEquals("MMMM", proteinSequence1.getProteinSequence());
        assertEquals("F", proteinSequence2.getProteinSequence());
        assertEquals("IS", proteinSequence3.getProteinSequence());
        assertEquals("ARV", proteinSequence4.getProteinSequence());
    }

    @Test
    void testProteinSeqCodonNotFound() {
        assertEquals("MMXM", proteinSequence5.getProteinSequence());
    }

}