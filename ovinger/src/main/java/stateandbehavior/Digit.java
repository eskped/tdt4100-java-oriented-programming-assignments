package stateandbehavior;

public class Digit {
	
	int base;
	int digit;
	private String digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public Digit(int numberSystem) {
		this.base = numberSystem;
		this.digit = 0;
	}
	
	public int getValue() {
		return this.digit;
	}
	
	public boolean increment() {
		this.digit++;
		if(this.digit == this.base) {
			digit = 0;
			return true;
		}
		else {
			return false;
		}
	}
	
	public int getBase() {
		return this.base;
	}
	
	@Override
	public String toString() {
		return Character.toString(digits.charAt(digit));
		
	}
	
	public static void main(String[] args) {
		
	}
}
