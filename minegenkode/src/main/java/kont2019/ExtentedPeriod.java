package kont2019;

import java.time.LocalDateTime;


public class ExtentedPeriod {
	
	private LocalDateTime rentTime;
	private LocalDateTime returnTime;

	
	public ExtentedPeriod(LocalDateTime now, LocalDateTime returnTime) {
		this.rentTime = now;
		this.returnTime = returnTime;
	}
	
	public LocalDateTime getReturnTime() {
		return returnTime;
	}
	
	public LocalDateTime getExtentedStartTime() {
		return rentTime;
	} 
}
