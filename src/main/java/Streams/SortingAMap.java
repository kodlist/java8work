package Streams;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortingAMap {
	
	public static void main(String[] args) {
		
		Map<Integer, String > map = new HashMap<Integer, String> ();
		
		map.put(1, "cidr");
		map.put(2, "baa");
		
		Map <Integer, String>  result = map.entrySet().stream()
				    . sorted(Map.Entry.comparingByValue())
				    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue ,   (oldv, newv) -> oldv, LinkedHashMap:: new));
		
		
		result.entrySet().stream().forEachOrdered(x -> System.out.println(x.getKey() +" "+x.getValue()));
		
		
		result = map.entrySet().stream()
			    . sorted(Map.Entry.comparingByKey())
			    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue ,   (oldv, newv) -> oldv, LinkedHashMap:: new));
	
		result.entrySet().stream().forEachOrdered(x -> System.out.println(x.getKey() +" "+x.getValue()));
		
	}

}
