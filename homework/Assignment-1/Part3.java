import java.util.Stack; 


public class Part3{
    
    public static void main(String[] args){
        
        MyStack<Integer> example = new MyStack<> (); 
        
        example.push(1); 
        example.push(2); 
        example.push(3);
        example.push(4);
        example.push(5);
        
        assert (example.top() == 5); 
        
        example.pop();
        
        assert (example.top() == 4); 
        example.pop(); 
        
        assert (example.top() == 3); 
        
        example.pop(); 
        example.pop(); 
        example.pop(); 
        
        assert (example.isEmpty()); 
        
        int i = 100; 
        while (i > 0){
            example.push(i--); 
        }
        
       //assert (example.min() == 1); 
        
        Queue q = new Queue(); 
        
        int j = 0; 
        
        while (j < 10){
            q.enqueue(j++); 
        }
        
        assert (q.dequeue() == 0); 
        
        System.out.println("The elements in the queue are: "); 
        System.out.print("[ "); 
        while(!q.queue.isEmpty()){
            
            Integer alt = q.dequeue(); 
            System.out.print(alt + " "); 
        }
        System.out.print("]"); 
        System.out.println(""); 
        
        System.out.println("Enqueue-ing 10,11,..,30"); 
        
        int a = 10; 
        
        while (a <= 30){
            q.enqueue(a++); 
        }
         
        System.out.println("Now the elements are: "); 
        System.out.print("[ "); 
        while(!q.queue.isEmpty()){
            
            Integer alt = q.dequeue(); 
            System.out.print(alt + " "); 
        }
        System.out.print("]"); 
        System.out.println(""); 
        
       
        
        
        assert q.queue.isEmpty(); 
    }
    
}