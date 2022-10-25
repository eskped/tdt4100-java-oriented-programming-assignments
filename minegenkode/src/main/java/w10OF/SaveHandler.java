package w10OF;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class SaveHandler {

	public final static String SAVE_FOLDER = "src/main/java/w10OF/saves/";
	
	public void save(String filename, Game game) throws FileNotFoundException {
		try (PrintWriter writer = new PrintWriter(getFilePath(filename))) {
			writer.println(game.getWidth());
			writer.println(game.getHeight());
			
			for (int y = 0; y < game.getHeight(); y++) {
				for (int x = 0; x < game.getWidth(); x++) {
					writer.print(game.getTile(x,y).getType());
				}
			}
			writer.println();
		}
	}
	
	public Game load(String filename) throws FileNotFoundException {
		try (Scanner scanner = new Scanner(new File(getFilePath(filename)))) {
			int width = scanner.nextInt();
			int height = scanner.nextInt();
			Game game = new Game(width, height);

			if (scanner.nextBoolean()) {
				game.setGameOver();
			}

			if (scanner.nextBoolean()) {
				game.setGameWon();
			}

			scanner.nextLine();

			String board = scanner.next();
			for (int y = 0; y < height; y++) {
				for (int x = 0; x < width; x++) {
					char symbol = board.charAt(y * width + x);
					game.getTile(x, y).setType(symbol);
				}
			}

			int snakeLength = scanner.nextInt();
			List<Tile> snake = new ArrayList<>();
			for (int i = 0; i < snakeLength; i++) {
				snake.add(game.getTile(scanner.nextInt(), scanner.nextInt()));
			}
			game.createSnake(snake);

			return game;
		}
	}

	

	private static String getFilePath(String filename) {
		return SAVE_FOLDER + filename + ".txt";
	}
	
	
	public static void main(String[] args) throws FileNotFoundException {
		//new SaveHandler().save("oppgave1-test");
		
		
		Game game = new Game(16, 12);
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
		
		SaveHandler handler = new SaveHandler();
		handler.save("oppgave2-main-save", game);
		
		
	}

}
