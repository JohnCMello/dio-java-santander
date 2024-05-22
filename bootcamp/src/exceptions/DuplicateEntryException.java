package exceptions;

public class DuplicateEntryException extends Exception{

	private static final long serialVersionUID = 3L;
	public DuplicateEntryException(String msg) {
		super(msg);
	}
	
}
