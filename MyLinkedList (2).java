/* Name: MyLinkedList
 * Authors: Chris Eardensohn (ceardensohn@sandiego.edu)
 * and Om Kanwar (okanwar@sandiego.edu)
 * Date:  11/15/17
 * 
 * Description: Custom linked lists class that provides methods
 * for  manipulating list data. Tests for each method provided by
 * the ListTest.java file.
 */


public class MyLinkedList<T> {
    // the Node class is a private inner class used (only) by the LinkedList class
    private class Node {
        private Object data;
        private Node next;
        
        public Node(Object a, Node n) {
            data = a;
            next = n;
        }
    }
    
    private Node first;
    private int length;  // to enable an O(1) size method
    
    
    public MyLinkedList() {
        first = null;
        length = 0;  // added after considering the size() method
    }
    
    public boolean isEmpty() {
        return (first == null);
    }
    
    public void addFirst(Object d) {
        /* These two lines can be reduced to the single line which follows
         *   Node temp = first;
         *   first = new Node(d,temp);
         */        
        first = new Node(d,first);
        length++;
    }
    
    public int size() {
     /*  This O(n) loop can be replaced by the O(1) return once we have the length field
     int count = 0;
     for (Node curr = first; curr != null; curr = curr.next)
     count++;
     return count;
     */
        return length;
    }
    
    public void clear() {
        first = null;
        length = 0;
    }
    
    public boolean contains(Object value) {
        for (Node curr = first; curr != null; curr = curr.next) {
            if (value.equals(curr.data)) {
                // this implies that the data must have an overridden .equals() method!
                return true;
            }
        }
        return false;
    }
    
    public Object get(int index) {
        if (index < 0 || index >= length) {
            System.out.println("Index of " + index + " out of range");
            return null;
        }
        
        Node curr = first;
        for (int i = 0; i < index; i++)
            curr = curr.next;
        return curr.data;
    }
    
    public boolean remove(Object m) {
        if (isEmpty())
            return false;
        
        if (m.equals(first.data)) {
            first = first.next;
            length--;
            return true;
        }
        
        Node curr = first;
        while (curr.next != null) {
            if (m.equals(curr.next.data)) {
                // this implies that the data must have an overridden equals() method!
                
                curr.next = curr.next.next;
                length--;
                return true;
            }
            curr = curr.next;
        }
        return false;
    }
    
    public String toString() {
        StringBuilder result = new StringBuilder();  //String result = "";
 
        for (Node curr = first; curr != null; curr = curr.next)
            result.append(curr.data + "->");  //result = result + curr.data + "->";

        result.append("[null]");
        return result.toString();   //return result + "[null]";
    }
    
    // ------------------------  HW4 methods start here ------------------------
    
    //return value of first node
    public Object getFirst() {
        if (first == null) {
        	System.out.println("The list is empty");
        	return null;
        }
    	return first.data;
    }
    
    //return value of last node
    public Object getLast() {
       if (first == null) {
    	   System.out.println("The list is empty");
    	   return null;      
       }
    	Node curr = first;
    	while (curr.next != null){
    		curr = curr.next;
    	}
    	return curr.data;
    }
    
    //adds a new node of passed value to last node
    public void add(Object value) {
        Node addNode = new Node (value, null);
    	//adds first node if list is empty
        if (isEmpty())
    		addFirst(value);
        else {
        	Node curr = first;
        	//finds last node and adds new node
        	while (curr.next != null)
        		curr = curr.next;
        	curr.next = addNode;
        	length++;
        }
    }
    
    //adds new node after desired index
    public void addAfter(int index, Object value) {
       //error handling
    	if(index < 0 || index >= length)
    	   System.out.println("Index out of range");
       else if (index == 0)
    	   //if empty add first node
    	   addFirst(value);
       else {
    	   Node curr = first;
    	   for(int i = 0; i < index; i++){
    		   curr = curr.next;
    	   }
    	   Node nextNode = curr.next;
    	   Node addNode = new Node(value, nextNode);
    	   curr.next = addNode;
    	   length++;
       }
    }
    
    //changes selected index node to be desired value
    public Object set(int index, Object newValue) {
        if(index < 0 || index >= length){
        	System.out.println("Index out of range");  
        	return null;
        }
        else if (index == 0) {
        	addFirst(newValue);
        	return null;
        }
        else {
        	Node curr = first;
        	for(int i = 0; i < index; i++){
        		curr = curr.next;
        	}
        	//returns old data at that index
        	Object oldData = curr.data;
        	curr.data = newValue;
        	return oldData;
        }
    }
    
    //finds last occurrence of desired value
    public int lastIndex(Object value) {
    	Node curr = first;
    	//saves index of last found value
    	int index = 0;
    	for (int i = 0; i < length; i++){
    		if (value == curr.data)
        		index = i; 
    		curr = curr.next;
        }
    	return index;
    }
    
    //clones a calling list and returns it to a new one
    public MyLinkedList<T> clone() {
        MyLinkedList<T> shallowList = new MyLinkedList<T>();
        Node curr = first;
        for(int i = 0; i < length; i++){
        	shallowList.add(curr.data);
        	curr = curr.next;
        }
    	return shallowList;
    }
    
    //removes all occurrences of a passed value
    public void removeAll(Object value) {
        Node curr = first;
        while (curr.next != null){
        	if (curr.data == value) {
        		remove(curr.data);
        	}
        	curr = curr.next;
        }
        if (curr.data == value)
        	remove(curr.data);
    }
    
    //checks passed list and will check if elements equal calling
    //object
    public boolean equals(Object o) {
    	//cast object to generic list
    	MyLinkedList<T> list = (MyLinkedList<T>)o;
		if (this == o) {
	         return true;
		}
		//compare nodes of each list
		if  (o instanceof MyLinkedList) {
	    	int n = size();
	       	if (n == list.size()) {
	            Node n1 = first;
	            Node n2 = list.first;
	            while (n1 != null) {
	               if (n1.data != n2.data) {
	                  return false;
	               }
	               n1 = n1.next;
	               n2 = n2.next;
	            }
	            return true;
	      }
	   }
		return false;
    }
    
    //splits calling object list into two, the original list will
    //contain the first half and the returned list will contain
    //the latter
    public MyLinkedList<T> split() {
        MyLinkedList<T> splitList = new MyLinkedList<T>();
        int midpoint = size()/2;
       
        Node curr = first;
        //iterate to find midpoint
        for(int i = 0; i < midpoint; i++){
        	curr = curr.next;
        }
        Node mid = curr;
        //add data from midpoint onwards
        for(int i = midpoint; i < length; i++) {
        	splitList.add(mid.data);
        	mid = mid.next;
        }
        //remove data from original list
        for (int i = midpoint; i < length; i++) {
        	remove(curr.data);
        	curr = curr.next;
        }
        if (curr != null)
        	remove(curr.data);
        return splitList;
    }
    
    //creates a copy of a node at each index and stores it
    //adjacent to the copied node
    public void doubler() {
    	int originalSize = size();
    	Node curr = first;
    	Node prev = first;
    	if (curr.next != null){
    		curr = curr.next;
    	}
    	int index = 0;
    	//iterates current to find what node to add next
    	//use addAfter to double node of the node behind
    	for(int i = 0; i < originalSize; i++) {
    		if (curr.next != null) {
        		addAfter(index, prev.data);
        		prev = curr;
        		curr = curr.next;
        		index+=2;
    		}
    	}
    	//add data to left over indexes
    	addAfter(index, prev.data);
        add(curr.data);
    }
    
    //returns a new list at desired indexes
    public MyLinkedList<T> sublist(int i, int j) {
        MyLinkedList<T> sublist = new MyLinkedList<T>();
        int originalSize = this.size();
        Node curr = first;
        Node newNode = curr;
    	//error handling
        if (j <= i || i < 0 || j > originalSize) {
        	System.out.println("Indexes out of bounds,"
        			+ " sublist will return null.");
        	return null;
        }
    	//finds index at i
        else {
    		for(int k = 0; k < i; k++) {
    			curr = curr.next;
    		}
    		newNode = curr;
    		//fill new list with values from i < j-1
    		for (int k = 0; k < j-1; k++) {
    			sublist.add(newNode.data);
    			newNode = newNode.next;
    		}
    		return sublist;
    	}
    }
    
    //finished tests are in ListTest.java
    public static void main(String[] args) {
        // here is where you can create some lists (use lists of Strings
        // to test) and thoroughly test each of your new methods
    }
}
