package w09.casting;

public class Lassie extends Hund implements Fiksjon {
	public String faktaOmLassie() {
		// https://no.wikipedia.org/wiki/Lassie
		return "Lassie, en hund av rasen collie, blir av mange regnet som «verdens mest kjente hund». Hunden er en kjent og kjær figur over store deler av verden, fra flere filmer, TV-serier og bøker opp igjennom årene.";
	}
	
	@Override
	public String toString() {
		return "Lassie -> " + super.toString();
	}
}
