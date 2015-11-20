package pi.lab3.chat.exception;

/**
 * Yuliia Vovk
 * 20.11.15
 */
public class ValidationException extends RuntimeException {

    public ValidationException() {
        super();
    }

    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
