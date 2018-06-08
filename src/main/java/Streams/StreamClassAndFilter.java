package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamClassAndFilter {
	
	public static void main(String[] args) {

        Stream<String> language = Stream.of("java", "python", "node", null, "ruby", null, "php");

        List<String> result = language.collect(Collectors.toList());

        result.forEach(System.out::println);
        language = Stream.of("java", "python", "node", null, "ruby", null, "php");
        System.out.println("===================");
        List<String> result1 = language.filter(x -> x!= null ).collect(Collectors.toList());
        result1.forEach(System.out::println);
        System.out.println("===================");
        language = Stream.of("java", "python", "node", null, "ruby", null, "php");
        List<String> result2 = language.filter(Objects::nonNull).collect(Collectors.toList());
        result2.forEach(System.out::println);
        
        System.out.println("===================");
        int[] intArray = {1, 2, 3, 4, 5};
        
        Stream<int[]> temp = Stream.of(intArray);

     // Cant print Stream<int[]> directly, convert / flat it to IntStream 
        IntStream intStream2 = temp.flatMapToInt(x -> Arrays.stream(x));
        intStream2.forEach(x -> System.out.println(x));
        
        System.out.println("===================");
        
        int[] intArray1 = {1, 2, 3, 4, 5};

        // 1. Arrays.stream -> IntStream 
        
        IntStream intStream1 = Arrays.stream(intArray1);
        intStream1.forEach(x -> System.out.println(x));


    }

}
