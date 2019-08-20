/** Implementation of a phone book 
 * using the ListPhoneBook
 * Author: Alex Brice Horimbere
 **/

import java.io.*; 
import java.util.ArrayList; 
import java.util.Date; 
import java.util.concurrent.TimeUnit;
import java.util.zip.*; 


public class TreeExercise{
    
    public static void main(String[] args){
        //This program is run with one command line argument -- the zip;
        //data.csv then search.txt
        
        if(args.length < 1){
            System.out.println("Error: One command line args required. <files.zip>"); 
            System.exit(1); 
        }
        
        String files = args[0]; 
        
        try{
            ZipFile zip = new ZipFile(files); 
        
            ZipEntry data_entry = zip.getEntry("data.csv"); 
            ZipEntry search_entry = zip.getEntry("search.txt"); 
        
            //Input streams for both data_entry and search_entry.
        
            InputStream data_stream = zip.getInputStream(data_entry); 
            InputStream search_stream = zip.getInputStream(search_entry); 
        
            //BufferedReader for both data and search
        
        
            BufferedReader data_reader = new BufferedReader(new InputStreamReader(data_stream)); 
        
            String row; 
            ListPhoneBook list_phonebook = new ListPhoneBook();  
        
            ArrayList<String[]> phone_records = new ArrayList<String[]>(); 
        
            while((row = data_reader.readLine()) != null){
            
                String[] entry = row.split(","); //csv file
            
                //add in the arraylist
                phone_records.add(entry); 
            }
        
            long list_elapsedTime = 0; 
            long bst_elapsedTime = 0; 
            
            String[] ph = phone_records.get(0); 
            String str = ph[0]; 
            String n_str = ph[1]; 
            
            long n_num = Long.parseLong(n_str); 
            
      
            BSTPhoneBook bst_phonebook = new BSTPhoneBook(str, n_num); 
            
            for(int i = 1; i < phone_records.size(); i++){
            
                
                String[] phone_entry = phone_records.get(i); 
            
                String id = phone_entry[0]; 
                String number_in_string = phone_entry[1]; 
            
                
                long phone_number = Long.parseLong(number_in_string); 
            
                long start_t = new Date().getTime(); 
                bst_phonebook.insert(id, phone_number); 
                long end_t = new Date().getTime(); 
            
                long elapsed_t = end_t - start_t; 
            
                bst_elapsedTime += elapsed_t; 
            }
        
            System.out.println("Time to insert 1 million records in the binary Search tree phonebook "
                           + bst_elapsedTime
                           + " milliseconds");
            //inserting in the listPhoneBook
        
            for(int i = 0; i < phone_records.size(); i++){
            
                String[] phone_entry = phone_records.get(i); 
            
                String id = phone_entry[0]; 
                String number_in_string = phone_entry[1]; 
            
                long phone_number = Long.parseLong(number_in_string); 
            
                long start_time = new Date().getTime(); 
                list_phonebook.insert(id, phone_number); 
                long end_time = new Date().getTime(); 
            
                long elapsed_time = end_time - start_time; 
            
                list_elapsedTime += elapsed_time; 
            }
        
            System.out.println("Time to insert 1 million records in the list phonebook:  " + list_elapsedTime
                           + " milliseconds"); 
            
          
        
        System.out.println(); 
        
        /**Printing the size of the phonebook
         * Should be 1000000
         **/
        
        System.out.println("The size of the list phone book is " + list_phonebook.size()); 
        System.out.println("The size of the BST phone book is " + bst_phonebook.size()); 
        
       
        System.out.println(); 
            
        BufferedReader search_reader = new BufferedReader(new InputStreamReader(search_stream)); 
        
        ArrayList<String> search_list = new ArrayList<>(); 
        
        String term; 
        
        while((term = search_reader.readLine()) != null){
            search_list.add(term); 
        }
            
        
            
        assert search_list.size() == 1000; 
        
        //find each entry into the list phone book.
        
        long st = new Date().getTime(); 
        int count = 0; 
        for (int k = 0; k < search_list.size(); k++){
            
            long n = list_phonebook.find(search_list.get(k)); 
            if(n == -1){
                System.out.println("ERROR: find() returned -1"); 
                System.exit(1); 
            }
            count++; 
        }
        
        long end = new Date().getTime(); 
        long time_find = end - st; 
        
        System.out.println("The time to find a record in the list phone book is: "
                          + time_find + " milliseconds");
            
        if(count == 1000){
            System.out.println("find() was called 1000 times"); 
        }
        else{
            System.out.println("ERROR: find() did not get called 1000 times");
            System.exit(1); 
        }
        
        
         System.out.println(); 
        
        
        long s = new Date().getTime(); 
        int count2 = 0; 
        for (int m = 0; m < search_list.size(); m++){
            
            long p = bst_phonebook.find(search_list.get(m)); 
            
           
            if(p == -1){
                System.out.println("ERROR: find() returned -1"); 
                
            }
            count2++; 
        }
        
        long e = new Date().getTime(); 
        long time_f = e - s; 
        
        System.out.println("The time to find a record in the list phone book is: "
                          + time_f + " milliseconds");
            
        if(count2 != 1000){
            System.out.println("ERROR: find() did not get called 1000 times"); 
            System.exit(1); 
        }
        else{
            System.out.println("find() was called 1000 times"); 
        }
        
        
        //close the two bufferedReaders
        
        
        data_reader.close(); 
        search_reader.close();  
        }
        catch(IOException e){
            System.out.println("Caught an exception"); 
        }
    }
  
}