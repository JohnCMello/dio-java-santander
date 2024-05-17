package digitalbank.exceptions;

public class AccountNotFoundException extends Exception {
	private static final long serialVersionUID = 5L;

	public AccountNotFoundException(String msg) {
		super(msg);
	}
}
