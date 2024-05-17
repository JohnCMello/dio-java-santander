package digitalbank.exceptions;

public class IdenticalAccountNumberException extends Exception {
	private static final long serialVersionUID = 4L;

	public IdenticalAccountNumberException(String msg) {
		super(msg);
	}
}
