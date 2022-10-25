package egneProgrammer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamAppliances {
		
	static List<Integer> ints = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
	static List<String> strings = new ArrayList<>(Arrays.asList("hei", "på", "deg"));
	static List<Color> colors = new ArrayList<>(Arrays.asList(new Color("Black", "FFFFFF"), new Color("White", "000000"), new Color("Blue", "FF3377")));
	
	
	private static List<Double> excersice1(List<Integer> ints) {
		Function<Integer,Double> function1 = num -> Math.sqrt(num); 
		Function<Integer, Double> function2 = num -> Double.valueOf(num*num);
		return ints.stream().map(function1).collect(Collectors.toList());
	}
	
	private static ArrayList<String> excersice2(List<String> SL) {
		Function<String,String> function1 = l -> l.toUpperCase(); 
		return SL.stream().map(function1).collect(Collectors.toCollection(ArrayList::new));
	}
	
	private static List<String> excersice3(List<Color> SL) {
		Function<Color,String> function1 = c -> c.getName(); 
		return SL.stream().map(c -> c.getName()).sorted().collect(Collectors.toList());
//		return SL.stream().sorted(Comparator.comparing(function1)).collect(Collectors.toCollection(ArrayList::new));
	}
	
	public static void main(String[] args) {
		System.out.println(excersice1(ints));
		System.out.println(excersice2(strings));
		System.out.println(excersice3(colors));

	}
	
}
