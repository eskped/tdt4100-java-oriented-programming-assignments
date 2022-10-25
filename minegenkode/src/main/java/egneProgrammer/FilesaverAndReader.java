package egneProgrammer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FilesaverAndReader {
	private List<Car> cars = new ArrayList<>();
	
	public void addCar(Car car) {
		cars.add(car);
	}
	
	public void writeCarsToFile(String filename) {
		try {
			PrintWriter writer = new PrintWriter(filename);
			for (Car car : cars) {
				writer.println(car.getName());
			}
			writer.flush();
			writer.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public  void getCarsFromFile (String filename) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(filename));
		
		while(scanner.hasNextLine()) {
			String line = scanner.nextLine();
			//String[] lineInfo = line.split("."); hvis det er mer info på hver linje separert med .
			
			Car car = new Car(line);
			this.addCar(car);
		}
		scanner.close();
	}
	
	
	
	
	public static void main(String[] args) {
		FilesaverAndReader test = new FilesaverAndReader();
		try {
			test.getCarsFromFile("carList.txt");
		} catch (FileNotFoundException e) {
			System.out.println("Filen finnes ikke");
		}
	}
}






