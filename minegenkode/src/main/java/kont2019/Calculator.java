package kont2019;

import java.time.Duration;
import java.time.LocalDateTime;

public class Calculator {
	
	Person person;
	Bike bike;
	LocalDateTime time;
	
	public double calculate(Person person, Bike bike, LocalDateTime now) {
		//Denne kan være helt lik som calculate amount
		return 0.0;
	}
	
	public double calculate(Person person, LocalDateTime rentedTime, LocalDateTime deliverdTime, int numberOfExtentedTimes, double pricePerHour, double pricePerExtend, double priceForLateReturn) {
		Duration duration = Duration.between(rentedTime, deliverdTime);
		double amount = Double.valueOf(duration.toHours()) * pricePerHour;
		amount += Double.valueOf(numberOfExtentedTimes * pricePerExtend);
		if (deliverdTime.isAfter(LocalDateTime.now())) {
			amount += priceForLateReturn;
		}
		return amount * person.getPersonalRebate();
	}
}
