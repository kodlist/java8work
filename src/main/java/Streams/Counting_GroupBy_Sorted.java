package Streams;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Counting_GroupBy_Sorted {
	
	public static void main(String[] args) {
		
		List<String> items =
                Arrays.asList("apple", "apple", "banana",
                        "apple", "orange", "banana", "papaya");

        Map<String, Long> result =
                items.stream().collect(
                        Collectors.groupingBy(
                                Function.identity(), Collectors.counting()  )
                );
        
        System.out.println(result);
        
        //sorting
        Map<String, Long> finalMap = new LinkedHashMap<>();

        //Sort a map and add to finalMap
        result.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed()).forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));
                       
        System.out.println(finalMap);
        System.out.println("============================ 1");
        Map<String, Long> finalMap1 = new LinkedHashMap<>();
        result.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue()).forEachOrdered(e -> finalMap1.put(e.getKey(), e.getValue()));
        System.out.println(finalMap1);
        System.out.println("============================ 2");
        Map<String, Long> finalMap2 = new LinkedHashMap<>();
        
        result.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue()).forEachOrdered(e -> finalMap1.put(e.getKey(), e.getValue()));
        System.out.println("============================ 3");
        
        
        //You can then proceed to use other stream operations to consume the data. For example, if you want the top 10 in a new map:
        
        Map<String, Long> topTHREE =
        		result.entrySet().stream()
        	       .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        	       .limit(2)
        	       .collect(Collectors.toMap(
        	          Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        
        System.out.println(topTHREE);
        System.out.println(topTHREE.get("apple"));
        
        
     
	}

}
