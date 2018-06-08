package Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ConditionCheckWithStreams {
	
	public static void main(String[] args) {
		
		String[] srs = new String[] {"apple", "kiwi"};
		//int [] i = new int[3];
		
		
		boolean result = Arrays.stream(srs).anyMatch("kiwi"::equals);
		
		if(result)
		{
			System.out.println("kiwi");
		}
		
		int[] number = {8, 1, 10};

        //Java 8
        boolean r1 = IntStream.of(number).anyMatch(x -> x == 1);
        System.out.println(r1);

	}

}
