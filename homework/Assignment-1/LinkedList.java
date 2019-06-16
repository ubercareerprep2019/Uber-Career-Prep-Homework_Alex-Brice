public class LinkedList<T>{
    
    //instance variables
    //the head
    
    
    private Node<T> head; 
     
    
    private static class Node<T> {
        
        /**Each node has a <T> element and 
         * another "next" node
         **/
        T element; 
        Node<T> next; 
        
        //constructor
        
        Node(T elt, Node<T> nxt){
            element = elt; 
            nxt = next; 
        }
    }
    
    //LinkedList constructor
    public LinkedList(){
        head = null; 
    }
    
    public void pushBack(T data){
        
        //make a new node
        
        Node <T> node = new Node<> (data, null); 
        
        if(head == null){//empty list
            head = node; 
        }
        else{
            //find the last node
            
            Node <T> end = head; 
            
            while(end.next != null){
                end = end.next; 
            }
            
            end.next = node; 
        }
    }
    
   public T popBack(){
       
       //we assume that we don't pop from an empty list
       
       if(size() <= 1){
           T popped = head.element; 
           head = null; 
           
           return popped; 
       }
       
       int end = size() - 1; 
       
       int count = 0; 
       
       Node <T> tmp = head; 
        
        while(count++ < end - 1){
            if(tmp != null){
                tmp = tmp.next; 
            }
            else{
                System.out.println("Cannot erase element; index out of bounds"); 
            }
        }
        
        T popped = tmp.element; 
       
        if(tmp.next != null){
            tmp.next = tmp.next.next; 
        }
       
       return popped; 
        
    } 
    
    public void insert(int index, T data){
        
        //traverse the list until location at index
        //then insert at index
        
        int count = 0; 
        
        Node<T> tmp = head; 
        Node<T> node = new Node<> (data, null); 
        
        while(count++ < index){
            if(tmp != null){
                tmp = tmp.next; 
            }
            else{
                System.out.println("Cannot insert element; index undefined"); 
            }
        }
        
        node.next = tmp.next; 
        tmp.next = node; 
      
    }
    
    public void erase(int index){
        //traverse the list until location at index
        //then erase at index
        
        if(index > size() - 1){
            return; 
        }
        int count = 0; 
        Node <T> tmp = head; 
        
        while(count++ < index - 1){
            if(tmp != null){
                tmp = tmp.next; 
            }
            else{
                System.out.println("Cannot erase element; index out of bounds"); 
            }
        }
        
        if(tmp.next != null){
            tmp.next = tmp.next.next; 
        }
        
    }
    
    //helper function for debugging
    
    public void traverseList(){
        
        Node<T> tmp = head; 
        
        System.out.print("[ "); 
        while(tmp != null){
            
            System.out.print(tmp.element+" "); 
            tmp = tmp.next; 
        }
        System.out.println("]"); 
    }
    
    public T elementAt(int index){
        
        if(index > size() - 1){
            
            System.out.println("No elements at the specified index"); 
            return null; 
        }
        int count = 0; 
        
        Node<T> tmp_3 = head; 
        
        while(count++ < index){
            if(tmp_3.next != null){
                tmp_3 = tmp_3.next; 
            }
        }
        
        return tmp_3.element; 
    } 
    
    public int size(){
        
        //have to traverse the list and return the number of elements 
        //i.e the number of elements traversed 
        
        int ct_3 = 0; 
        Node<T> tmp_4 = head; 
        
        while(tmp_4 != null){
            ct_3++; 
            tmp_4 = tmp_4.next; 
        }
        return ct_3; 
    }
    
    public void make_circular(){
        
        Node<T> node = head; 
        while(node.next != null){
            node = node.next; 
        }
        node.next = head; 
    }
    
    public boolean hasCycle(){
        
        //To implement this method, use two while loops
        //At each node, we check that its "next" node is 
        //not an earlier one. We loop from head to do that. 
        
        Node<T> nxt_node = head;
        
        boolean isCycle = false; 
        
        while(nxt_node != null){
            Node<T> test = head; 
            
            while(test != null){
                if(nxt_node.next.equals(test)){
                    return true; 
                }
                else{
                    //make sure not to test what is beyond nxt_node
                    if(!test.next.equals(nxt_node)){
                        test = test.next; 
                    }
                    else{
                        break; }
                    
                }
            }
            
            nxt_node = nxt_node.next; 
        }
        
        return isCycle; 
    }
    
    public Node<T> reverse(){
        //the method returns the head of the new reversed list
        
        Node<T> prev = null; 
        Node<T> curr = head; 
        Node<T> nxt = null; 
        
        while(curr != null){
            nxt = curr.next; 
            curr.next = prev; 
            prev = curr; 
            curr = nxt;
        }
        
        head = prev; 
        
        return head; 
         
    }
    
    public boolean isPalindrome(){
        //check that the list is palindrome
        
        //we reverse the list
        //then compare
        
        Node<T> new_head = reverse(); 
        Node<T> orig_head = head; 
        
        while((new_head != null) && (orig_head != null)){
            if(!new_head.equals(orig_head)){
                return false; 
            }
            
            new_head = new_head.next; 
            orig_head = orig_head.next; 
        }
        
        return true; 
    }
    
    
}