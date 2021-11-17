/**
 * Class representing a Linked List data structure 
 * 
 * @author Kai Uerlichs
 * @version 1.0
 */
public class List<T> 
{
	/**
	 * Used to hold a reference to an instance of a ListNode object
	 * which will be the first item in the list, i.e. at the 'head' of the list
	 */
    private ListNode<T> head;

    /**
     * Default constructor. Initialise fields to default values.
     */
    public List() {
        // Set the list to be empty, i.e. not referring to anything valid yet
        head = null;
    }

    /**
     * Get the list node which is at the 'head' of the list
     * 
     * @return A reference to a ListNode object which represents the node at the
     *         head of the list (or null if the list is empty, i.e. no 'head' has
     *         been set yet).    
     */
    public ListNode<T> getHead() {
        return head;
    }

    /**
     * Set the 'head' of the list to the given node
     * 
     * @param  newHead A reference to a ListNode object which will be
     *                 the head of the list.
     */
    public void setHead(ListNode<T> newHead) {
        head = newHead;
    }

    /**
     * Add a new node to the start of the list which will contain the data provided.
     * 
     * @param pData The data for a new ListNode 
     */
    public void addToStart(T pData) {
        ListNode<T> node = new ListNode<T>(pData);
        node.setNext(head);
        head = node;
    }
    
    /**
     * Add a provided node to the start of the list.
     * 
     * @param node The node to be placed at the start of the list
     */
    public void addToStart(ListNode<T> node) {
        node.setNext(head);
        head = node;
    }

    /**
     * Removes the first node in the list.
     */
    public void removeFromStart() {
    	if(head != null) {
    		head = head.getNext();
    	}
    }
    
    /**
     * Method to print out the entire list, starting with the first node and ending with the last
     */
    public void print() {
    	if(head != null) {
    		print(head);
    	}
    	else {
    		System.out.println("List is empty.");
    	}
    }
    
    /**
     * Private recursive method printing all nodes in a list until the node has no next node
     * 
     * @param node The node to print
     */
    private void print(ListNode<T> node) {
    	System.out.println(node.getData());
    	if(node.getNext() != null) {
    		print(node.getNext());
    	}
    }
    
//    	THIS PART OF THE CODE HAS NOT BEEN GENERALISED
    
//    /**
//     * Find list node with data parameter and print data
//     * 
//     * @param pData The data to search for
//     */
//    public void find(double pData) {
//    	System.out.println("Searching list for data: "+pData);
//    	if(head != null) {
//    		find(pData, head);
//    	}
//    	else {
//    		System.out.println("List is empty.");
//    	}
//    }
//    
//    /**
//     * Recursive method for finding a list node by data
//     * 
//     * @param pData The data to find
//     * @param node The node to check
//     */
//    private void find(double pData, ListNode node) {
//    	if(node.getData() == pData) {
//    		System.out.println("Node found:");
//    		System.out.println(node.getData());
//    	}
//    	else {
//    		if(node.getNext() != null) {
//    			find(pData, node.getNext());
//    		}
//    		else {
//    			System.out.println("Node not found.");
//    		}
//    	}
//    }
//
//    /**
//     * Find list node with data parameter and delete it
//     *  
//     * @param pData The data to search for
//     */
//    public void delete(double pData) {
//    	System.out.println("Deleting from list for data: "+pData);
//    	if(head != null) {
//    		if(head.getData() == pData) {
//    			head = head.getNext();
//    			System.out.println("Node deleted.");
//    		}
//    		else {
//    			delete(pData, head);
//    		}
//    	}
//    	else {
//    		System.out.println("List is empty.");
//    	}
//    }
//    
//    /**
//     * Recursive method for finding a list node by data and deleting it
//     * 
//     * @param pData The data to find
//     * @param node The node to check
//     */
//    public void delete(double pData, ListNode node) {
//    	ListNode nextNode = node.getNext();
//    	if(nextNode != null) {
//    		if(nextNode.getData() == pData) {
//        		node.setNext(nextNode.getNext());
//        		System.out.println("Node deleted.");
//        	}
//        	else {
//        		delete(pData, nextNode);
//        	}
//    	}
//    	else {
//    		System.out.println("Node not found.");
//    	}
//    }
    
}
