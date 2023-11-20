package model;

import exceptions.InvalidCharForNucSeqException;

// Represents a nucleotide sequence
public class NucleotideSequence {
    private final String nucleotideSequence;

    /*
     * MODIFIES: this
     * EFFECTS: throws exception is sequence contains invalid characters, if not it registers the sequence as the
     *          nucleotideSequence
     */
    public NucleotideSequence(String sequence) throws InvalidCharForNucSeqException {
        if (!isValid(sequence)) {
            throw new InvalidCharForNucSeqException("Invalid Character found");
        }
        nucleotideSequence = sequence;
    }

    //EFFECTS: returns true if the sequence only contains valid characters ignoring upper or lower case ((?i) case
    //          case-insensitive matching) and [atcg] is matched characters, + is for one or more instance of those
    //          characters.
    private boolean isValid(String sequence) {
        return sequence.matches("(?i)[actgn]+");
    }

    /*
     * GETTERS
     */

    //EFFECTS: returns the nucleotideSequence
    public String getNucleotideSequence() {
        return nucleotideSequence;
    }
}
