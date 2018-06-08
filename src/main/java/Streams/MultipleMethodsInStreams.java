package Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

//stream() -  Returns a sequential stream considering collection as its source.
//********    filter(), map(), limit(), reduce(), find(), match(), 

//parallelStream() − Returns a parallel Stream considering collection as its source.

// Stream takes Collections, Arrays, or I/O resources as input source.

public class MultipleMethodsInStreams {
	
	
	public static void main(String[] args) {
		
		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
		
		//example 1
		List<String> listst1 = strings.stream().filter(str -> str.contains("bc") ).collect(Collectors.toList());
		
		//example2
		
		long count = strings.stream().filter(str -> str.contains("bc") ).count();
		System.out.println(count);
		
	    System.out.println("------------line 1---------");
	    
	    //example 3
	    listst1.stream().forEach(s -> {System.out.println(s)  ;});
	    System.out.println("------------line 2---------");
	    
	    //example 4
	    strings.stream().forEach(s -> System.out.println(s)  );
	    
	    System.out.println("------------line 3---------");
	    //example 5
	    
	    strings.stream().forEach(System.out ::println);
	    System.out.println("------------line 5---------");
	    //example 6
	    List<Integer> numbers = Arrays.asList(3, 2, 3);

	  //get list of unique squares
	  List<Integer> squaresList = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
	  
	
	  squaresList.forEach(System.out:: println);
	  
	  
	  System.out.println("------------line 6---------");
	  numbers.stream().map( i -> i-2).distinct().collect(Collectors.toList()).forEach( x -> System.out.println(x));
	  
	  

	  System.out.println("------------line 7---------");

	    List<Integer> numbers1 = Arrays.asList(10, 2, 3);
	  
	    numbers1.stream().sorted(new Comparator<Integer>() { public int compare(Integer i1 , Integer i2) {return i2-i1;}
	}).collect(Collectors.toList()).forEach(System.out:: println);
	    
	    
	    
	    List<Integer> integers = Arrays.asList(1,2,13,4,15,6,17,8,19);
	    IntSummaryStatistics stats = integers.stream().mapToInt((x) ->x).summaryStatistics();
		
	      System.out.println("Highest number in List : " + stats.getMax());
	      System.out.println("Lowest number in List : " + stats.getMin());
	      System.out.println("Sum of all numbers : " + stats.getSum());
	      System.out.println("Average of all numbers : " + stats.getAverage());
	      System.out.println("Random Numbers: ");
			
	    
	      
	      System.out.println("------------line 7---------");
	      
	      List<String> alpha = Arrays.asList("a", "b", "c", "d");

	        //Before Java8
	        List<String> alphaUpper = new ArrayList<>();
	        for (String s : alpha) {
	            alphaUpper.add(s.toUpperCase());
	        }

	        System.out.println(alpha); //[a, b, c, d]
	        System.out.println(alphaUpper); //[A, B, C, D]

	        // Java 8
	        List<String> collect = alpha.stream().map(String::toUpperCase).collect(Collectors.toList());
	        System.out.println(collect); //[A, B, C, D]
	      
	    
	}

}
