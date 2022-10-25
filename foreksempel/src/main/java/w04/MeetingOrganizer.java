package w04;

import java.util.Calendar;

public class MeetingOrganizer {
	public static void main(String[] args) {
		Calendar calStart = Calendar.getInstance();
		calStart.set(Calendar.HOUR_OF_DAY, 8);
		calStart.set(Calendar.MINUTE, 15);

		Calendar calStart2 = Calendar.getInstance();
		calStart2.set(Calendar.HOUR_OF_DAY, 12);
		calStart2.set(Calendar.MINUTE, 15);
		
		Calendar calEnd = Calendar.getInstance();
		calEnd.set(Calendar.HOUR_OF_DAY, 10);
		calEnd.set(Calendar.MINUTE, 0);

		System.out.println("Møte nr#1");
		Meeting m = new Meeting(calStart.getTime(), calEnd.getTime());
		System.out.println(m.toString());
		
		// la oss nå sette et nytt møtetidspunkt, med start etter slutt
//		if (m.setMeeting(calStart2.getTime(), calEnd.getTime())) {
//			// hvis den blir satt skriver vi den ut
//			System.out.println(m.toString());
//		}
//		else {
//			System.out.println("Nytt møtetidspunkt ble ikke satt");
//		}

//		try {
//			// her benytter vi den nye metoden som ev kaster en exception
//			m.setMeetingTime(calStart2.getTime(), calEnd.getTime());
//			// hvis så langt kan vi skriver den ut
//			System.out.println(m.toString());
//		} catch (Exception e) {
//			System.out.println("Nytt møtetidspunkt ble ikke satt, " + e.getMessage());
//		}
			
//		System.out.println();
//		
//		System.out.println("Møte nr#2");
//		// La oss gjøre det igjen, men nå sette start-tidspunktet etter slutt-tidspunktet i det vi oppretter
//		// møtet. Hva skjer da?
//		calStart.set(Calendar.HOUR_OF_DAY, 12);
//		Meeting m2 = new Meeting(calStart.getTime(), calEnd.getTime());
//		System.out.println(m2.toString());
	}
}
