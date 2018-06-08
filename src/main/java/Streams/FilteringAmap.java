package Streams;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FilteringAmap {
	
	public static void main(String[] args) {
		
		Map<Integer, String> map = new HashMap<>();
	    map.put(1, "linode.com");
	    map.put(2, "heroku.com");
		
		//Map -> Stream -> Filter -> String
		String result = map.entrySet().stream()
			.filter(x -> "linode.com".equals(x.getValue()))
			.map(x->x.getValue())
			.collect(Collectors.joining());
		
		System.out.println(result);
		
		
		Map<Integer, String> collect = map.entrySet().stream()
								.filter(x -> x.getKey()==1)
								.collect(Collectors.toMap(Map.Entry:: getKey, Map.Entry:: getValue));
		
		System.out.println(collect);
		
		
		
		
		Map<Integer, String> HOSTING = new HashMap<>();
        HOSTING.put(1, "linode.com");
        HOSTING.put(2, "heroku.com");
        HOSTING.put(3, "digitalocean.com");
        HOSTING.put(4, "aws.amazon.com");
        
        
     // filter more values
        result = HOSTING.entrySet().stream()
                .filter(x -> {
                    if (!x.getValue().contains("amazon") && !x.getValue().contains("digital")) {
                        return true;
                    }
                    return false;
                })
                .map(x -> x.getValue())
                .collect(Collectors.joining(","));

        System.out.println("With Java 8 : " + result);
        //this should print ---- With Java 8 : linode.com,heroku.com
	}

}
