 

public class MyStack<Integer> {
    
        
        //instance variable
        
        private Node<Integer> head; 
    
        private static class Node<Integer> {
        
            /**Each node has a Integer element and 
             * another "next" node
             * and a min int element that records the min value
             * of all the nodes beneath the node
             **/
            Integer element; 
            Node<Integer> next; 
            Integer min; 
        
            //constructor
        
            Node(Integer elt, Node<Integer> nxt){
                element = elt; 
                nxt = next; 
               
                min = null; 
            }
        }
    
        public MyStack(){
            
            //initialized with a null "head" node
            head = null;  
        }
    
        public Integer push(Integer t){
            
            Integer pushed_elt; 
            Node<Integer> node = new Node<> (t, null); 
            
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
            
            Node <Integer> tmp = head; 
            
            head = node; 
            node.element = t;
            node.next = tmp;
            node.min = tmp.min; 
          
          /** if(t < node.min){
               //new min found
               node.min = t; 
           }**/
            
            pushed_elt = head.element; 
            
            return pushed_elt; 
        }
            
            
    
        public Integer pop(){
            //we always pop from the front
            
            if(!isEmpty()){
                Integer popped_elt = head.element; 
               
                head = head.next; 
            
                return popped_elt;
            }
            
            
            return null; 
             
        }
    
    
        /**I wrote the min() routine after writing the whole class in generics.
         * I initially thought "Integer" meant "java.lang.Integer"
         * Will Keep working on this
         * I was running out of time for the deadline
         * Therefore, this won't be tested in the test cases
         **/
    
        /**
        public T min(){
            if(head == null){ //empty
                return null; 
            }
            
            return head.min; 
        } **/
            
            
            public Integer top(){
                return head.element; 
            }
            
            public boolean isEmpty(){
            return head == null ? true : false;  
                
            }
    
            public int size(){
                Node<Integer> tmp = head; 
                int count = 0; 
                
                while(tmp != null){
                    tmp = tmp.next; 
                    count++; 
                }
                
                return count; 
            }
            
           
        }