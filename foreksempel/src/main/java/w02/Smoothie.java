package w02;

public class Smoothie {
	public static void main(String[] args) {
		Frukt f_1 = new Frukt("Agurk", 0.3);
		Frukt f_2 = new Frukt("L�k", 0.0002);
		Frukt f_3 = new Frukt("Jordb�r", 12);
		
		double antall = f_1.getAntall()+f_2.getAntall()+f_3.getAntall();
		System.out.println("Vi har en smoothie med "+antall+" ting inni.");
		System.out.println("Ser dere forresten at det som er inni main() i Frukt aldri blir kj�rt?");
		System.out.println("I stedet er det denne som kj�res.");
		System.out.println("Som dere ser kan en faktisk ha en klasse som bare har en main-metode.");
	}
}
