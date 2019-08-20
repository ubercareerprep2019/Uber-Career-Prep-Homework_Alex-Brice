public class BinarySearchTree {
  private Node root;
    
  
  public BinarySearchTree(Node root){
      this.root = root; 
  }

  /**
   * Inserts a key into this binary search tree.
   * If there are n nodes in the tree, then the average runtime of this method should be log(n).
   * 
   * @param key The key to insert.
   */
  public Node insert(int key) {
    // Please implement this method.
    
    Node r = this.root; 
    
    //calling private helper method
    return insert(key, r); 
  }
    
  private Node insert(int key, Node tmp){
      
       
      
      if(tmp == null){
          //if the root is null, create new node
          //base case
          
          return new Node(key, null, null); 
          
      }
      
       if(key < tmp.key){
           tmp.left = insert(key, tmp.left); 
       }
       else if(key > tmp.key){
           tmp.right = insert(key, tmp.right); 
       }
      
      return tmp; 
      
  }

  /**
   * Checks whether or not a key exists in this binary search tree.
   * If there are n nodes in the tree, then the average runtime of this method should be log(n).
   * 
   * @param key The key to check for.
   * @return true if the key is present in this binary search tree, false otherwise.
   */
  public boolean find(int key) {
    // Please implement this method.
    
    //use of private recursive helper method
    
    Node r = this.root; 
      
    return find(key, r); //private helper method

  }
    
  private boolean find(int key, Node tmp){
      if(tmp == null){
          return false; 
      }
      
      if(key < tmp.key){
          return find(key, tmp.left); 
      }
      else if(key > tmp.key){
          return find(key, tmp.right); 
      }
      
      return true; //finally found the node. 
  }
    
    public void traverse(){
        traverse(root); 
    }
    private void traverse(Node t){
        //in-order traversal
        
        if(t != null){
            traverse(t.left); 
            System.out.print(t.key + " "); 
            traverse(t.right);
        }    
    }

  public static class Node {
    public int key;
    public Node left;
    public Node right;
      
    public Node(int k, Node l, Node r){
        key = k; 
        left = l; 
        right = r; 
    }
  }
    
    public static void main(String[] args){
        
        //create a root node
        //then create a binary search tree
        
        
        Node root = new Node(5, null, null); 
        
        BinarySearchTree bst = new BinarySearchTree(root); 
        
        bst.insert(4); 
        bst.insert(3); 
        bst.insert(78); 
        bst.insert(-34); 
        bst.insert(12); 
        bst.insert(1); 
        
        bst.traverse(); 
        
        assert bst.find(4); 
        assert bst.find(-34); 
        assert (!bst.find(678)); 
    }
}
