package exceptions;

public class InvalidMenuOptionException extends Exception {
	private static final long serialVersionUID = 1L;

	public InvalidMenuOptionException(String msg) {
		super(msg);
	}
}
