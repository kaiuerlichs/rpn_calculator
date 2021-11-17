/**
 * Class representing a Node in a Linked List data structure, i.e. an item in the list
 * 
 * @author Kai Uerlichs
 * @version 1.0
 */
public class ListNode<T>    
{
    // Field to store the data being held in this list node 
    private T data;
    
    /**
     * Object reference to store the next node in the list
     */
    private ListNode<T> next;
  

    /**
     * Object constructor. Set fields to given values.
     *
     * @param pData The data to be stored
     */
    public ListNode(T pData)
    {
        // Set data to value provided
        data = pData;

        // Set next node to null - no valid next node yet
        next = null;
    }
    

    /**
     * Get the next node in the list after this one
     * 
     * @return A reference to the next node 
     *         (or null if there is no next node)
     */
    public ListNode<T> getNext()
    {
       return next;
    }

    /**
     * Set the next node in the list after this one
     * 
     * @param pNext A reference to a ListNode object which 
     *             represents the next node in the list after
     *             this one.
     */
    public void setNext(ListNode<T> pNext)
    {
    	next = pNext;
    }
    
    /**
     * Return the data value stored in this node
     * 
     * @return The data value
     */
    public T getData() {
    	return data;
    }
    
    /**
     * Set the value stored in this node
     * 
     * @param pData The data value to be stored
     */
    public void setData(T pData) {
    	data = pData;
    }

}
