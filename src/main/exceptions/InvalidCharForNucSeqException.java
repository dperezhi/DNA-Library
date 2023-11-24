package exceptions;


// Represents an Exception where an invalid character was detected in a nucleotide sequence
public class InvalidCharForNucSeqException extends Exception {

    //EFFECTS constructs the exception with a string message
    public InvalidCharForNucSeqException(String msg) {
        super(msg);
    }
}
