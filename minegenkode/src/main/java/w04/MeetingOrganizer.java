package w04;

import java.util.Calendar;

public class MeetingOrganizer {
	public static void main(String[] args) {
		Calendar calStart = Calendar.getInstance();
		calStart.set(Calendar.HOUR_OF_DAY, 8);
		calStart.set(Calendar.MINUTE, 15);
		
		Calendar calEnd = Calendar.getInstance();
		calEnd.set(Calendar.HOUR_OF_DAY, 10);
		calEnd.set(Calendar.MINUTE, 0);

		Meeting m = new Meeting(calStart.getTime(), calEnd.getTime());
		System.out.println(m.toString());
		
		System.out.println();
		
		// ah, vi gj�r om litt
		//calStart.set(Calendar.HOUR_OF_DAY, 12);	
		//m.startTime = calStart.getTime();		
		//System.out.println(m.toString());
		// upsk!!!
	}
}
