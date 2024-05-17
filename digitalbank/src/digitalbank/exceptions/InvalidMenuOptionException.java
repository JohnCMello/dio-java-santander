package digitalbank.exceptions;

public class InvalidMenuOptionException  extends Exception{
	private static final long serialVersionUID = 7L;

	public InvalidMenuOptionException(String msg) {
	        super(msg);
	    }
}
