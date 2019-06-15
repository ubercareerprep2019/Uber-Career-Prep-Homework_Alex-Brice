import java.util.Arrays; 

public class Part5{
    
    public static void main(String[] args){
        Tower Hanoi = new Tower(3); 
        
        Disk[] result_rod = Hanoi.disksAtRod(1); 
        
        result_rod.toString(); 
    
        //System.out.println(Arrays.toString(Hanoi.target_rod)); 
    }
}