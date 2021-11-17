/**
 * Exception thrown when an invalid character is found in a RPN calculation string
 * 
 * @author Kai Uerlichs
 * @version 1.0
 */
public class IllegalCharacterException extends Exception{
	
	// Exception needs to be serialisable
	private static final long serialVersionUID = 8611347364406538231L;

	/**
	 * Constructor with message
	 * @param c The message
	 */
	public IllegalCharacterException(String c) {
		super(c);
	}
}
