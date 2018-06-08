package Streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee{
	
	int id;
	String name;
	int salary;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Employee(int id, String name, int salary) {
		//super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
}
public class ConvertListToMap {
	
	public static void main(String[] args) {
		
		
		List<Employee> listX = new ArrayList<>();
		listX.add(new Employee(1, "john", 80));
		listX.add(new Employee(2, "linsay", 100));
		listX.add(new Employee(3, "sarah", 120));
		listX.add(new Employee(4, "micheal", 230));
        listX.add(new Employee(5, "mira", 11));		
        listX.add(new Employee(6, "sarah", 100)); 

        
     //   Map<String, Integer> result1 = listX.stream().collect(    Collectors.toMap(Employee::getName, Employee::getSalary));

       // System.out.println("Result 1 : " + result1); // this will throw exception, becuase of duplicate keys "sarah" in map.
        
        
        // we will use latest "sarah" in our map.
        Map<String, Integer> result1 = listX.stream().collect(    Collectors.toMap(Employee::getName
        		, Employee::getSalary, (previousValue, newValue) -> newValue));
        
        System.out.println("Result 1 : " + result1);
        
        Map<String, Integer> result2 = listX.stream().sorted(Comparator.comparingInt(Employee:: getSalary).reversed())
        											.collect(Collectors.toMap(
        					                                Employee::getName, Employee::getSalary, // key = name, value = salary
        					                                (oldValue, newValue) -> oldValue,       // if same key, take the old key
        					                                LinkedHashMap::new                      // returns a LinkedHashMap, keep order
        					                        ));
        
        System.out.println(result2);
        
        
	}

}
