package kortforklart;
//Java betyr STATIC?
public class ImeprialToMetricConverter {
	
	
	public static double inchesToCm(double inches) {
		return inches * 2.54;
	}
	
	public static double metersToFeet(double meters) {
		return meters * 0.3;
	}
	
	public static void main(String[] args) {
		
		System.out.println(ImeprialToMetricConverter.metersToFeet(50));
		
		int tall = Integer.parseInt("2");
		System.out.println(tall);
	}
}
