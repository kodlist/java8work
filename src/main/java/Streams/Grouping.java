package Streams;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class Item {

    private String name;
    private int qty;
    private BigDecimal price;
	
	public Item(String name, int qty, BigDecimal price) {
		super();
		this.name = name;
		this.qty = qty;
		this.price = price;
	}
	
	public String toString()
	{
		return " name "+ name +" qty "+qty +" price "+price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

    //constructors, getter/setters 
    
    
}
public class Grouping {

	
	public static void main(String[] args) {
		 List<Item> items = Arrays.asList(
	                new Item("apple", 10, new BigDecimal("9.99")),
	                new Item("banana", 20, new BigDecimal("19.99")),
	                new Item("orang", 10, new BigDecimal("29.99")),
	                new Item("watermelon", 10, new BigDecimal("29.99")),
	                new Item("papaya", 20, new BigDecimal("9.99")),
	                new Item("apple", 10, new BigDecimal("9.99")),
	                new Item("banana", 10, new BigDecimal("19.99")),
	                new Item("apple", 20, new BigDecimal("9.99"))
	        );

	        Map<String, Long> counting = items.stream().collect(
	                Collectors.groupingBy(Item::getName, Collectors.counting()));

	        System.out.println(counting);
	        
	        System.out.println("++++++++++++++++++++++++++++++++++");

	        Map<String, Integer> sum = items.stream().collect(
	                Collectors.groupingBy(Item::getName, Collectors.summingInt(Item::getQty)));

	        System.out.println(sum);
	        
	      //group by price
	        System.out.println("group by price");
	        Map<BigDecimal, List<Item>> groupByPriceMap = 
				items.stream().collect(Collectors.groupingBy(Item::getPrice));
	        System.out.println(groupByPriceMap);

	        
	        System.out.println("group by price, uses 'mapping' to convert List<Item> to Set<String>");
	     // group by price, uses 'mapping' to convert List<Item> to Set<String>
	        Map<BigDecimal, Set<String>> result3 =
	                items.stream().collect(
	                        Collectors.groupingBy(Item::getPrice,
	                                Collectors.mapping(Item::getName, Collectors.toSet())
	                        )
	                );

	        System.out.println(result3);
	        
	        
	}
}
