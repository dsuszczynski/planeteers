package pl.suszczynski.planeteers.exception;

/**
 * Created by daniel on 14.05.16.
 */
public class ConsoleMessagesException extends PlaneteersException {

    public ConsoleMessagesException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConsoleMessagesException(String message) {
        super(message);
    }
}
