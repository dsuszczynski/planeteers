package pl.suszczynski.planeteers.exception;

/**
 * Created by daniel on 14.05.16.
 */
public class ConsoleCommandReadException extends PlaneteersException {

    public ConsoleCommandReadException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConsoleCommandReadException(String message) {
        super(message);
    }
}
