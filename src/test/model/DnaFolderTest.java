package model;

import exceptions.InvalidCharForNucSeqException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DnaFolderTest {

    private DnaFolder folder;
    private Dna dna1;
    private Dna dna2;
    private Dna dna3;
    private Dna dna4;

    @BeforeEach
    void setUp() {
        folder = new DnaFolder();
        try {
            dna1 = new Dna("test1", "ATGATGATGATG", "B.Subtilis");
            dna2 = new Dna("test2", "TTT", "B.Subtilis");
            dna3 = new Dna("test3", "ATTAGTAT", "E.coli");
            dna4 = new Dna("test4", "GCGAGAGTAA", "E.coli");
        } catch (InvalidCharForNucSeqException e) {
            fail("No exception should be thrown");
        }
    }

    @Test
    void testAddSingleDnaEmptyFolder() {
        boolean key = folder.addDna(dna1);
        assertTrue(key);
        assertEquals(dna1, folder.getDnaFolder().get(0));
    }

    @Test
    void testAddMultipleDna() {
        boolean key = folder.addDna(dna1);
        assertTrue(key);
        assertEquals(dna1, folder.getDnaFolder().get(0));
        boolean key2 = folder.addDna(dna2);
        assertTrue(key2);
        assertEquals(dna2, folder.getDnaFolder().get(1));
        boolean key3 = folder.addDna(dna3);
        assertTrue(key3);
        assertEquals(dna3, folder.getDnaFolder().get(2));
    }

    @Test
    void testAddingSameDnaTwice() {
        boolean key = folder.addDna(dna1);
        assertTrue(key);
        assertEquals(dna1, folder.getDnaFolder().get(0));
        boolean key2 = folder.addDna(dna1);
        assertFalse(key2);
        boolean key3 = folder.addDna(dna3);
        assertTrue(key3);
        assertEquals(dna3, folder.getDnaFolder().get(1));
    }

    @Test
    void testGetDnaNamesEmpty() {
        assertEquals("", folder.getDnaNames());
    }

    @Test
    void testGetDnaNamesOneSeq() {
        folder.addDna(dna1);
        assertEquals("test1", folder.getDnaNames());
    }

    @Test
    void testGetDnaNamesMultipleSeq() {
        folder.addDna(dna1);
        assertEquals("test1", folder.getDnaNames());
        folder.addDna(dna2);
        assertEquals("test1, test2", folder.getDnaNames());
        folder.addDna(dna3);
        assertEquals("test1, test2, test3", folder.getDnaNames());
        folder.addDna(dna4);
        assertEquals("test1, test2, test3, test4", folder.getDnaNames());
    }

    @Test
    void testFindDnaEmpty() {
        assertNull(folder.findDnaByName(dna1.getName()));
    }

    @Test
    void testFindDnaFull() {
        folder.addDna(dna1);
        folder.addDna(dna2);
        folder.addDna(dna3);
        assertEquals(dna1, folder.findDnaByName(dna1.getName()));
        assertEquals(dna3, folder.findDnaByName(dna3.getName()));
    }

    @Test
    void testModifyDnaNotFound() {
        try {
            assertFalse(folder.modifyDnaDetails(dna1.getName(), "1", "test0"));
            assertFalse(folder.modifyDnaDetails(dna2.getName(), "2", "test0"));
            assertFalse(folder.modifyDnaDetails(dna3.getName(), "3", "test0"));
            assertFalse(folder.modifyDnaDetails(dna4.getName(), "ded", "test0"));
        } catch (InvalidCharForNucSeqException e) {
            fail("InvalidCharForNucSeqException should have NOT been thrown");
        }
    }

    @Test
    void testModifyDnaSeq() {
        folder.addDna(dna2);
        try {
            assertTrue(folder.modifyDnaDetails(dna2.getName(), "1", "ATG"));
        } catch (InvalidCharForNucSeqException e) {
            fail("InvalidCharForNucSeqException should have NOT been thrown");
        }
        assertEquals("ATG", dna2.getNucelotideSequence());
    }

    @Test
    void testModifyDnaName() {
        folder.addDna(dna1);
        try {
            assertTrue(folder.modifyDnaDetails(dna1.getName(), "2", "test0"));
        } catch (InvalidCharForNucSeqException e) {
            fail("InvalidCharForNucSeqException should have NOT been thrown");
        }
        assertEquals("test0", dna1.getName());
    }

    @Test
    void testModifyDnaInvalid() {
        folder.addDna(dna1);
        try {
            assertFalse(folder.modifyDnaDetails(dna1.getName(), "5", "test0"));
        } catch (InvalidCharForNucSeqException e) {
            fail("InvalidCharForNucSeqException should have NOT been thrown");
        }
        assertEquals("test1", dna1.getName());
    }

    @Test
    void testModifyDnaOrganism() {
        folder.addDna(dna3);
        try {
            assertTrue(folder.modifyDnaDetails(dna3.getName(), "3", "Human"));
        } catch (InvalidCharForNucSeqException e) {
            fail("InvalidCharForNucSeqException should have NOT been thrown");
        }
        assertEquals("Human", dna3.getOrganism());
    }

    @Test
    void testAddMoCloEmpty() {
        assertFalse(folder.addMoClo(dna1.getName()));
        assertFalse(folder.addMoClo(dna3.getName()));
        assertFalse(folder.addMoClo(dna2.getName()));
        assertFalse(folder.addMoClo(dna4.getName()));
    }

    @Test
    void testAddMoClo() {
        folder.addDna(dna1);
        assertTrue(folder.addMoClo(dna1.getName()));
        assertEquals("ctcaATGATGATGATGcgcg", dna1.getNucelotideSequence());
    }
}