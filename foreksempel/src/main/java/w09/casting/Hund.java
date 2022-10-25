package w09.casting;

public class Hund extends Rovdyr {
	public String faktaOmHund() {
		// https://no.wikipedia.org/wiki/Tamhund
		return "Tamhund eller hund (Canis familiaris) er et mellomstort domestisert rovpattedyr i hundefamilien, som gjennom årtusener har fulgt mennesket og bidratt til menneskelig suksess.";
	}
	
	@Override
	public String toString() {
		return "Hund -> " + super.toString();
	}
}
