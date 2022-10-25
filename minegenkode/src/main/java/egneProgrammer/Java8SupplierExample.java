package egneProgrammer;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Java8SupplierExample {
	public static void main(String[] args) {

		Supplier<String> supplier = () -> "Arpit";
		System.out.println(supplier.get());
		

		Supplier<Integer> supplier2 = () -> new Random().nextInt(10);
		Stream.generate(supplier2).limit(5).forEach(System.out::println);

	}
}
