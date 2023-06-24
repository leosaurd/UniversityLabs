package week11;

/**
 * A class that generates a custom unchecked exception. Unchecked exception is
 * extended from RuntimeException.
 * 
 * @author Kane Colvin, Tane Carney & Samuel Ng
 *
 */
public class CardPileException extends RuntimeException {
    /**
     * SerialVersionUID to ensure consistency between compiler implementation.
     */
    private static final long serialVersionUID = -7221728326699242264L;

    /**
     * A constructor to prompt the user with an exception and message.
     * 
     * @param msg The message to be displayed to the user.
     */
    public CardPileException(String msg) {
        super(msg);
    }

    /**
     * A constructor to display the reason for the exception. Only needed for
     * bug testing. This was utilized to view root cause for errors, i.e.
     * java.util.NoSuchElementException.
     * 
     * @param reason The exception that caused the program to stop.
     */
    public CardPileException(Throwable reason) {
        super(reason);
    }

    /**
     * A constructor to display both the reason for the exception and a message
     * to the user. Combination of the two constructors to provide more
     * information, including previous developer input.
     * 
     * @param reason The exception that caused the program to stop.
     * @param msg    The message to be displayed to the user.
     */
    public CardPileException(Throwable reason, String msg) {
        super(msg, reason);
    }
}
