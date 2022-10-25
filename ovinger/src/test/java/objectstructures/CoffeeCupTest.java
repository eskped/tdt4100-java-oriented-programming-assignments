package objectstructures;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class CoffeeCupTest {
	
	CoffeeCup kopp1 = new CoffeeCup(40.0 , 10.0);
	CoffeeCup kopp2, kopp3;
	CoffeeCup kopp4 = new CoffeeCup(5.0 , 5.0);

	
	@Test
	public void testConstructor() {
		assertEquals(40.0,kopp1.getCapacity());
		assertEquals(10.0,kopp1.getCurrentVolume());
		assertEquals(5.0,kopp4.getCapacity());
		assertEquals(5.0,kopp4.getCurrentVolume());
	
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			kopp2 = new CoffeeCup(0.0 , 10.0);
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			kopp3 = new CoffeeCup(-5.0 , 0.0);
		});
	}

	@Test
	public void TestdrinkCoffee() {
		kopp1.drinkCoffee(5.0);
		assertEquals(5.0,kopp1.getCurrentVolume());
	
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			kopp4.drinkCoffee(6.0);
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		kopp1.drinkCoffee(-4.0);
		});
	}
	
	@Test
	public void TestFillCoffee() {
		kopp1.fillCoffee(10.0);
		assertEquals(20.0 , kopp1.getCurrentVolume());
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			kopp4.fillCoffee(1.0);
		});
	}
	
	@Test
	public void TestIncreaseCupSize() {
		kopp1.increaseCupSize(10.0);
		assertEquals(50.0 , kopp1.getCapacity());
		
		kopp4.increaseCupSize(-100.0);
		assertEquals(5.0 , kopp4.getCapacity() );
	}
}