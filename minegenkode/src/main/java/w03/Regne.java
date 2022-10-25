package w03;

//import java.util.List;

public class Regne {
	int a, b;
	
	public Regne(int aa, int b) {
		super();
		a = aa;
		this.b = b;
	}
	
	public int gang() {
		return a * b;
	}
	
	public int pluss() {
		return a + b;
	}
	
	public static void main(String[] args) {
		System.out.println("Første objekt");
		Regne r = new Regne(3,5);
		System.out.println(String.format("Tallene er a=%d og b=%d", r.a,r.b));
		System.out.println(String.format("Gang: \t%d*%d=%d", r.a,r.b, r.gang()));
		System.out.println(String.format("Pluss: \t%d+%d=%d", r.a,r.b, r.pluss()));

		System.out.println("");
		
		System.out.println("Andre objekt");
		Regne r2 = new Regne(6,7);
		System.out.println(r2);
		
		
	}
}
