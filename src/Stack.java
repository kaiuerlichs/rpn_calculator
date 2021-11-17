/**
 * Class representing a Stack data structure 
 * 
 * @author Kai Uerlichs
 * @version 1.0
 */
public class Stack<T> {

	/**
	 * List structure used to store Stack nodes
	 */
	private List<T> stackList;
	
	/**
	 * Constructor for Stack objects initialising the stackList field
	 */
	public Stack() {
		stackList = new List<T>();
	}
	
	/**
	 * Method to check whether the stack is empty or not
	 * 
	 * @return Whether the stack is empty or not
	 */
	public boolean isEmpty() {
		return (stackList.getHead() == null);
	}
	
	/**
	 * Prints the stack to console
	 */
	public void print() {
		stackList.print();
	}

	/**
	 * Push a new node with data on top of the stack
	 * 
	 * @param pData The data for the new node
	 */
	public void push(T pData) {
		stackList.addToStart(pData);
	}
	
	/**
	 * Returns the top node of the stack
	 * 
	 * @return The top node of the stack
	 * @throws EmptyStackException When the Stack is empty
	 */
	public ListNode<T> pop() throws EmptyStackException {
		ListNode<T> tmpNode = stackList.getHead();
		stackList.removeFromStart();
		
		// Return node if it is not empty, else throw exception
		if(tmpNode != null) {
			return tmpNode;
		}
		else {
			throw new EmptyStackException();
		}
	}
	
}