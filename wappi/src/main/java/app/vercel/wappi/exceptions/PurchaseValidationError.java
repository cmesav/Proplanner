package app.vercel.wappi.exceptions;

public class PurchaseValidationError extends AssertionError{

    public PurchaseValidationError(String message, Throwable cause) {
        super(message, cause);
    }
}
