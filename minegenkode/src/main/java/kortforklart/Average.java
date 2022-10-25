package kortforklart;

public class Average {
	private int valueCount = 0;
	private double sum = 0;
	
	
	public void acceptValue(double value) {
		sum += value;
		valueCount++;
		
	}
	
	public double getAverage() {
		if (valueCount == 0) {
			return 0;
		}
		else {
			return sum / valueCount;
		}
	}
	
	public static void main(String[] args) {
		Average avg = new Average();
		System.out.println(avg.getAverage());
		avg.acceptValue(3);
		avg.acceptValue(5);
		System.out.println(avg.getAverage());
		
	}
}
