package exception;

public class MyException extends Exception {
	
	private static final long serialVersionUID = 7603938480233514384L;
    private final String message;

    public MyException(Exception e) {
        this((Throwable) e);
    }

    /**
     * @param message
     */
    public MyException(String message) {
        super(message);
        this.message = message;
    }

    /**
     * @param message
     * @param cause
     */
    public MyException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
    }

    /**
     * Wrap another Throwable.
     * If cause is null, message is set to null.
     * Otherwise, message is set to cause.toString()
     * 
     * @param cause
     *            Throwable to wrap
     */
    public MyException(Throwable cause) {
        super(cause);
        if (cause == null) {
            this.message = null;
        } else {
            this.message = cause.toString();
        }
    }

    /**
     * Overriding to not return the classname of this exception as part of the message
     * 
     * @see java.lang.Throwable#getMessage()
     */
    public String getMessage() {
        return message;
    }

    public String toString() {
        return getMessage();
    }

    public String getLocalizedMessage() {
        return getMessage();
    }

}
