package digitalbank.exceptions;

public class NoAccountsCreatedException extends Exception{
	private static final long serialVersionUID = 6L;

	public NoAccountsCreatedException(String msg) {
        super(msg);
    }
}

