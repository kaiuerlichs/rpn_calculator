/**
 * Automatic test code for the RPN Calculator project
 * 
 * @author Kai Uerlichs
 * @version 1.0
 */
public class Test {

	// Declare required List and Stack object references
	List<Double> list1;
	Stack<Double> stack1;
	
	/**
	 * Default constructor for Test objects, initialises required fields
	 */
	public Test() {
		initialiseTests();
	}
	
	 /**
	  * Runs all the automated tests
	  */
	public void run() {
		System.out.println("||| All generic data structures in this Test instance are initialised with type Double |||\n\n");
		
		processListTest();
		processStackTest();
		processRPNTest();
	}

	/**
	 * Initialises the fields for the automated tests
	 */
	public void initialiseTests() {
		list1 = new List<Double>();
		stack1 = new Stack<Double>();
	}
	
	/**
	 * Runs a series of automated List tests 
	 */
	public void processListTest() {
		System.out.println("===== COMMENCING AUTOMATIC LIST TEST =====");
		System.out.println("\n\n");
		
		// Test 1: Testing empty list
		
		System.out.println("Test 1: Printing an empty list\n");
		list1.print();
		System.out.println("\n\n");
		
		// Test 2: Adding nodes to the start of the list
		
		System.out.println("Test 2: Populate the list and print\n");
		list1.addToStart(1.0);
		list1.addToStart(2.0);
		list1.addToStart(3.0);
		list1.print();
		System.out.println("\n\n");
		
		// Test 3: Removing nodes from the start of the list
		
		System.out.println("Test 3: Delete from the start of the list and print\n");
		list1.removeFromStart();
		list1.print();
		System.out.println("\n\n");
		
		// Test 4: Removing all remaining nodes from the list
		
		System.out.println("Test 4: Clear list and print\n");
		list1.removeFromStart();
		list1.removeFromStart();
		list1.print();
		System.out.println("\n\n");
		
		// Test 5: Attempt to remove from empty list
		
		System.out.println("Test 5: Attempt delete on empty list and print\n");
		list1.removeFromStart();
		list1.print();
		System.out.println("\n\n");
	}

	/**
	 * Runs a series of automated Stack tests 
	 */
	public void processStackTest() {
		System.out.println("===== COMMENCING AUTOMATIC STACK TEST =====");
		System.out.println("\n\n");
		
		// Test 1: Stack initialisation
		
		System.out.println("Test 1: Initialise an empty stack and check with isEmpty()\n");
		System.out.println("Return value: " + stack1.isEmpty());
		System.out.println("\n\n");
		
		// Test 2: Pushing nodes onto Stack
		
		System.out.println("Test 2: Push data nodes onto the stack and print\n");
		stack1.push(1.0);
		stack1.push(2.0);
		stack1.push(3.0);
		stack1.print();
		System.out.println("\n\n");
		
		// Test 3: Popping nodes from Stack
		
		System.out.println("Test 3: Pop top node (x3)\n");
		try {
			System.out.println("Return data: " + stack1.pop().getData());
			System.out.println("Return data: " + stack1.pop().getData());
			System.out.println("Return data: " + stack1.pop().getData());
		} catch (EmptyStackException e) {
			System.out.println("Caught EmptyStackException.");
		}
		System.out.println("\n\n");
		
		// Test 4: Attempt to pop from empty Stack
		
		System.out.println("Test 4: Pop on empty stack\n");
		try {
			stack1.pop();
		} catch (EmptyStackException e) {
			System.out.println("Caught EmptyStackException.");
		}
		System.out.println("\n\n");
		
	}

	/**
	 * Runs a series of automated RPN tests
	 */
	public void processRPNTest() {
		System.out.println("===== COMMENCING AUTOMATIC RPN TEST =====");
		System.out.println("\n\n");
		
		// Test section 1 debugs correct inputs into the RPNCalculator.calculate() method
		
		System.out.println("Test 1.1: Evaluate correct expression \"3,6,+\" with delimiter \",\"\n");
		rpnTestModule("3,6,+",",");
		System.out.println("\n\n");
		
		System.out.println("Test 1.2: Evaluate correct expression \"4 3 + 7 * 12 26 2 - / -\" with delimiter \" \"\n");
		rpnTestModule("4 3 + 7 * 12 26 2 - / -"," ");
		System.out.println("\n\n");
		
		System.out.println("Test 1.3: Evaluate correct expression \"78 30 0.5 28 8 + * - 6 / +\" with delimiter \" \"\n");
		rpnTestModule("78 30 0.5 28 8 + * - 6 / +"," ");
		System.out.println("\n\n");
		
		// Test section 2 debugs wrong inputs into the RPNCalculator.calculate() method
		
		System.out.println("Test 2.1: Evaluate wrong expression \"20+50+-\" with delimiter \"+\"\n");
		rpnTestModule("20+50+-","+");
		System.out.println("\n\n");
		
		System.out.println("Test 2.2: Evaluate wrong expression \"4 +\" with delimiter \" \"\n");
		rpnTestModule("4 +"," ");
		System.out.println("\n\n");
		
		System.out.println("Test 2.3: Evaluate wrong expression \"4 4 + +\" with delimiter \" \"\n");
		rpnTestModule("4 4 + +"," ");
		System.out.println("\n\n");
		
		System.out.println("Test 2.4: Evaluate wrong expression \"4 4 , +\" with delimiter \" \"\n");
		rpnTestModule("4 4 , +"," ");
		System.out.println("\n\n");
		
		System.out.println("Test 2.5: Evaluate wrong expression \"1 0 /\" with delimiter \" \"\n");
		rpnTestModule("1 0 /"," ");
		System.out.println("\n\n");
		
		// Test section 3 debugs correct inputs into the RPNCalculator.rpnToInfix() method
		
		System.out.println("Test 3.1: Convert correct expression \"3,6,+\" with delimiter \",\" to infix\n");
		rpnConverterTestModule("3,6,+",",");
		System.out.println("\n\n");
		
		System.out.println("Test 3.2: Convert correct expression \"4 3 + 7 * 12 26 2 - / -\" with delimiter \" \" to infix\n");
		rpnConverterTestModule("4 3 + 7 * 12 26 2 - / -"," ");
		System.out.println("\n\n");
		
		System.out.println("Test 3.3: Convert correct expression \"78 30 0.5 28 8 + * - 6 / +\" with delimiter \" \" to infix\n");
		rpnConverterTestModule("78 30 0.5 28 8 + * - 6 / +"," ");
		System.out.println("\n\n");
		
		// Test section 2 debugs wrong inputs into the RPNCalculator.rpnToInfix() method
		
		System.out.println("Test 4.1: Convert wrong expression \"20+50+-\" with delimiter \"+\" to infix\n");
		rpnConverterTestModule("20+50+-","+");
		System.out.println("\n\n");
		
		System.out.println("Test 4.2: Convert wrong expression \"4 +\" with delimiter \" \" to infix\n");
		rpnConverterTestModule("4 +"," ");
		System.out.println("\n\n");
		
		System.out.println("Test 4.3: Convert wrong expression \"4 4 + +\" with delimiter \" \" to infix\n");
		rpnConverterTestModule("4 4 + +"," ");
		System.out.println("\n\n");
		
		System.out.println("Test 4.4: Evaluate wrong expression \"4 4 , +\" with delimiter \" \" to infix\n");
		rpnConverterTestModule("4 4 , +"," ");
		System.out.println("\n\n");
	}
	
	 /**
	  * Uses the RPN calculator class to debug various calculations with the expression
	  * and delimiter in the parameters
	  * 
	  * @param expression The expression to evaluation
	  * @param delimiter The delimiter of the expression
	  */
	private void rpnTestModule(String expression, String delimiter) {
		// Attempt to calculate with the given parameters
		try {
			System.out.println("Return value: "+RPNCalculator.calculate(expression, delimiter));
		} 
		// If an exception is caught, display the exception class name
		catch (Exception e) {
			System.out.println("Threw exception: " + e.getClass());
			if(e.getMessage() != null) {
				System.out.println("With response: " + e.getMessage());
			}
		}
	}
	
	/**
	  * Uses the RPN calculator class to debug various conversions to infix 
	  * with the expression and delimiter in the parameters
	  * 
	  * @param expression The expression to evaluation
	  * @param delimiter The delimiter of the expression
	  */
	private void rpnConverterTestModule(String expression, String delimiter) {
		// Attempt to calculate with the given parameters
		try {
			System.out.println("Return value: "+RPNCalculator.rpnToInfix(expression, delimiter));
		} 
		// If an exception is caught, display the exception class name
		catch (Exception e) {
			System.out.println("Threw exception: " + e.getClass());
			if(e.getMessage() != null) {
				System.out.println("With response: " + e.getMessage());
			}
		}
	}
}
