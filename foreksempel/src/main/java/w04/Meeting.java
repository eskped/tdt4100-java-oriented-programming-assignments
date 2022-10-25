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
		// generelt sett b�r en pr�ve � unng� � duplisere kode
		// s� en forenkling er i stede � kalle en metode vi har
		// setMeeting(startTime, endTime);

		// hva er fordeler og ulemper med denne metoden?
//		if (!setMeeting(startTime, endTime)) {
//			throw new IllegalArgumentException("startTime/endTime har ugyldige verdier");
//		}
	}

	/*
	 * Denne metoden fungerer greit nok da den returnere true hvis m�tetidspunktet
	 * satt er gyldig. Men denne sjekken fungerer d�rlig for konstrukt�ren, for
	 * konstrukt�ren er det mer hensiktsmessig � � kaste en exception
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
	 * ikke er gyldige. Vi har valgt � fortsatt returnere true/false da dette ikke
	 * bryter den eksiterende kontrakten. Men i slike tilfeller b�r en heller sette
	 * den gamle metoden til utg�tt/deprecated og heller lage en ny metode med nytt
	 * navn slik at utviklere som benytter denne metoden kan dra nytte av de nye
	 * mulighetene med den nye koden. Men hva tenker du er best? Lage en ny metode
	 * eller beholde den gamle og heller bare kaste en exception i konstrukt�ren?
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
			throw new IllegalArgumentException("startTime kan ikke v�re null");
		} else if (endTime == null) {
			throw new IllegalArgumentException("endTime kan ikke v�re null");
		} else if (startTime.after(endTime)) {
			throw new IllegalArgumentException("startTime m� v�re f�r endTime");
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
