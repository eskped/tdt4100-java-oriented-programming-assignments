package of4.kode.grunnleggende;

public class SelfServiceCheckout {
		

		@Override
		public String toString() {
			String receipt = 
					"""
					--------------------------------------
					Hva             Pris    MVA     Total
					""";
			
			// TODO: Skriv kode for å printe ut varer og pris
			// Hint: Du kan bruke følgende streng med format-funksjonen:
			
			// "%dx %s\t%.2f\t%.2f\t%.2f"
			
			/* Forklaring: 
			 * %d representerer et heltall
			 * %s representerer en streng
			 * %.2f representerer et flyttall (og runder av til 2 desimaler)
			 * \t representerer tabulator (å trykke på tab)
			 */
			
			receipt += String.format(
					"""
					--------------------------------------
					Total MVA                       %.2f
					Total                           %.2f
					        Takk for at du handlet
					            hos oss i OOP!
					--------------------------------------
					"""
					);
			return receipt;
		}
		
		
		// main-metode for å teste koden
		public static void main(String[] args) {

			/*
			Item tomato = new Item("Tomat", 5, "fruit", "|| ||| | |||| |");
			Item cheese = new Item("Norvegia", 90, "diary", "| | ||||| | |||");
			Item cheese2 = new Item("Norvegia", 90, "diary", "| | ||||| | |||");
			Item tortillas = new Item("Lefser", 15, "taco", " | || | || ||||");
			Item groundMeat = new Item("Kjøttdeig", 29.99, "taco", "|||| || | |||||");
			*/
			
			//SelfServiceCheckout checkout = new SelfServiceCheckout("fri", "passord123");

			/*
			checkout.scanItem(tomato);
			checkout.scanItem(cheese);
			checkout.scanItem(cheese2);
			checkout.scanItem(tortillas);
			checkout.scanItem(groundMeat);
			*/
			
			//System.out.println(checkout);
			
		}

	}

