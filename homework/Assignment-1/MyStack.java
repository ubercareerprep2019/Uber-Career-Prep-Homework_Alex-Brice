import java.util.Stack; 

public class MyStack{
            
            private Stack<Integer> the_stack; //instance variable
            private Stack<Integer> min_stack; 
            
            public MyStack(){
                //constructor
                the_stack = new Stack<Integer>();  
                min_stack = new Stack<Integer>(); 
            }
            
            public Integer push(Integer t){
                
                Integer elt_push = the_stack.push(t); 
                push_min(elt_push); 
                
                return elt_push; 
            }
            
            public void push_min(Integer elt){
                
                //this function ensures that min_stack contains ordered elements of the_stack
                //use temporary stack
                
                if(min_stack.empty()){
                    min_stack.push(elt); 
                }
                else{
                    Stack<Integer> tmp = new Stack<>();
                    while((!min_stack.empty()) && min_stack.peek() < elt){
                        Integer t = min_stack.pop(); 
                        tmp.push(t); 
                    }
                    
                    min_stack.push(elt);
                    
                    while(!tmp.empty()){
                        Integer s = tmp.pop(); 
                        min_stack.push(s); 
                    }
                }
            }
            
            public Integer pop(){
                
                Integer num = the_stack.pop(); 
                update_min(num); 
                return num; 
            }
            
            public void update_min(Integer elt){
                
                //min_stack must contain at least one element
                
                Stack<Integer> tmp = new Stack<> (); 
                while ((!min_stack.empty()) && elt != min_stack.peek()){
                    Integer r = min_stack.pop(); 
                    tmp.push(r); 
                }
                
                min_stack.pop(); 
                
                while(!tmp.empty()){
                    Integer p = tmp.pop(); 
                    min_stack.push(p); 
                }
            }
            
            public Integer top(){
                return the_stack.peek(); 
            }
            
            public boolean isEmpty(){
                return the_stack.empty()? true : false; 
            }
            
            public Integer min(){
                return min_stack.peek(); 
            }
        }