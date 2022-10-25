package of4.lf.viderekommen;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class SelfServiceCheckout {
	
	// Konstanter - del 1
	public static final Collection<String> days = Arrays.asList("mon", "tue", "wed", "thu", "fri", "sat", "sun");
	
	
	// Felter / Tilstand - del 1
	private String day;
	private List<Item> shoppingCart;
	private boolean adminMode;
	private String password;
	
	
	// Konstruktør - del 3
	public SelfServiceCheckout(String day, String password) {
		validateDay(day);
		validatePassword(password);
		this.day = day;
		this.password = password;
		this.adminMode = false;
		this.shoppingCart = new ArrayList<>();
	}
	
	
	// Setter med validering - del 3
	public void setShoppingCart(List<Item> shoppingCart) {
		if (!this.adminMode) {
			throw new IllegalStateException("Illegal operation");
		}
		this.shoppingCart = new ArrayList<>(shoppingCart);
	}
	

	// Aktiver admin-modus - del 3
	public void activateAdminMode(String password) {
		if (this.adminMode) {
			throw new IllegalStateException("Illegal operation");
		}
		if (this.password.equals(password)) {
			this.adminMode = true;
		} else {
			throw new IllegalArgumentException("Wrong password, permission denied");
		}
	}
	
	
	// Scanne varer - del 4
	public void scanItem(Item item) {
		this.shoppingCart.add(item);
	}
	
	public void scanItems(List<Item> shoppingCart) {
		for (Item i : shoppingCart) {
			scanItem(i);
		}
	}
	
	
	// Valideringsmetoder - del 2
	private void validateDay(String day) {
		if (!days.contains(day)) {
			throw new IllegalArgumentException("Invalid weekday");
		}
	}
	
	private boolean validatePassword(String password) {
		return password.matches("^(?=.*[0-9])(?=.*[a-zA-Z]).{6,10}$");
	}

	
	// Hjelpemetoder - del 5-8
	
	// Del 5
	private double getRebateForItem(Item item) {
		if (!item.getCategory().equals("taco")) {
			return 0.0;
		}
		return switch(day) {
		    case "fri", "sat" -> 0.30;
		    case "wed" -> 0.10;
		    default -> 0.0; 
		};
	}
	
	private double getPriceForItem(Item item) {
		return item.getPrice() - (item.getPrice()*this.getRebateForItem(item));
	}

	
	// Del 6
	private double getMVAForItem(Item item) {
		return this.getPriceForItem(item)*0.15;
	}

	private double getPriceWithoutMVAForItem(Item item) {
		return this.getPriceForItem(item)-this.getMVAForItem(item);
	}
	

	// Del 7
	private double getTotalPriceForCart() {
		double sum = 0;
		for (Item item : shoppingCart) {
			sum += this.getPriceForItem(item);
		}
		return sum;
	}

	private double getTotalMVAForCart() {
		double totalMVA = 0;
		for (Item item : shoppingCart) {
			totalMVA += this.getMVAForItem(item);
		}
		return totalMVA;
	}

	// Del 9
	private int getNumberOfEqualItemsInCart(String barcode) {
		int equalItems = 0;
		for (Item item : shoppingCart) {
			if (item.getBarcode().equals(barcode)) {
				equalItems++;
			}
		}
		return equalItems;
	}
	
	
	// Tekstrepresentasjon / kvittering - del 8-9
	
	@Override
	public String toString() {
		List<String> uniqueBarcodes = new ArrayList<>();
		String receipt = 
				"""
				--------------------------------------
				Hva             Pris    MVA     Total
				""";
		for (Item item : shoppingCart) {
			// ArrayList.contains bruker object.equals internt,
			// Som gjør at vi sammenligner strenger på riktig måte
			if (!uniqueBarcodes.contains(item.getBarcode())) {
				int count = this.getNumberOfEqualItemsInCart(item.getBarcode());
				receipt += String.format(
						"""
						%dx %s\t%.2f\t%.2f\t%.2f
						""", 
						count,
						item.getName(),
						this.getPriceWithoutMVAForItem(item),
						this.getMVAForItem(item),
						this.getPriceForItem(item)*count
						);
				uniqueBarcodes.add(item.getBarcode());
			}
		}
		receipt += String.format(
				"""
				--------------------------------------
				Total MVA                       %.2f
				Total                           %.2f
				        Takk for at du handlet
				            hos oss i OOP!
				--------------------------------------
				""",
				this.getTotalMVAForCart(),
				this.getTotalPriceForCart()
				);
		return receipt;
	}
	
	
	// main-metode for å teste koden
	public static void main(String[] args) {
		
		Item tomato = new Item("Tomat", 5, "fruit", "|| ||| | |||| |");
		Item cheese = new Item("Norvegia", 90, "diary", "| | ||||| | |||");
		Item cheese2 = new Item("Norvegia", 90, "diary", "| | ||||| | |||");
		Item tortillas = new Item("Lefser", 15, "taco", " | || | || ||||");
		Item groundMeat = new Item("Kjøttdeig", 29.99, "taco", "|||| || | |||||");

		SelfServiceCheckout checkout = new SelfServiceCheckout("thu", "passord123");

		checkout.scanItem(tomato);
		checkout.scanItem(cheese);
		checkout.scanItem(cheese2);
		checkout.scanItem(tortillas);
		checkout.scanItem(groundMeat);
		
		System.out.println(checkout);
	
		checkout.activateAdminMode("passord123");
		// Her skrev jeg List.of i ØF. Denne metoden og Arrays.asList
		// Er veldig like, men har noen forskjellige egenskaper.
		// Forklaring på forskjellene kan du finne her: 
		// https://stackoverflow.com/questions/46579074/what-is-the-difference-between-list-of-and-arrays-aslist
		checkout.setShoppingCart(Arrays.asList(new Item("Toalettpapir", 29.99, "hygienic", "|||| ||| || |||")));
		
		System.out.println(checkout);
		
	}

}
