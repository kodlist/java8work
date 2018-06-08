package DateClassInJava8;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateObjects {
	
	public static void main(String[] args) {
		
		
		LocalDateTime ldate =  LocalDateTime.now();
		System.out.println(ldate);
		System.out.println(ldate.getHour() + " : "+ ldate.getMinute());
		
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-mm-mm hh:mm:ss");
		String formatedDate = ldate.format(df);
		System.out.println("Ater formater : "+formatedDate);
		
		
		Instant instant = Instant.now();

        System.out.println("Instant : " + instant);

       
        ZonedDateTime jpTime1 = instant.atZone(ZoneId.of("Asia/Tokyo"));
        
        System.out.println("time in Japan : "+jpTime1);
		
        
        LocalDateTime dateTime = LocalDateTime.of(2018, Month.JUNE, 22, 8, 57, 38);

        
        ZonedDateTime jpTime2 = dateTime.atZone(ZoneId.of("Asia/Tokyo"));

        System.out.println("ZonedDateTime : " + jpTime2);
        
        
        ZonedDateTime indTime1 = instant.atZone(ZoneId.of("Asia/Kolkata"));
        System.out.println("ind time... "+indTime1);
        System.out.println(indTime1.getHour() + " : "+indTime1.getMinute());
	}

}
