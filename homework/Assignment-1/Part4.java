import java.lang.String; 

public class Part4{
    
    public static void main(String[] args){
        
        LinkedList<Integer> list = new LinkedList<> (); 
        //test Push_Back_Adds_One_Node
        
        assert list.size() == 0; 
        
        /**For debugging
         
        for(int i = 0; i < 10; i++){
            list.pushBack(i); 
        }
        
        assert list.size() == 10; 
        
        assert list.elementAt(8) == 8;
        
        list.traverseList(); 
        
        list.insert(1, 1);  
        list.traverseList(); 
        
        list.insert(10, 11); 
        list.traverseList(); 
        
        list.erase(1); 
        list.traverseList(); 
        
        list.erase(10); 
        list.traverseList(); 
        
        list.popBack(); 
        list.traverseList(); 
        assert list.size() == 9; 
        
        for(int j = 0; j < 9; j++){
            list.popBack(); 
        }
        list.traverseList(); 
        
       **/ 
        
        
        for(int i = 0; i < 10; i++){
            list.pushBack(i); 
        }
        list.traverseList(); 
        
        assert list.size() == 10; 
        
        //test PopBack_Removes_CorrectNode
        
        list.popBack();
        list.traverseList(); 
        
        assert list.size() == 9; 
        
        for(int j = 0; j < 3; j++){
            list.popBack(); 
        }
        list.traverseList(); 
        
        assert list.size() == 6; 
       
        
        //test Erase_Removes_Correct_Node
        
        list.insert(1, 1); 
        assert list.elementAt(1) == 1; 
        list.traverseList(); 
        
        list.erase(1);
        list.traverseList(); 
        
        assert list.size() == 6; 
        
        //test Erase_Does_Nothing_if_no_Node
        
        list.erase(23); 
        
        //test ElementAt_Return_Node
        
        assert list.elementAt(4) == 4; 
        
       
        //test ElementAT_Returns_No Node_if Index_Does Not Exist
        
        assert list.elementAt(89) == null; 
        
        
        //test size
        
        assert list.size() == 6; 
        
        while(list.size() > 0){
            list.popBack(); 
        }
        
        list.traverseList(); 
        assert list.size() == 0; 
        
        //test isPalindrome method
        
        LinkedList<String> word = new LinkedList<> ();
        
        word.pushBack("m");
        word.pushBack("a"); 
        word.pushBack("d"); 
        word.pushBack("a"); 
        word.pushBack("m"); 
        
        assert word.isPalindrome(); 
        
        // test hasCycle
        
        LinkedList<Integer> circular = new LinkedList<> (); 
        
        circular.pushBack(5); 
        circular.pushBack(6); 
        circular.pushBack(7); 
        
        circular.make_circular(); 
        assert circular.hasCycle(); 
        
    }
}