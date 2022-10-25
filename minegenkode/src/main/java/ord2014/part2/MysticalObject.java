package ord2014.part2;

public class MysticalObject {
	private int number;

	public MysticalObject(int number) {
		this.number = number;
	}

	public void step() {
		number = -(number - (int) Math.signum(number));
	}

	public int getNumber() {
		return number;
	}
}
