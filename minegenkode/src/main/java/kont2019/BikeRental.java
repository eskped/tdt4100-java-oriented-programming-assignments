package kont2019;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class BikeRental {
	
	private Collection<Bike> bikes;
	private final Collection<GeoLocation> locations = new ArrayList<GeoLocation>();
	
	private DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	
	
	public BikeRental(Collection<Bike> bikes) {
		this.bikes = new ArrayList<>(bikes);
	}
	/**
	 * Counts the number of available bikes within a certain distance of a provided
	 * location.
	 * 
	 * @param location
	 * @param distance
	 * @return the number of available bikes within a certain distance of a provided
	 *         location
	 */
	private int countAvailableBikesNearby(GeoLocation location, double distance) {
		return (int) bikes.stream()
				.filter(b -> b.getLocation().distance(location) < distance && b.getRenter() == null)
				.count();
	}

	/**
	 * Finds the closest station (location) within the provided (maximum) distance
	 * of the provided bike
	 * 
	 * @param bike
	 * @param minDistance
	 * @return the closest station (location) within the provided (maximum) distance
	 *         of the provided bike
	 */
	private GeoLocation getStationNearby(Bike bike, double maxDistance) {
		return locations.stream()
				.filter(l -> bike.getLocation().distance(l) < maxDistance)
				.min((l, j) -> (int) l.distance(j)).get();
	}

	/**
	 * @return the bikes that currently are rented
	 */
	Collection<Bike> getRentedBikes() {
//		final Collection<Bike> bikes1 = new ArrayList<>();
//		for (Bike bike : bikes) {
//			if (bike.getRenter() == null) {
//				bikes1.add(bike);
//			}
//		}
//		return bikes;
		
		return bikes.stream().filter(b -> b.getRenter() == null).collect(Collectors.toCollection(ArrayList::new));
	}

	/**
	 * @return the bikes that are close to a station (within 30m), but still are
	 *         rented
	 */
	private Collection<Bike> getUnreturnedBikes() {
		return bikes.stream().filter(b -> b.getRenter() != null).collect(Collectors.toCollection(ArrayList::new));

	}

	/**
	 * Called when a person starts renting a bike by taking it from a station.
	 * Checks the arguments before registering all necessary info of the rental.
	 * 
	 * @param person
	 * @param now        the start time of the rental
	 * @param returnTime the expected return time
	 * @throws (some subclass of) RuntimeException if the now isn't before
	 *               returnTime
	 * @throws (some subclass of) RuntimeException if the bike isn't available for
	 *               rental
	 */
	public void rentBike(Person person, Bike bike, LocalDateTime now, LocalDateTime returnTime) {
		if (returnTime.isBefore(now)) {
			throw new IllegalArgumentException("Nå er etter leveringstid");
		}
		if (getRentedBikes().contains(bike)) {
			throw new IllegalArgumentException("Denne sykkelen er opptatt");
		}
		
		bike.setRenter(person);
		bike.setRentTime(now);
		bike.setReturnTime(returnTime);
	}

	/**
	 * Called when a person extends an ongoing bike rental. Checks the arguments
	 * before registering all necessary info of the rental extension.
	 * 
	 * @param person
	 * @param bike
	 * @param now        the time the extension starts
	 * @param returnTime the (new) expected return time
	 * @throws (some subclass of) RuntimeException if the now isn't before
	 *               returnTime
	 * @throws (some subclass of) RuntimeException if the bike isn't currently being
	 *               rented
	 * @throws (some subclass of) RuntimeException if person isn't currently renting
	 *               the bike
	 */
	public void extendRental(Person person, Bike bike, LocalDateTime now, LocalDateTime returnTime) {
		if (bike.getRenter() != person) {
			throw new IllegalArgumentException("Samme person må leie");
		}
		if (getUnreturnedBikes().contains(bike)) {
			throw new IllegalArgumentException("Du kan ikke levere en sykkel som er ledig");
		} 
		if (returnTime.isBefore(now)) {
			throw new IllegalArgumentException("Nå er etter leveringstid");
		}
		if (returnTime.isBefore(bike.getExceptedTime())) {
			throw new IllegalArgumentException("Kan ikke be om en kortere leveringstid");
		}
		if (now.isBefore(bike.getRentTime())) {
			throw new IllegalArgumentException("Nåtiden er før sykkelen ble leid");
		}
		bike.extendTime(now, returnTime);
	}

	/**
	 * Called when a person returns a bike. Checks the arguments, computes the
	 * price, performs the payment and clears the rental info. Note that if the
	 * payment isn't completed, the rental info should not be cleared.
	 * 
	 * @param person
	 * @param bike
	 * @param now    the time the bike is returned
	 * @throws (some subclass of) RuntimeException if the bike isn't currently being
	 *               rented by the person argument
	 * @throws (some subclass of) RuntimeException if person isn't near (within 30m
	 *               of) a station
	 */
	public void returnBike(Person person, Bike bike, LocalDateTime now) {
		if (getUnreturnedBikes().contains(bike)) {
			throw new IllegalArgumentException("Du kan ikke levere en sykkel som er ledig");
		}
		if (bike.getRenter() != person) {
			throw new IllegalArgumentException("Samme person må levere sykkelen");
		}
		if (getStationNearby(bike, 30.0) == null) {
			throw new IllegalArgumentException("Du må være nærme en stasjon for å levere en sykkel");
		}
		
		
		try {
			person.withdraw(calculateAmount(person, bike, now));
			printReceipt(person, bike);
			bike.cancelRide();
			
		} catch (Exception e) {
		}
		
	}
	
	private double calculateAmount(Person person, Bike bike, LocalDateTime now) {
		Duration duration = Duration.between(bike.getRentTime(), bike.getExceptedTime());
		double amount = Double.valueOf(duration.toHours()) * 10;
		amount += Double.valueOf(bike.getExtentedTimes().size() * 5);
		if (bike.getExtentedTimes().get(bike.getExtentedTimes().size()-1).getReturnTime().isAfter(now)) {
			amount += 10.0;
		}
		return amount;
	}

	/**
	 * Called when the Person has returned a Bike. Displays initial rent period
	 * Displays extensions of the rent period Computes and displays total cost,
	 * including fees for late return.
	 * 
	 * @param person
	 * @param bike
	 */
	void printReceipt(Person person, Bike bike) {
		String s = "";
		int i = 1;
		s += "Initial rental from " + bike.getRentTime().format(format) + " to " + bike.getExceptedTime().format(format) + "\n";
		for (ExtentedPeriod extentedPeriod : bike.getExtentedTimes()) {
			s += "Extenstion " + String.valueOf(i) + " from " + extentedPeriod.getExtentedStartTime().format(format) + " to " + extentedPeriod.getReturnTime().format(format);
			i++;
		}
		s += "Total cost: " + calculateAmount(person, bike, LocalDateTime.now()) + " kr";
		System.out.println(s);
	}
}
