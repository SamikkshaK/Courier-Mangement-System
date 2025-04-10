package exceptions;

public class TrackingNumberNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

    public TrackingNumberNotFoundException(String message) {
        super(message);
    }
}

