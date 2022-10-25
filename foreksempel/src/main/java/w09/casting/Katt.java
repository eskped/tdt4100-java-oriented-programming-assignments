package w09.casting;

public class Katt extends Rovdyr {
	public String faktaOmKatt() {
		// https://no.wikipedia.org/wiki/Tamkatt
		return "Tamkatt eller huskatt (Felis silvestris catus) er et lite rovpattedyr i kattefamilien. Det er av mange også kjent som katt, pus, pusekatt og kattepus.";
	}
	
	@Override
	public String toString() {
		return "Katt -> " + super.toString();
	}
}
