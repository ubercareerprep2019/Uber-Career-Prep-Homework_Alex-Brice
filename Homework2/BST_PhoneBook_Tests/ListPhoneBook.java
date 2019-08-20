import java.util.*; 

public class ListPhoneBook implements PhoneBook{
    //instance variables
    
    public List<HashMap<String, Long>> phone_book; 
    
    //constructor
    
    public ListPhoneBook(){
        phone_book = new ArrayList<HashMap<String, Long>>(); 
    }
    
    public void insert(String name, long phone_number){
        
        HashMap<String, Long> new_entry = new HashMap<>(1); 
        new_entry.put(name, phone_number);
        
        phone_book.add(new_entry); 
        
    }
    
    public int size(){
        return phone_book.size(); 
    }
    
    public long find(String name){
      //have to traverse the list 
      
        long v = -1; 
        
        for(int i = 0; i < phone_book.size(); i++){
            HashMap<String, Long> tmp = phone_book.get(i); 
            
            if(tmp.get(name) != null){
                v = tmp.get(name);
                break; 
            }
        }
        
        return v; 
    }
    
    public static void main(String[] args){
        
        ListPhoneBook list = new ListPhoneBook(); 
        
        list.insert("A", 1); 
        list.insert("B", 4); 
        list.insert("C", 74); 
        list.insert("D", -34); 
        
        assert list.size() > 0; 
        
        assert (list.find("D") == -34); 
      
    }
    
    
    
}