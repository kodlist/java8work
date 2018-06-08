package Streams;

import java.util.Optional;

public class OptionalClass {
	
	public static void main(String[] args) {
		
		 Optional<String> ani = Optional.of("Elephant");
		 
		 System.out.println(ani);		 
		 System.out.println(ani.get());
		 System.out.println(ani.empty());
		 
		 System.out.println("=========");
		 
		 String an1 = "Panda";
		 String an2 = null;
		 
		 System.out.println(Optional.ofNullable(an1));
		 System.out.println(Optional.ofNullable(an2));		 
		 System.out.println(ani.orElse("Cat"));
		 
		 Integer value1 = null;
	     Integer value2 = new Integer(10);
			
	     //Optional.ofNullable - allows passed parameter to be null.
	     Optional<Integer> a = Optional.ofNullable(value1);
			
	     //Optional.of - throws NullPointerException if passed parameter is null
	     Optional<Integer> b = Optional.of(value2);
	     System.out.println();
	     OptionalClass c = new OptionalClass();
		 
		// c.sum(value1);
		// Optional<Integer> v1 = Optional.of(value1); 
	     
		 Optional<Integer> v1 = Optional.ofNullable(value1);
		 //System.out.println(v1.get());  // this will throw nullpointer exception, but the below wonts
		 System.out.println("--------  "+v1.ofNullable(value1));
		 
		 
		 Optional<Integer> v2 = Optional.of(value2);
		 c.sumA(v1, v2);
	}
	
	
	
	int i =1;
	public void sum(Integer i)
	{
		this.i = i+1;
	}
	
	public void sumA(Optional<Integer> A , Optional<Integer>B)
	{
		//Optional.orElse - returns the value if present otherwise returns
	    //the default value passed.
	      Integer value1 = A.orElse(new Integer(3));
		i = value1 + B.get() +1;
		System.out.println(i);
	}

}
