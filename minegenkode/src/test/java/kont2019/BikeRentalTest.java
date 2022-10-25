package kont2019;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.Test;

class BikeRentalTest {


	@Test
	void test() {
		Bike bike1 = new Bike();
		Bike bike2 = new Bike();
		Bike bike3 = new Bike();
		Bike bike4 = new Bike();

		Person person1 = new Person();

		Collection<Bike> noBikes = new ArrayList<>();
		Collection<Bike> a234Bikes = new ArrayList<>();
		a234Bikes.addAll(Arrays.asList(bike2, bike3, bike4));
		Collection<Bike> allBikes = new ArrayList<>();
		allBikes.addAll(Arrays.asList(bike1, bike2, bike3, bike4));

		BikeRental bikeRental = new BikeRental(allBikes);
		assertEquals(noBikes, bikeRental.getRentedBikes());

		bikeRental.rentBike(person1, bike1, LocalDateTime.now(), LocalDateTime.now().plusHours(1));
		assertEquals(allBikes, bikeRental.getRentedBikes());

	}

}
