 

public class MyStack {
    
        
        //instance variable
        
        private Node head; 
    
        private static class Node {
        
            /**Each node has a Integer element and 
             * another "next" node
             * and a min int element that records the min value
             * of all the nodes beneath the node
             **/
            int element; 
            Node next; 
            int min; 
        
            //constructor
        
            Node(int elt, Node nxt){
                element = elt; 
                nxt = next; 
               
                min = Integer.MAX_VALUE; 
            }
        }
    
        public MyStack(){
            
            //initialized with a null "head" node
            head = null;  
        }
    
        public int push(int t){
            
            int pushed_elt; 
            Node node = new Node (t, null); 
            
            if(head == null){
                //empty stack
                head = node; 
                node.element = t;
                node.min = t; //first node in the stack.
                node.next = null; 
                
                pushed_elt = head.element; 
                
                
                return pushed_elt; 
            }
            
            //we always add at the front
            
            Node tmp = head; 
            
            head = node; 
            node.element = t;
            node.next = tmp;
            node.min = tmp.min; 
          
          if(t < node.min){
               //new min found
               node.min = t; 
           }
            
            pushed_elt = head.element; 
            
            return pushed_elt; 
        }
            
            
    
        public int pop(){
            //we always pop from the front
            
            if(!isEmpty()){
                int popped_elt = head.element; 
               
                head = head.next; 
            
                return popped_elt;
            }
            
            
            return 0; 
             
        }
    
    
        //min() routine
        //returns min or 0 if stack empty
        
        public int min(){
            if(head == null){ //empty
                return 0; 
            }
            
            return head.min; 
        }
        
        
        //returns top of the stack
            
         public int top(){
              return head.element; 
         }
            
         public boolean isEmpty(){
              return head == null ? true : false;     
         }
    
         public int size(){
              Node tmp = head; 
              int count = 0; 
                
              while(tmp != null){
                  tmp = tmp.next; 
                  count++; 
              }
                
              return count; 
          }   
        }