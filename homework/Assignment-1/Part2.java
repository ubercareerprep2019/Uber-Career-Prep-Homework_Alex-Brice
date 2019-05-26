
import java.lang.String;
import java.util.Arrays; 

public class Part2{

	public static boolean isStringPermutation(String s1, String s2){
		if(s1.length() != s2.length()){
			return false; 
		}

		boolean isPerm = false; 
		int count = 0; //number of times isPerm has been assigned to true; 

		for(int i = 0; i < s1.length(); i++){
			
			char m = s1.charAt(i);

			for(int j = 0; j < s2.length(); j++){
				if(m == s2.charAt(j)){
					isPerm = true; 
					count++; 
				}
			}
		}

		if(count != s1.length()){
			isPerm = false; 
		}

		return isPerm; 

	}


	public static int[][] pairsThatEqualSum(int arr[], int target){

		int len = arr.length; 

		int pairs[][] = new int[len * 2][2]; //ample space 

        
        int i = 0; 
        
        //indexes for pairs
        int m = 0; 
        int n = 0; 
        
		while (i < len){
			int elt = arr[i]; 

			for(int j = 0; j < len; j++){
				int tmp = arr[j]; 
             
				if(elt + arr[j] == target){
					pairs[m][n] = elt;
                    pairs[m][n+1] = tmp;
                    m++; 
                    n = 0; 
				}
			}
			i++; 
		}

		return pairs; 
	}
    
    public static void print_2D_array(int[][] array){
        //we know each row has 2 columbs
        
        int row = 0; 
        
        System.out.print("[ "); 
        for (row = 0; row < array.length; row++){
            System.out.print("("); 
            System.out.print(array[row][0] + ", " + array[row][1]); 
            System.out.print(")"); 
        }
        System.out.print(" ]"); 
    }


	public static final void main(String[] args){

		//testing first function

		String str_1 = "hello"; 
		String str_2 = "elloh"; 

        
        /**assert isStringPermutation(str_1, str_2) : "This should return true"; 
        
        assert (!isStringPermutation(str_1, "horimbere")) : "This should be false"; 
        
        assert isStringPermutation("JUliette", "UlietteJ") :"This should be true"; **/


		//testing 2nd function
		

		int arr[] = {5, 4, 2, 1, 8, 9, 6, 5, 3, 0}; 
        
        System.out.println(Arrays.toString(arr)); 
		int expected[][] = {{5, 5},{4, 6}, {2,8}, {1, 9}};
        
        print_2D_array(expected); 
 
		int output[][] = pairsThatEqualSum(arr, 10); 

		print_2D_array(output);  

		//check if equal

		 

	}
}
