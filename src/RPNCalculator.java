/**
 * Class to perform RPN calculations
 * 
 * @author Kai Uerlichs
 * @version 1.0
 */
public class RPNCalculator {

	/**
	 * Calculate the RPN expression given and return the result
	 * 
	 * @param input The RPN expression to evaluate
	 * @param delimiter The delimiter between each token of the expression
	 * @return The result of the calculation
	 * @throws IllegalCalculationException When the RPN expression itself is invalid
	 * @throws IllegalCharacterException When an invalid character is found in the expression
	 * @throws IllegalDelimiterException When the delimiter is illegal (i.e. one of the operators or a number)
	 * @throws DivisionByZeroException When the expression contains division by zero
	 */
	public static double calculate(String input, String delimiter) throws IllegalCalculationException, IllegalCharacterException, IllegalDelimiterException, DivisionByZeroException {
		
		// Get token array and initialise numStack
		String[] tokenArray = parseInput(input, delimiter);
		Stack<Double> numStack = new Stack<Double>();
		
		for(int i = 0; i < tokenArray.length; i++) {
			// Check if token is a number, if so push to stack
			try {
				double tmp = Double.parseDouble(tokenArray[i]);
				numStack.push(tmp);
			} 
			// If token is not a number
			catch(NumberFormatException e) {
				double tmp1;
				double tmp2;
				
				// Check if token is an operator, if so, calculate intermediate result
				// by popping top two nodes on the stack, then pushing it back onto the stack
				switch (tokenArray[i]) {
				case "+": {
					try {
						tmp1 = numStack.pop().getData();
						tmp2 = numStack.pop().getData();
					} catch(EmptyStackException f) {
						throw new IllegalCalculationException();
					}
					
					numStack.push(tmp2+tmp1);
					break;
				}
				case "-": {
					try {
						tmp1 = numStack.pop().getData();
						tmp2 = numStack.pop().getData();
					} catch(EmptyStackException f) {
						throw new IllegalCalculationException();
					}
					
					numStack.push(tmp2-tmp1);
					break;
				}
				case "*": {
					try {
						tmp1 = numStack.pop().getData();
						tmp2 = numStack.pop().getData();
					} catch(EmptyStackException f) {
						throw new IllegalCalculationException();
					}
					
					numStack.push(tmp2*tmp1);
					break;
				}
				case "/": {
					try {
						tmp1 = numStack.pop().getData();
						tmp2 = numStack.pop().getData();
					} catch(EmptyStackException f) {
						throw new IllegalCalculationException();
					}
					
					if(tmp1 == 0) {
						throw new DivisionByZeroException();
					}
					else {
						numStack.push(tmp2/tmp1);
						break;
					}
					
				}
				//If token is not an operator, throw exception
				default:
					throw new IllegalCharacterException(tokenArray[i]);
				}
			}
		}
		// Calculation completed, attempt to pop top node (=result)
		try {
			double result = numStack.pop().getData();
			// If the stack is empty, return the result
			if(numStack.isEmpty()) {
				return result;
			}
			// If the stack is not empty, throw exception
			else {
				throw new IllegalCalculationException();
			}
		} 
		// If no top node is left, throw exception
		catch(EmptyStackException e) {
			throw new IllegalCalculationException();
		}
	}
	
	/**
	 * Parse the input expression into a String array of tokens
	 * 
	 * @param input The expression to parse
	 * @param delimiter The delimiter to split the String at
	 * @return The parsed String array
	 * @throws IllegalDelimiterException When an illegal delimiter was found
	 */
	private static String[] parseInput(String input, String delimiter) throws IllegalDelimiterException {
		// Check if delimiter is a number
		try {
			Double.parseDouble(delimiter);
		} 
		catch(NumberFormatException e) {
			// Check if delimiter is an operator
			if(!delimiter.equals("+") && !delimiter.equals("-") && !delimiter.equals("*") && !delimiter.equals("/")) {
				return input.split(delimiter);
			}
			else {
				throw new IllegalDelimiterException(delimiter);
			}
		}
		throw new IllegalDelimiterException(delimiter);
	}
	
	/**
	 * Converts an RPN/postfix expression into infix and returns the result
	 * 
	 * @param expression The RPN expression to convert
	 * @param delimiter The delimiter between each token of the expression
	 * @return The result of the conversion
	 * @throws IllegalCalculationException When the RPN expression itself is invalid
	 * @throws IllegalCharacterException When an invalid character is found in the expression
	 * @throws IllegalDelimiterException When the delimiter is illegal (i.e. one of the operators or a number)
	 */
	public static String rpnToInfix(String expression, String delimiter) throws IllegalDelimiterException, IllegalCalculationException, IllegalCharacterException {
		// Get token array and initialise strStack
		String[] tokenArray = parseInput(expression, delimiter);
		Stack<String> strStack = new Stack<String>();
		
		// For every token
		for(int i = 0; i < tokenArray.length; i++) {
			try {
				// See if token is numerical, if so push String form onto stack
				Double.parseDouble(tokenArray[i]);
				strStack.push(tokenArray[i]);
			} 
			// If it is not a number
			catch (NumberFormatException e) {
				// Declare temporary fields for operands
				String tmp1;
				String tmp2;
				
				// Check if token is an operator, if so, convert into intermediate infix expression
				// and push back onto stack
				switch (tokenArray[i]) {
				case "+": {
					try {
						tmp1 = strStack.pop().getData();
						tmp2 = strStack.pop().getData();
					} catch(EmptyStackException f) {
						throw new IllegalCalculationException();
					}
					
					strStack.push("("+tmp2+"+"+tmp1+")");
					break;
				}
				case "-": {
					try {
						tmp1 = strStack.pop().getData();
						tmp2 = strStack.pop().getData();
					} catch(EmptyStackException f) {
						throw new IllegalCalculationException();
					}
					
					strStack.push("("+tmp2+"-"+tmp1+")");
					break;
				}
				case "*": {
					try {
						tmp1 = strStack.pop().getData();
						tmp2 = strStack.pop().getData();
					} catch(EmptyStackException f) {
						throw new IllegalCalculationException();
					}
					
					strStack.push("("+tmp2+"*"+tmp1+")");
					break;
				}
				case "/": {
					try {
						tmp1 = strStack.pop().getData();
						tmp2 = strStack.pop().getData();
					} catch(EmptyStackException f) {
						throw new IllegalCalculationException();
					}
					
					strStack.push("("+tmp2+"/"+tmp1+")");
					break;
				}
				//If token is not an operator, throw exception
				default:
					throw new IllegalCharacterException(tokenArray[i]);
				}
			}
		}
		
		// Conversion completed, attempt to pop top node (=result)
		try {
			String result = strStack.pop().getData();
			// If the stack is empty, return the result
			if(strStack.isEmpty()) {
				return result;
			}
			// If the stack is not empty, throw exception
			else {
				throw new IllegalCalculationException();
			}
		} 
		// If no top node is left, throw exception
		catch(EmptyStackException e) {
			throw new IllegalCalculationException();
		}
	}

}
