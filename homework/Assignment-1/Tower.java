import java.util.Arrays; 
import java.util.ArrayList; 
import java.util.*; 

public class Tower{
    //THe puzzle Towers of Hanoi uses disks and rods (we have 3 rods)
    
    /**
     * 
     * To start the game, we will create a stack of disks
     * sorted in ascending order
     **/
    
    private Disk[] source_rod; 
    private Disk[] spare_rod; 
    private Disk[] target_rod;
    
    private List<Disk[]> source; 
    private List<Disk[]> spare;
    private List<Disk[]> target;
    
     
  
    
    public Tower(int n){
        //n represents the number of disks n shifted from one rod to another
        //put the disks in the source_rod
         
        source_rod = new Disk[n]; 
        spare_rod = new Disk[n]; 
        target_rod = new Disk[n]; 
        
        for(int i = n - 1; i >= 0; i --){
            
            Disk tmp = new Disk(n); 
            source_rod[i] = tmp; 
            n--; 
        }
        
        source = new ArrayList<Disk[]>(); 
        source.add(source_rod); 
        
        spare = new ArrayList<Disk[]> (); 
        spare.add(spare_rod); 
        
        target = new ArrayList<Disk[]> (); 
        target.add(target_rod); 
    }
    
    
    /** MoveDisk method
     * source_rod has index 1
     * spare_rod has index 2
     * target_rod has index 3
     * Indexes will be useful in the method
     **/
    
    /**
     * It is imperative that the first call to MoveDisk, the destination_rod be
     * the spare rod
     **/
    
    public void moveDisk(int starting, int destination){
        
        //integer equivalent of rods; 
        //1; source_rod
        //2; spare_rod
        //3; target_rod
        
        
          Disk[] src = disksAtRod(starting); 
            
          if(src.length == 0){
                //rod empty
              return; 
          }
          else{
              
              //move Disks from source_rod to spare
              moveDisk(starting, destination - 1); 
                
              Disk D = src[src.length - 1]; 
                
              Update_rod(D, destination); 
               
              //move disks from spare to target
              moveDisk(destination-1, destination); 
                       
          }  
    }
    
  public void Update_rod(Disk d, int rod_index){
      
      if(rod_index == 1){
          
          Disk[] old_rod = source.get(source.size()-1); 
          Disk[] new_rod = new Disk[old_rod.length + 1]; 
      
          new_rod[0] = d; 
      
          for(int i = 0; i < old_rod.length; i++){
              new_rod[i+ 1] = old_rod[i]; 
          }
          
          source.add(new_rod); 
      }
      
      else if(rod_index == 2){
          
          Disk[] old_rod = spare.get(spare.size()-1); 
          Disk[] new_rod = new Disk[old_rod.length + 1]; 
      
          new_rod[0] = d; 
      
          for(int i = 0; i < old_rod.length; i++){
              new_rod[i+ 1] = old_rod[i]; 
          }
          
          target.add(new_rod);
      }
      
      else{
          Disk[] old_rod = target.get(target.size()-1); 
          Disk[] new_rod = new Disk[old_rod.length + 1]; 
      
          new_rod[0] = d; 
      
          for(int i = 0; i < old_rod.length; i++){
              new_rod[i+ 1] = old_rod[i]; 
          }
          
          target.add(new_rod);
      }
      
      
      
  }
    
   public Disk[] disksAtRod(int index){
        
        if(index == 1){
           return source.get(source.size() - 1);  
        }
        
        if(index == 2){
            return spare.get(spare.size() - 1); 
        }
        
        return target.get(spare.size() - 1);  
    }
}