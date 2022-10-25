package of13.kode;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class GameTest {
	
	
	private Game game;
	
	private void createBoard() {
		game = new Game(16, 12);
        game.getTile(6, 11).setGround();
        game.getTile(7, 11).setGround();
        game.getTile(8, 11).setGround();
        game.getTile(6, 10).setGround();
        game.getTile(7, 10).setGround();
        game.getTile(8, 10).setGround();
        game.getTile(9, 10).setGround();
        game.getTile(6, 9).setGround();
        game.getTile(7, 9).setGround();
        game.getTile(8, 9).setGround();
        game.getTile(9, 9).setGround();
        game.getTile(6, 8).setGround();
        game.getTile(8, 6).setGround();
        game.getTile(10, 6).setGround();
        game.getTile(5, 5).setGround();
        game.getTile(5, 6).setFruit();
        game.getTile(9, 6).setFruit();
        game.getTile(8, 3).setGoal();

        game.createSnake(Arrays.asList(game.getTile(9, 8), game.getTile(8, 8)));
	}
	
	@BeforeEach
	public void setUp() {
		createBoard();
	}
	
	@Test
	public void testConstructor() {
		game = new Game(16, 12);
		
		assertEquals(game.getHeight(), 12);
		assertEquals(game.getWidth(), 16);
		
		for (int y = 0; y < game.getHeight(); y++) {
			for (int x = 0; x < game.getWidth(); x++) {
				assertEquals(game.getTile(x, y).getType(), 'a');
			}
		}
	}
	
	@Test
	public void testCreateSnake() {
		game = new Game(16, 12);
		List<Tile> snake = Arrays.asList(game.getTile(9, 8), game.getTile(8, 8));
		game.createSnake(snake);
		assertEquals(game.getSnake().get(0), game.getTile(9, 8));
		assertEquals(game.getSnake().get(1), game.getTile(8, 8));
		assertEquals(game.getSnake().get(0).getType(), 's');
		assertEquals(game.getSnake().get(1).getType(), 's');
		assertTrue(game.isSnakeHead(game.getTile(9, 8)));
	}
	
}
