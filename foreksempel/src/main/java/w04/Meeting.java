package w04;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Meeting {
	private Date startTime;
	private Date endTime;

	public Meeting(Date startTime, Date endTime) {
		if (startTime != null && endTime != null && startTime.before(endTime)) {
			this.startTime = startTime;
			this.endTime = endTime;
		}
		// generelt sett bør en prøve å unngå å duplisere kode
		// så en forenkling er i stede å kalle en metode vi har
		// setMeeting(startTime, endTime);

		// hva er fordeler og ulemper med denne metoden?
//		if (!setMeeting(startTime, endTime)) {
//			throw new IllegalArgumentException("startTime/endTime har ugyldige verdier");
//		}
	}

	/*
	 * Denne metoden fungerer greit nok da den returnere true hvis møtetidspunktet
	 * satt er gyldig. Men denne sjekken fungerer dårlig for konstruktøren, for
	 * konstruktøren er det mer hensiktsmessig å å kaste en exception
	 */
	public boolean setMeeting(Date startTime, Date endTime) {
		if (startTime != null && endTime != null && startTime.before(endTime)) {
			this.startTime = startTime;
			this.endTime = endTime;
			return true;
		}
		return false;
	}

	/*
	 * Denne metoden kaster en exception med litt mer informasjon hvis parametrene
	 * ikke er gyldige. Vi har valgt å fortsatt returnere true/false da dette ikke
	 * bryter den eksiterende kontrakten. Men i slike tilfeller bør en heller sette
	 * den gamle metoden til utgått/deprecated og heller lage en ny metode med nytt
	 * navn slik at utviklere som benytter denne metoden kan dra nytte av de nye
	 * mulighetene med den nye koden. Men hva tenker du er best? Lage en ny metode
	 * eller beholde den gamle og heller bare kaste en exception i konstruktøren?
	 */
//	public boolean setMeetingTime(Date startTime, Date endTime) {
//		if (startTime != null && endTime != null && startTime.before(endTime)) {
//			this.startTime = startTime;
//			this.endTime = endTime;
//			return true;
//		}
//		// kunne vi ha gitt bedre feilmeldinger?
//		throw new IllegalArgumentException("startTime/endTime har ugyldige verdier");
//		//return false;
//	}

	public void setMeetingTime(Date startTime, Date endTime) {
		if (startTime == null) {
			throw new IllegalArgumentException("startTime kan ikke være null");
		} else if (endTime == null) {
			throw new IllegalArgumentException("endTime kan ikke være null");
		} else if (startTime.after(endTime)) {
			throw new IllegalArgumentException("startTime må være før endTime");
		}

		this.startTime = startTime;
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		return "Meeting [start=" + sdf.format(startTime) + ", end=" + sdf.format(endTime) + "]";
	}
}
