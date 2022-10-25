package w11.egenfg;

/*
 * Dette er et eksempel på implementasjon av Trippel, der en
 * returnerer summen av de som finnes.
 */
public class TrippelSumFG implements Trippel {
	@Override
	public int beregn(int a, int b, int c) {
		return a + b + c;
	}
}
