package kont2019;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Bike {
	
	
	private Person renter;
	private GeoLocation location;
	private LocalDateTime rentTime;
	private LocalDateTime returnTime;
	private ArrayList<ExtentedPeriod> extendedReturnTimes;
	
	public void setLocation(final GeoLocation location) {
		this.location = location;
	}
	
	public GeoLocation getLocation() {
		return location;
	}
	
	public void setRenter(final Person renter) {
		this.renter = renter;
	}
	
	public void removeRenter() {
		this.renter = null;
	}
	
	public Person getRenter() {
		return renter;
	}
	
	public void setRentTime(LocalDateTime rentTime) {
		this.rentTime = rentTime;
	}
	
	public LocalDateTime getRentTime() {
		return rentTime;
	}
	
	
	public void setReturnTime(LocalDateTime returnTime) {
		this.returnTime = returnTime;
	}
	
	public LocalDateTime getReturnTime() {
		return returnTime;
	}
	
	public void extendTime(LocalDateTime now, LocalDateTime returnTime) {
		if (this.extendedReturnTimes == null) {
			this.extendedReturnTimes = new ArrayList<>();
		}
		this.extendedReturnTimes.add(new ExtentedPeriod(now, returnTime));
	}
	
	public LocalDateTime getExceptedTime() { 
		return this.extendedReturnTimes.get(extendedReturnTimes.size()-1).getReturnTime();
	}
	
	public ArrayList<ExtentedPeriod> getExtentedTimes() {
		return this.extendedReturnTimes;
	}

	
	public void cancelRide() {
		this.rentTime = null;
		this.returnTime = null;
		this.extendedReturnTimes.clear();
	}
	
}
