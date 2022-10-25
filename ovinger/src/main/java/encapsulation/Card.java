package encapsulation;

public class Card {

	public char Suit;
	public int Face;

	public Card(char Suit, int Face) {
		checkSuit(Suit);
		checkFace(Face);
		this.Suit = Suit;
		this.Face = Face;
		
	}
	
	private void checkSuit(char Suit) {
		if (Suit != 'S' && Suit !='H' && Suit != 'D' && Suit != 'C') {
			throw new IllegalArgumentException("Wrong Suit");
		}
	}
	
	private void checkFace(int Face) {
		if (0 >= Face || Face > 13) {
			throw new IllegalArgumentException("Wrong Face");
		}
	}
	
	public char getSuit() {
		return this.Suit;
	}
	
	public int getFace() {
		return this.Face;
	}
	
	@Override
	public String toString() {
		//return Character.toString(this.Suit) + Integer.toString(this.Face);
		return String.valueOf(this.getSuit()) + this.getFace();
	}
	
	
	public static void main(String[] args) {
		Card d1 = new Card('H',13);
		System.out.println(d1.toString());
	}
}
