public class Queue{
    
    //instance variable
    
    MyStack<Integer> queue; 
    
    public Queue(){
        queue = new MyStack<> (); 
    }
    
    public void enqueue(Integer elt){
        queue.push(elt); 
    }
    
    public Integer dequeue(){
        //create a temporary MyStack
        
        MyStack<Integer> tmp = new MyStack<> ();
        Integer deq; 
        
        while(!queue.isEmpty()){
            Integer r = queue.pop(); 
            tmp.push(r); 
        }
        
        deq = tmp.pop(); //dequeue-ing the bottom element, which was the "first"
        
        while (!tmp.isEmpty()){
            Integer s = tmp.pop(); 
            queue.push(s); 
        }
        
        return deq;   
        
    }
}