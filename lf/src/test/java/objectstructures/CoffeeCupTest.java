package objectstructures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CoffeeCupTest {
	private CoffeeCup cup;

	@BeforeEach
	public void setup() {
		cup = new CoffeeCup();
	}

	@Test
	public void testEmptyConstructor() {
		assertEquals(cup.getCapacity(), 0, 0, "Tom konstruktør lagde ikke kaffekopp med 0 i kapasitet");
		assertEquals(cup.getCurrentVolume(), 0, 0, "Tom konstruktør lagde ikke tom kaffekopp");
	}

	@Test
	public void testConstructor() {
		cup = new CoffeeCup(10, 5);
		assertEquals(cup.getCapacity(), 10, 1e-9);
		assertEquals(cup.getCurrentVolume(), 5, 1e-9);
	}

	@Test
	public void testInvalidInstantiation() {
		assertThrows(IllegalArgumentException.class, () -> {
			cup = new CoffeeCup(10, 15);
		}, "Skal ikke kunne lage en kopp med mer kaffe enn kapasitet");
	}

	@Test
	public void testIncreaseCupSize() {
		assertEquals(cup.getCapacity(), 0, 1e-9);
		cup.increaseCupSize(-5);
		assertEquals(cup.getCapacity(), 0, 1e-9);
		cup.increaseCupSize(100);
		assertEquals(cup.getCapacity(), 0, 100);
	}

	@Test
	public void testDrinkNegativeAmount() {
		assertThrows(IllegalArgumentException.class, () -> {
			cup.drinkCoffee(-5);
		}, "Skal ikke kunne drikke negativ mengde kaffe");
	}

	@Test
	public void testDrinkAboveCapacity() {
		assertThrows(IllegalArgumentException.class, () -> {
			cup.increaseCupSize(50);
			cup.drinkCoffee(60);
		}, "Skal ikke være lov å drikke mer kaffe enn det er");
	}

	@Test
	public void testDrinkReducesCurrentVolume() {
		cup.increaseCupSize(50);
		cup.fillCoffee(45);
		cup.drinkCoffee(10);
		assertEquals(cup.getCurrentVolume(), 35, 1e-9);
	}

	@Test
	public void testFillCoffee() {
		cup.increaseCupSize(10);
		cup.fillCoffee(5);
		assertEquals(cup.getCurrentVolume(), 5, 1e-9);
		cup.fillCoffee(5);
		assertEquals(cup.getCurrentVolume(), 10, 1e-9);
	}

	@Test
	public void testSpillCoffee() {
		assertThrows(IllegalArgumentException.class, () -> {
			cup.increaseCupSize(10);
			cup.fillCoffee(20);
		}, "Skal ikke være lov å fylle mer kaffe enn det er plass til");
	}
}
