package digitalbank.exceptions;

public class IdenticalAccountTypeException extends Exception {
	private static final long serialVersionUID = 3L;

	public IdenticalAccountTypeException(String msg) {
        super(msg);
    }
}
