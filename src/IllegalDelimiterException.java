/**
 * Exception thrown when an invalid delimiter is passed into the program 
 * (i.e. one of the mathematical operators "+", "-", "*" and "/")
 * 
 * @author Kai Uerlichs
 * @version 1.0
 */
public class IllegalDelimiterException extends Exception {
	
	// Exception needs to be serialisable
	private static final long serialVersionUID = 6485585079791292033L;
	
	/**
	 * Constructor with message
	 * @param key The message
	 */
	public IllegalDelimiterException(String key) {
		super(key);
	}
	
}
