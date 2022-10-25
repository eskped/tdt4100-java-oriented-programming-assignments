package w03;

public class Tall {
	private String tall;
	int ta = 3;
	int ia[][] = { {1, 2}, null };
	
	public Tall(int tall) {
		super();
		this.setTall(tall);
	}

	public int getTall() {
		return Integer.parseInt(tall);
	}

	public void setTall(int tall) {
		if (tall > 10) {
			throw new IllegalArgumentException(tall + " er for stort.");
		}
		this.tall = Integer.toString(tall);
	}

	public int getQuad() {
		int i = this.getTall();
		return i * i;
	}

	public static void main(String[] args) {
		Tall t = new Tall(4);
		t.setTall(7);
		System.out.println(t.getTall() + " ganger seg selv er " + t.getQuad());
	}
}
