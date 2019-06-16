public class Queue{
    
    //instance variable
    
    MyStack queue; 
    
    public Queue(){
        queue = new MyStack (); 
    }
    
    public void enqueue(int elt){
        queue.push(elt); 
    }
    
    public int dequeue(){
        //create a temporary MyStack
        
        MyStack tmp = new MyStack ();
        int deq; 
        
        while(!queue.isEmpty()){
            int r = queue.pop(); 
            tmp.push(r); 
        }
        
        deq = tmp.pop(); //dequeue-ing the bottom element, which was the "first"
        
        while (!tmp.isEmpty()){
            int s = tmp.pop(); 
            queue.push(s); 
        }
        
        return deq;   
        
    }
}