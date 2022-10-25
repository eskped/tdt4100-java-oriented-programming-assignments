package w02;

public class RandomAverage {
	DownCounter downCounter;
	Random100 random;
	Average average;
	
	public double computeRandomAverage(int count) {
		downCounter = new DownCounter(count);
		random = new Random100();
		average = new Average();
		while (!downCounter.isFinished()) {
			int value = random.getRandom100();
			average.acceptValue(value);
			downCounter.countDown();
		}
		return average.getAverage();
	}
	
	public static void main(String[] args) {
		RandomAverage ra = new RandomAverage();
		System.out.println(ra.computeRandomAverage(10));
	}
}
