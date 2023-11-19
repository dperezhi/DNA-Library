package exceptions;

public class InvalidCharForNucSeqException extends Exception {
    public InvalidCharForNucSeqException() {
    }

    public InvalidCharForNucSeqException(String msg) {
        super(msg);
    }
}
