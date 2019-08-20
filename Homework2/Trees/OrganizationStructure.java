import java.util.*; 
import java.lang.*; 

public class OrganizationStructure {
    public Employee ceo;
    
    //used during print number of levels

    public static class Employee {
        public String name;
        public String title;
        public List<Employee> directReports;
        
        public Employee(String n, String t, List<Employee> list){
            name = n; 
            title = t; 
            directReports = list; 
        }
    }
    
    public OrganizationStructure (Employee top){
        ceo = top;
    }
    
    public void printLevelByLevel(){
        
        //Level by Level traversal
        
        Employee top = this.ceo; 
        
        //put the ceo and all the direct reports in a queue
        //Repeat for each node. 
        
        LinkedList <Employee> queue = new LinkedList<> ();  
        
        queue.addLast(top); 
        
        
        while(!queue.isEmpty()){
            //Remove top of the queue
            //Then print it
            
            Employee node = queue.removeFirst(); 
            
            print_employee(node); 
            
            //add reports in the queue
            
            if(node.directReports != null){
                List <Employee> rep = node.directReports;
            
                for(int i = 0; i < rep.size(); i++){
                    queue.addLast(rep.get(i)); 
                }
            }
            
        }
    }
    
    public void print_employee(Employee tmp){
        System.out.println("Name: " + tmp.name + ", Title: " + tmp.title);
    }
    
    public int print_num_levels(){
        
        Employee ceo = this.ceo; 
        
        //use private recursive helper method
        
        return print_num_levels(ceo); 
    }
    
    public int print_num_levels(Employee top){
        
        int root_level = 1; //the level at the root
        int sub_levels = 0; 
        
        
        if(top.directReports != null){
            List<Employee> list = top.directReports; 
        
            if(list.size() >= 2){
            
                for(int i = 1; i < list.size(); i++){
                    sub_levels = Math.max(print_num_levels(list.get(i-1)), print_num_levels(list.get(i))); 
                }
            }
            else if(list.size() == 1){
                sub_levels = print_num_levels(list.get(0)); 
            }
        }
        
        return root_level + sub_levels; 
    }
    
    public static void main(String[] args){
        
        //testing organization Structure
        
        Employee intern = new Employee("k", "Sales Intern", null); 
        List <Employee> one = new LinkedList<> (); 
        
        one.add(intern); 
        
        Employee sales_rep = new Employee("J", "Sales Representative", one); 
        
        Employee engineer_1 = new Employee("F", "Engineer", null); 
        Employee engineer_2 = new Employee("G", "Engineer", null); 
        Employee engineer_3 = new Employee("H", "Engineer", null); 
        
        List<Employee> two = new LinkedList<>(); 
        two.add(sales_rep); 
        
        Employee director = new Employee("I", "Director", two); 
        
        List<Employee> three = new LinkedList<> (); 
        three.add(engineer_1); 
        three.add(engineer_2); 
        three.add(engineer_3); 
        
        Employee manager_1 = new Employee("D", "Manager", three); 
        
        Employee manager_2 = new Employee("E", "Manager", null); 
        
        //empty one and two so we can reuse them
        
        
        List<Employee> four = new LinkedList<>(); 
        List<Employee> five = new LinkedList<>(); 
        
        four.add(director); 
        
        five.add(manager_1); 
        five.add(manager_2); 
        
        Employee cfo = new Employee("B", "CFO", four); 
        
        Employee cto = new Employee("C", "CTO", five); 
        
        List<Employee> six = new LinkedList<> (); 
        
        six.add(cfo); 
        six.add(cto); 
        
        Employee ceo = new Employee("A", "CEO", six); 
        
        OrganizationStructure company = new OrganizationStructure(ceo); 
        
        company.printLevelByLevel(); 
        
        System.out.println(company.print_num_levels()); 
        
        
    }
}
