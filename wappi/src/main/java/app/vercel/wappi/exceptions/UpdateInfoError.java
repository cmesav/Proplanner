package app.vercel.wappi.exceptions;

public class UpdateInfoError extends AssertionError{

    public UpdateInfoError(String message, Throwable cause) {
        super(message, cause);
    }
}
