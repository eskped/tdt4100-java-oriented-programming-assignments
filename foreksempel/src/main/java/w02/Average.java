package w02;

public class Average {
	int valueCount = 0;
	double sum = 0;

	public void acceptValue(double value) {
		sum += value; // samme som 'sum = sum + value'
		valueCount++; // samme som 'valueCount += 1' eller 'valueCount = valueCount + 1' 
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
		avg.acceptValue(4);		
		System.out.println(avg.getAverage());
	}
}
