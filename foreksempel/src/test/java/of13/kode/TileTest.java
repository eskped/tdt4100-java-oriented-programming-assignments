package of13.kode;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;




public class TileTest {
	
	private Tile tile;
	
	@BeforeEach
	public void serUp() {
		tile = new Tile(0, 0);
	}
	
	@Test
	public void testSetValidType() {
		tile.setType('a');
		assertTrue(tile.isAir());
		tile.setType('s');
		assertTrue(tile.isSnake());
	}
	
	@Test
	@DisplayName("Test at det kastes unntak hvis man gir ugldige Tile-verdier")
	public void testInvalidType() {
		assertThrows(
				IllegalArgumentException.class,
				() -> tile.setType('?'),
				"IllegalArgumentException skal kastes når man setter Til til en ugyldig verdi"
		);
	}
	
	
}
