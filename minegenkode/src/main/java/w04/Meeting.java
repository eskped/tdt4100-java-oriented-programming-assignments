package w04;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Meeting {

	private Date startTime;
	private Date endTime;

	public Meeting(java.util.Date startTime, Date endTime) {
		if (startTime != null && endTime != null && startTime.before(endTime)) {
			this.startTime = startTime;
			this.endTime = endTime;
		}
		else {
			throw new IllegalArgumentException("Feil dato");
		}
	}
	
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH");
		return "Meeting [start = " + sdf.format(startTime) + " , end=" + sdf.format(endTime) + "]";
	}
	
	
}
