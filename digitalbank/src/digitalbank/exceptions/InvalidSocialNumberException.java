package digitalbank.exceptions;

public class InvalidSocialNumberException extends Exception{
	private static final long serialVersionUID = 2L;

	public InvalidSocialNumberException(String msg) {
        super(msg);
    }
}
