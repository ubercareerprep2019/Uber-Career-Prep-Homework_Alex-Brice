public class Disk implements Comparable<Disk> {
    
    private int diameter; 
    
    public Disk(int n){
        diameter = n; 
    }
    
    public int getSize(){
        return diameter; 
    }
    
    public int compareTo(Disk other){
        if(this.diameter == other.diameter){
            return 0; 
        }
        
        return this.diameter < other.diameter? -1 : 1; 
    }
    
    // @override
    
    public void toString(Disk[] disk){
        System.out.println("The rod is made of:{"); 
        
        for(int j = 0; j < disk.length; j++){
            System.out.print(" " + disk[j].diameter); 
        }
        
        System.out.println(" }"); 
    }
}