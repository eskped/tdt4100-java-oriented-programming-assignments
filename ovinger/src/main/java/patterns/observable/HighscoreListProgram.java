package patterns.observable;

public class HighscoreListProgram implements HighscoreListListener{
	
	
	HighscoreList HL;
	
	
	public void init() {
		System.out.println("kjer noe?");
		HL = new HighscoreList(10);
		HL.addHighscoreListListener(this);
		run();
		
	}
	
	
	public void run() {
		
		HL.addResult(7);
		HL.addResult(1);
		HL.addResult(42);
		HL.addResult(33);
	}

	@Override
	public void listChanged(HighscoreList hL, int i) {
		System.out.println(hL.toString() + " og endres på plass" + i);
		
	}
	
	public static void main(String[] args) {

	}
	
}
