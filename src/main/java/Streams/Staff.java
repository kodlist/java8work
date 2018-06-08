package Streams;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


class publicStaff{
	String name;
	int age;
	String extra;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getExtra() {
		return extra;
	}
	public void setExtra(String extra) {
		this.extra = extra;
	}
	
	public String toString()
	{
		return name + " " + age + " "+extra;
	}
}
public class Staff {
	
	private String name;
    private int age;
    private BigDecimal salary;
    
   

    
    public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public int getAge() {
		return age;
	}




	public void setAge(int age) {
		this.age = age;
	}




	public BigDecimal getSalary() {
		return salary;
	}




	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}




	public Staff(String name, int age, BigDecimal salary) {
		//super();
		this.name = name;
		this.age = age;
		this.salary = salary;
	}




	public static void main(String[] args) {
    	 List<Staff> staff = Arrays.asList(
                 new Staff("mkyong", 30, new BigDecimal(10000)),
                 new Staff("jack", 27, new BigDecimal(20000)),
                 new Staff("lawrence", 33, new BigDecimal(30000))
         );
    	 
    	 System.out.println(staff);
    	 System.out.println("------------");
    	 //pre java 8
    	 List<publicStaff> result1 = new ArrayList<>();

    	 
    	 for (Staff temp: staff)
    	 {
    		 publicStaff ps = new   publicStaff();
    		 ps.setName(temp.getName());
    		 ps.setAge(temp.getAge());
    		 
    		 if("mkyong".equals(temp.getName()) )
    		 {
    			 ps.setExtra("the extra filed");
    		 }
    		 
    		 result1.add(ps);
    		 
    	 }
    	 
    	 System.out.println(result1);	 
    	 System.out.println("=====================");
    	 // from java 8
    	 
    	 List<publicStaff> result=  staff.stream().map(m -> {
    		 publicStaff ps = new   publicStaff();
    		 ps.setName(m.getName());
    		 ps.setAge(m.getAge());
    		 if("mkyong".equals(m.getName()) )
    		 {
    			 ps.setExtra("the extra x");
    		 }
    		 return ps;
    	 }).collect(Collectors.toList());
    		 
    	System.out.println(result);	 
    	 
	}




	@Override
	public String toString() {
		return "Staff [name=" + name + ", age=" + age + ", salary=" + salary + "]";
	}
}
