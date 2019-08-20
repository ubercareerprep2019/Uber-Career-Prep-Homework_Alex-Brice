import java.util.*; 
import java.lang.*; 

public class GraphWithAdjacencyList {
    private Map<GraphNode, List<GraphNode>> adjNodes;
    
    //constructors
    
    //when you know the graphnode itself and adjacent list
    public GraphWithAdjacencyList(GraphNode start, List<GraphNode> adj_list){
        
        adjNodes = new HashMap<GraphNode, List<GraphNode>>(); 
        
        adjNodes.put(start, adj_list); 
    }
    
    
    public GraphWithAdjacencyList(int start_key){
        
        GraphNode start = new GraphNode(start_key); 
        List<GraphNode> list = new ArrayList<GraphNode> (); 
        
        adjNodes = new HashMap<GraphNode, List<GraphNode>>(); 
        adjNodes.put(start, list); 
    }
    
    public void addNode (int key){
        
        GraphNode newNode = new GraphNode(key); 
        List<GraphNode> adjacent = new ArrayList<GraphNode>(); //empty list
        
        adjNodes.put(newNode, adjacent); 
    }
    
    public void removeNode(int key){
        adjNodes.remove(key); 
    }
    
    public void addEdge(int node1, int node2){
        
        //First find which graphnodes are associated 
        //with values node1 and node2
        
        GraphNode graph_node1 = new GraphNode(node1); 
        GraphNode graph_node2 = new GraphNode(node2); 
        
        
        Set<GraphNode> set = adjNodes.keySet(); 
        
        Iterator<GraphNode> it = set.iterator(); 
        
        while(it.hasNext()){
            
            GraphNode b = it.next(); 
            
            if(graph_node1.data == b.data){
                graph_node1 = b; 
            }
            else if(graph_node2.data == b.data){
                graph_node2 = b; 
            }
        }
        
        List<GraphNode> node1_list = adjNodes.get(graph_node1); 
        node1_list.add(graph_node2); 
        
        List<GraphNode> node2_list = adjNodes.get(graph_node2); 
        node2_list.add(graph_node1);  
    }
    
    public void removeEdge(int node1, int node2){
        
        //First find which graphnodes are associated 
        //with values node1 and node2
        
        GraphNode graph_node1 = new GraphNode(node1); 
        GraphNode graph_node2 = new GraphNode(node2); 
        
        
        Set<GraphNode> set = adjNodes.keySet(); 
        
        Iterator<GraphNode> it = set.iterator(); 
        
        while(it.hasNext()){
            
            GraphNode b = it.next(); 
            
            if(graph_node1.data == b.data){
                graph_node1 = b; 
            }
            else if(graph_node2.data == b.data){
                graph_node2 = b; 
            }
        }
        
        
        List<GraphNode> node1_list = adjNodes.get(graph_node1); 
        node1_list.remove(graph_node2); 
        
        List<GraphNode> node2_list = adjNodes.get(graph_node2); 
        node2_list.remove(graph_node1);
    }
    
    public List<GraphNode> getAdjNodes(int key){
        
        //first find the GraphNode with the specified "key"
        
        
         GraphNode tmp = new GraphNode(key); 
        
        Set<GraphNode> set = adjNodes.keySet(); 
        
        Iterator<GraphNode> it = set.iterator(); 
        
        while(it.hasNext()){
            
            GraphNode b = it.next(); 
            
            if(tmp.data == b.data){
                tmp = b; 
            }
        }
        
        
        
        List<GraphNode> tmp_list = adjNodes.get(tmp); 
            
        return tmp_list;   
    }
    
    public void DFS(int k){
        
        
        GraphNode key = new GraphNode(k); 
        
        Set<GraphNode> set = adjNodes.keySet(); 
        
        Iterator<GraphNode> it = set.iterator(); 
        
        while(it.hasNext()){
            
            GraphNode b = it.next(); 
            
            if(key.data == b.data){
                key = b; 
            }
        }
        
        //key was updated.
        
        LinkedList <GraphNode> stack = new LinkedList<>(); 
        LinkedList <GraphNode> visited = new LinkedList<>(); 
        
        stack.addLast(key);
        System.out.print(key.data + " "); 
        visited.addLast(key); 
        
        //key's adjacent nodes
        
        List<GraphNode> adj_list = adjNodes.get(key); 
        
        //first node
        //so neighbors haven't been visited
        
        GraphNode current = adj_list.get(0); 
        
        //traverse from any adj graphnodes
        
        while(stack.size() > 0){
            
            stack.addLast(current); 
            System.out.print(current.data + " "); 
            visited.addLast(current); 
            
            //current's adjacent nodes
            //pick one neighbor
            
            adj_list = adjNodes.get(current);
            
            boolean found_unvisited = false; 
            
            for(int i = 0; i < adj_list.size(); i++){
                if(!visited.contains(adj_list.get(i))){
                    current = adj_list.get(i); 
                    found_unvisited = true; 
                    break; 
                }
            }
            
            //have to pop up the stack 
            //to find a GraphNode that has 
            //unvisited nodes. 
            
            while(found_unvisited == false && stack.size() > 0){
                
                stack.removeLast();
                
                if(stack.size() > 0){
                    current = stack.getLast(); 
                }

                
                adj_list = adjNodes.get(current); 
            
                for(int i = 0; i < adj_list.size(); i++){
                    if(!visited.contains(adj_list.get(i))){
                        current = adj_list.get(i); 
                        found_unvisited = true; 
                        break; 
                    }
                }
                
            }
           
        }   
    }
    
    public void BFS(int k){
        //find graphnode
        
        GraphNode key = new GraphNode(k); 
        
        Set<GraphNode> set = adjNodes.keySet(); 
        
        Iterator<GraphNode> it = set.iterator(); 
        
        while(it.hasNext()){
            
            GraphNode b = it.next(); 
            
            if(key.data == b.data){
                key = b; 
            }
        }
        
        
        LinkedList<GraphNode> queue = new LinkedList<> (); 
        
        LinkedList<GraphNode> visited = new LinkedList<> (); 
        
        queue.addLast(key); 
        
        //print the key
        
        System.out.print(key.data + " "); 
        visited.add(key); 
        
        //Add all neighbors of key in queue
        
        List<GraphNode> key_list = adjNodes.get(key); 
        
        //add them at the end of queue
        //And mark them as visited
        
        for(int i = 0; i < key_list.size(); i++){
            
            queue.add(key_list.get(i)); 
            visited.add(key_list.get(i)); 
        }
        
        //Remove key from queue
        
        queue.removeFirst(); 
        
        
        //Same until queue is empty
        
        while(queue.size() > 0){
            
                
                GraphNode current_graphNode = queue.get(0); 
                
                //add adjacent nodes in the queue
                //Only add those that were not visited before
                
                List<GraphNode> adj_nodes = adjNodes.get(current_graphNode); 
                
                for(int j = 0; j < adj_nodes.size(); j++){
                    
                    if(!visited.contains(adj_nodes.get(j))){
                        queue.add(adj_nodes.get(j));
                        
                        //Then mark them as visited
                        
                        visited.add(adj_nodes.get(j)); 
                    }
                }
                
                //process current_graphNode
                
                System.out.print(current_graphNode.data + " ");
                
                queue.removeFirst(); 
                
            
        }    
    }
    
   public int minNumberOfEdges(int n1, int n2){
        //will use Breadth First traversal
        //Instead of printing the data, we increment distance
        //use hashmap that pairs graphnode with specific distance
        
        
        HashMap<GraphNode, Integer> map = new HashMap<>(); 
       
        GraphNode node1 = new GraphNode(n1); 
        
        Set<GraphNode> set = adjNodes.keySet(); 
        
        Iterator<GraphNode> it = set.iterator(); 
        
        while(it.hasNext()){
            
            GraphNode b = it.next(); 
            
            if(node1.data == b.data){
                node1 = b; 
            }
        }
        
        
        LinkedList<GraphNode> queue = new LinkedList<> (); 
        
        LinkedList<GraphNode> visited = new LinkedList<> (); 
        
        queue.addLast(node1); 
        
        //print the key
        
        map.put(node1, 0); //distance 0 
        visited.add(node1); 
        
        //Add all neighbors of key in queue
        
        List<GraphNode> key_list = adjNodes.get(node1); 
        
        //add them at the end of queue
        //And mark them as visited
        
        for(int i = 0; i < key_list.size(); i++){
            
            queue.add(key_list.get(i)); 
            map.put(key_list.get(i), 1); 
            visited.add(key_list.get(i)); 
        }
        
        //Remove key from queue
        
        queue.removeFirst(); 
        
        
        //Same until queue is empty
        
       int count = 1; //to keep count of the distance per each iteration
        while(queue.size() > 0){
            
                
                GraphNode current_graphNode = queue.get(0); 
                
                //add adjacent nodes in the queue
                //Only add those that were not visited before
                
                List<GraphNode> adj_nodes = adjNodes.get(current_graphNode); 
                
                for(int j = 0; j < adj_nodes.size(); j++){
                    
                    if(!visited.contains(adj_nodes.get(j))){
                        queue.add(adj_nodes.get(j));
                        
                        //Then mark them as visited
                        map.put(adj_nodes.get(j), count++); 
                        visited.add(adj_nodes.get(j)); 
                    }
                }
                
                //process current_graphNode
                
                queue.removeFirst(); 
        }
       
       //Lets numb of edges to the second node. 
       
        GraphNode node2 = new GraphNode(n2); 
        
        Set<GraphNode> set2 = adjNodes.keySet(); 
        
        Iterator<GraphNode> it2 = set2.iterator(); 
        
        while(it2.hasNext()){
            
            GraphNode b = it2.next(); 
            
            if(node2.data == b.data){
                node2 = b; 
            }
        }
       
       int numEdges = map.get(node2); 
       
       return numEdges; 
       
    }
    
    public static class GraphNode{
      public int data;
        
      public GraphNode(int data) {
        this.data = data;
      }
    }
    
    public static void main(String[] args){
        
        GraphWithAdjacencyList graph = new GraphWithAdjacencyList(3); 
        
        graph.addNode(4); 
        graph.addEdge(3, 4); 
        
        graph.addNode(5); 
        graph.addNode(0); 
        graph.addEdge(4, 0); 
        graph.addEdge(4, 5); 
        
        graph.addNode(6); 
        graph.addNode(2); 
        graph.addNode(1); 
        
        graph.addEdge(4, 6);
        graph.addEdge(0, 2); 
        graph.addEdge(2, 5);
        graph.addEdge(2, 1);
        graph.addEdge(0, 1);
        
        //System.out.println(graph.getAdjNodes(2)); 
        
        graph.BFS(3); 
        //graph.DFS(3); 
        
        System.out.println(); 
        
        System.out.println(graph.minNumberOfEdges(3, 2)); 
        
        
    }
    
}
