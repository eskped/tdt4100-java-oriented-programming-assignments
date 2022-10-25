package egneProgrammer;

import java.util.Arrays;
import java.util.List;


public class Java8MethodReference {
	
	
	
	public static void main(String[] args) {
		
		List<String> countryList=Arrays.asList(new String[] {"India", "China","Nepal","Russia"});

 
        System.out.println("=======================");
        System.out.println("Using lambda expression");
        System.out.println("=======================");
 
     // Using lambda expression
        countryList.stream().forEach(
                country -> {
//                	country = country.toUpperCase();
                    System.out.println(country);
                }
                );
        
 
        System.out.println("=======================");
        System.out.println("Using Method references");
        System.out.println("=======================");
 
      // Using method reference
        countryList.stream().forEach(
                System.out::println
            );
	}
}
