import java.lang.*; 
 

public class BSTPhoneBook implements PhoneBook{
    
    public static class phoneNode{
        public String name; 
        public long number; 
        public phoneNode left; 
        public phoneNode right; 
        
        public phoneNode(String n, long num, phoneNode l, phoneNode r){
            name = n; 
            number = num; 
            left = l; 
            right = r; 
        }
    }
    
    //instance variable
    
    public phoneNode root; 
    
    public BSTPhoneBook(phoneNode root){
        this.root = root; 
    }
    
    public BSTPhoneBook(String nom, long numero){
        
        root = new phoneNode(nom, numero, null, null); 
    }
    
    public int size(){
        //traverse the whole BST tree
        
        int count = 0; 
        
        phoneNode t = root; 
        
        count = size(t); //private helper method
        
        return count; 
    }
    
    private int size(phoneNode tmp){
        if(tmp == null){
            return 0; 
        }
        
        int size_left = size(tmp.left); 
        int size_right = size(tmp.right); 
        
        int size = size_left + size_right + 1; 
        
        return size; 
    }
    
    public void insert(String name, long phoneNumber){
        //use of private helper method
        
        phoneNode r = root; 
        
        insert(name, phoneNumber, r); 
    }
    
    private phoneNode insert(String name, long phoneNumber, phoneNode tmp){
        
        if(tmp == null){
            return new phoneNode(name, phoneNumber, null, null); 
            
        }
        
        if(name.compareTo(tmp.name) < 0){
            tmp.left = insert(name, phoneNumber, tmp.left); 
        }
        else if(name.compareTo(tmp.name) > 0){
            tmp.right = insert(name, phoneNumber, tmp.right); 
        }
        
        return tmp; 
        
    }
    
    public long find(String name){
        //use of private helper method
        
        phoneNode t = root; 
        
        return find(name, t); 
    }
    
    private long find(String name, phoneNode tmp){
        
        long num; 
        
        if(tmp == null){
            return -1; 
        }
        
        if(name.compareTo(tmp.name) < 0){
            return find(name, tmp.left); 
        }
        else if(name.compareTo(tmp.name) > 0){
            return find(name, tmp.right); 
        }
        
        //else
        
        num = tmp.number; 
        
        return num; 
    }
    public void traverse(){
        phoneNode t = root; 
        
        if(size() == 0){
            System.out.println("Apparently, the tree is empty"); 
        }
        else{
            traverse(t); 
        }
    }
    
    private void traverse(phoneNode t){
        //in-order traversal
        
        if(t != null){
            traverse(t.left); 
            System.out.println(t.name + ", " + t.number); 
            traverse(t.right);
        }    
    }
    
    public static void main(String[] args){
        
        BSTPhoneBook b = new BSTPhoneBook("Brice", 917242); 
        
        b.insert("AER", 90); 
        b.insert("bb", 78); 
        b.insert("cris", -98); 
        
        b.traverse(); 
        assert b.size()>0; 
        assert b.find("Brice") == 917242; 
    }
    
}