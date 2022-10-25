package debugging;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import objectstructures.CoffeeCup;

class CoffeeCupTest {

	CoffeeCup kopp1 = new CoffeeCup(40.0 , 10.0);
	CoffeeCup kopp2 = new CoffeeCup();
	CoffeeCup kopp3 = new CoffeeCup(40.0 , 10.0);
	CoffeeCup kopp4 = new CoffeeCup(0.0 , 0.0);

	
	@Test
	public void testConstructor() {
		assertEquals(40.0,kopp1.getCapacity());
		assertEquals(10.0,kopp1.getCurrentVolume());
		assertEquals(0.0,kopp4.getCapacity());
		assertEquals(0.0,kopp4.getCurrentVolume());
	}
}
