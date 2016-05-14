package pl.suszczynski.planeteers.exception;

/**
 * Created by daniel on 14.05.16.
 */
public class PlaneteersException extends Exception {

    public PlaneteersException() {
        super();
    }

    public PlaneteersException(String message, Throwable cause) {
        super(message, cause);
    }

    public PlaneteersException(String message) {
        super(message);
    }

    public PlaneteersException(Throwable cause) {
        super(cause);
    }
}
