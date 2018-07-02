package Streams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConvertMaptoList {

	
	public static void main(String[] args) {
		
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		map.put(1, "roses"); map.put(2, "avion");
		
		// Converting all Map keys to a List
		List<String> list = new ArrayList(map.keySet());
		
		
		// Java 8, Converting all Map values  to a List
		List<String> list1 = map.values().stream().collect(Collectors.toList());
		
		System.out.println(list1);

		//List<String> list3 = map.keySet().stream().collect(Collectors.toList());
		
		
		
		// Java 8, seem a bit long, but you can enjoy the Stream features like filter and etc. 
		List<String> list2 = map.values().stream().filter(x -> !"roses".equalsIgnoreCase(x)).collect(Collectors.toList());
		
		System.out.println(list2);
		
		
		
	}
}
