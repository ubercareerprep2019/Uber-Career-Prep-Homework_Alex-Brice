public class Exercise5{
    
    public static int nbOfIslands(boolean[][] isLandMap){
        
        int count = 0; 
        
        if(isLandMap.length <= 0){
            return count; 
        }
        
        for(int i = 0; i < isLandMap.length; i++){
            for(int j = 0; j < isLandMap[0].length; j++){
                
                if(isLandMap[i][j] == true){
                    //unvisited island
                    
                    
                    //check neighbors horizontally
                    //and vertically
                    //to see if its a bigger island;
                    check(isLandMap, i, j); 
                    count++; 
                }
            }
        }
        
        return count; 
    }
    
    public static void check(boolean[][] map, int r, int c){
        //row r
        //column c
        
        if(!(r > 0 && c > 0 && r < map.length && c < map[0].length && map[r][c] == true)){
            return; 
        }
        
        map[r][c] = false; 
        
        //check neighbors
        check(map, r-1, c); 
        check(map, r+1, c);
        check(map, r, c-1); 
        check(map, r, c+1); 
         
    }
    
    public static void main(String[] args){
        
        boolean[][] map1 = new boolean[4][5]; 
        
        map1[0][0] = true; 
        map1[0][1] = true; 
        map1[0][2] = true; 
        map1[0][3] = true; 
        map1[0][4] = false; 
        map1[1][0] = true; 
        map1[1][1] = true; 
        map1[1][2] = false; 
        map1[1][3] = true; 
        map1[1][4] = false; 
        map1[2][0] = true; 
        map1[2][1] = false; 
        map1[2][2] = false; 
        map1[2][3] = false; 
        map1[2][4] = false;  
        map1[3][0] = false;
        map1[3][1] = false; 
        map1[3][2] = false; 
        map1[3][3] = false; 
        map1[3][4] = false; 
        
        System.out.println(nbOfIslands(map1)); 
        
    }
}