package model;

import exceptions.InvalidCharForNucSeqException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NucleotideSequenceTest {
    private NucleotideSequence seq1;
    private NucleotideSequence seq2;
    private NucleotideSequence seq3;

    @Test
    void nucSeqWithNoInvalidChar() {
        try {
            seq1 = new NucleotideSequence("actcgtacgtagctagtcgtaggcatgcta");
        } catch (InvalidCharForNucSeqException e) {
            fail("Should not throw exception");
        }
        assertEquals("actcgtacgtagctagtcgtaggcatgcta", seq1.getNucleotideSequence());
    }

    @Test
    void nucSeqWithOneInvalidChar() {
        try {
            seq2 = new NucleotideSequence("actcgtacgtaxgctagtcgtaggcatgcta");
            fail("Should throw InvalidCharForNucSeqException");
        } catch (InvalidCharForNucSeqException e) {
            //Correct Path!
        }
    }

    @Test
    void nucSeqWithMultipleInvalidChar() {
        try {
            seq3 = new NucleotideSequence("actcgtxacgtadgctagftcgtahggycatgcta");
            fail("Should throw InvalidCharForNucSeqException");
        } catch (InvalidCharForNucSeqException e) {
            //Correct Path!
        }
    }
}
