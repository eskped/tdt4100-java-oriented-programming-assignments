package kont2019;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class BikeRentalController {
	// Kontroller-logikk

	private BikeRental bikeRental;

	private final Person me = new Person();

	// refers to currently selected bike in map
	private Bike bike;

	@FXML
	private TextField fromInput;
	@FXML
	private TextField toInput;

	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

	@FXML
	public void initialize() {
		setFromTime(LocalDateTime.now());
		setToTime(LocalDateTime.now().plusHours(1));
	}

	private void plus1HourAction() {
		setToTime(getToTime().plusHours(1));
	}

	private void minus1HourAction() {
		if (getToTime().plusHours(-1).isBefore(getToTime())) {
			setToTime(getToTime().plusHours(-1));
		}
	}

	private void rentAction() {
		if (bike.getRenter() != me) {
			bikeRental.rentBike(me, bike, getToTime(), getFromTime());
		} else {
			bikeRental.extendRental(me, bike, getToTime(), getFromTime());
		}
	}

	/**
	 * @return a LocalDataTime object corresponding to the from input field value
	 */
	private LocalDateTime getFromTime() {
		return LocalDateTime.parse(fromInput.getText(), formatter);
	}

	/**
	 * Updates the from input field value according to the LocalDateTime argument
	 * 
	 * @param time
	 */
	private void setFromTime(final LocalDateTime time) {
		fromInput.setText(time.format(formatter));
	}

	/**
	 * @return a LocalDataTime object corresponding to the from input field value
	 */
	private LocalDateTime getToTime() {
		return LocalDateTime.parse(toInput.getText(), formatter);
	}

	/**
	 * Updates the from input field value according to the LocalDateTime argument
	 * 
	 * @param time
	 */
	private void setToTime(final LocalDateTime time) {
		toInput.setText(time.format(formatter));
	}

}
