public class Tree{
    
     public static class TreeNode {
        public int data;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int data, TreeNode left, TreeNode right) {
          this.data = data;
          this.left = left;
          this.right = right;
        }
      }
    
     public TreeNode root;

     public Tree(TreeNode root) {
        this.root = root;
      }
    
     public void print(){
         print_tree(root); 
     }
    
    private void print_tree(TreeNode t){
        //in-order traversal
        
        if(t != null){
            print_tree(t.left); 
            System.out.print(t.data + " "); 
            print_tree(t.right);
        }    
    }
    
    

     public static void main(String[] args) {
        TreeNode leftChild = new TreeNode(6, null, null);
        TreeNode rightChild = new TreeNode(3, null, null);
        TreeNode left = new TreeNode(7, null, null);
        TreeNode right = new TreeNode(17, leftChild, rightChild);
        TreeNode root = new TreeNode(1, left, right);
        Tree tree = new Tree(root);
         
         tree.print(); 
      }

     

}