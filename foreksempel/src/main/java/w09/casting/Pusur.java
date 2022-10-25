package w09.casting;

public class Pusur extends Katt implements Fiksjon {
	public String faktaOmPusur() {
		// https://no.wikipedia.org/wiki/Pusur
		return "Pusur eller Garfield er en tegneseriefigur skapt av Jim Davis. Serien er en humoristisk avisserie som utgis som dagsstriper og søndagssider, men har i ettertid blitt til film.";
	}
	
	@Override
	public String toString() {
		return "Pusur -> " + super.toString();
	}
}
