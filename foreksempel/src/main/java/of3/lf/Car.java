package of3.lf;

public class Car {

	/* 
	 * 
	 * NB!! Dette er koden som ble skrevet i viderekommen parallell.
	 * Dere som følger grunnleggende parallell vil ikke ha gått gjennom
	 * eksakt de samme oppgavene.
	 * 
	 */
	
	
	// Felter / intern tilstand:
	
	private String model;
	private String brand;
	private String regNum;
	private int productionYear;
	private double kmDriven;
	private double weight;
	private double velocity = 0.0;
	private double maxVelocity;

	
	// Konstruktører:
	
	public Car(String model, String brand, String regNum, int productionYear, double weight) {
		checkNumberNotNegative(productionYear);
		checkNumberNotNegative(weight);
		if (!checkRegistrationNumber(regNum)) {
			throw new IllegalArgumentException("Ugyldig bilskilt!");
		}
		this.model = model;
		this.brand = brand;
		this.regNum = regNum;
		this.productionYear = productionYear;
		this.weight = weight;
		this.kmDriven = 0;
	}
	
	public Car(String model, String brand, String regNum, int productionYear, double weight, double kmDriven) {
		this(model, brand, regNum, productionYear, weight);
		checkNumberNotNegative(kmDriven);
		this.kmDriven = kmDriven;
	}
	
	public Car(String model, String brand, String regNum, int productionYear, double weight, double kmDriven, double maxVelocity) {
		this(model, brand, regNum, productionYear, weight, kmDriven);
		checkNumberNotNegative(maxVelocity);
		this.maxVelocity = maxVelocity;
	}

	
	// Getters:
	
	public double getVelocity() {
		return velocity;
	}

	public String getModel() {
		return model;
	}

	public String getBrand() {
		return brand;
	}

	public String getRegNum() {
		return regNum;
	}

	public int getProductionYear() {
		return productionYear;
	}

	public double getKmDriven() {
		return kmDriven;
	}

	public double getWeight() {
		return weight;
	}

	
	// Setters og andre metoder for å endre tilstand:
	
	public void driveDistance(double km) {
		checkNumberNotNegative(km);
		this.kmDriven += km;
	}
	
	public void driveTime(double minutes) {
		checkNumberNotNegative(minutes);
		this.kmDriven += timeAndVelocityToDistance(minutes);
	}
	
	public void accelerate(double velocityChange) {
		checkNumberNotNegative(velocityChange);
		if (!isVelocityValid(velocity + velocityChange)) {
			throw new IllegalStateException();
		}
		velocity += velocityChange;
	}
	
	public void brake(double velocityChange) {
		if (velocityChange < 0) {
			throw new IllegalArgumentException();
		}
		/* Dette er koden som ble skrevet her i forelesningen:
		
		if (velocity - velocityChange < 0) {
			throw new IllegalStateException();
		}
		
		Denne blir erstattet av denne generelle valideringsmetoden
		som sjekker om farten er over 0 og ikke høyere enn maxVelocity: */
		if (!isVelocityValid(velocity - velocityChange)) {
			throw new IllegalStateException("Fart kan ikke være under 0!");
		}
		velocity -= velocityChange;
	}

	public void setRegNum(String regNum) {
		if (!checkRegistrationNumber(regNum)) {
			throw new IllegalArgumentException("Ugyldig bilskilt!");
		}
		this.regNum = regNum;
	}
	
	
	// Hjelpemetoder:
	
	private double timeAndVelocityToDistance(double minutes) {
		return (minutes/60) * velocity;
	}
	
	
	// Valideringsmetoder:
	
	private void checkNumberNotNegative(double number) {
		if (number < 0) {
			throw new IllegalArgumentException("Tallet kan ikke være negativ!");
		}
	}
	
	// Denne hører til oppgave 4 (som vi ikke rakk gjennom)
	private boolean isVelocityValid(double velocity) {
		return velocity >= 0 && velocity <= this.maxVelocity;
	}
	
	// Her glemte jeg å nevne i ØF at regex-koden [A-Z] kun tillater store bokstaver@
	// (som spesifisert i oppgaven)
	private boolean checkRegistrationNumber(String regNum) {
		return regNum.length() == 7 && regNum.substring(0, 2).matches("[A-Z]+") && (regNum.substring(2, 7).matches("[A-Z]+") || regNum.substring(2, 7).matches("[0-9]+"));
	}
	
	
	// Tekstrepresentasjon:
	
	@Override
	public String toString() {
		return String.format(
				"""
				Modell: %s
				Produsent: %s
				Kilometerstand: %s kilometer
				Nåværende hastighet: %s
				Produksjonsår: %s
				Vekt: %s
				""", 
				this.model,
				this.brand,
				this.kmDriven,
				this.velocity,
				this.productionYear,
				/* Her gjorde jeg en feil i forelesningen og
				 * la inn "this.kmDriven" to ganger */
				this.weight
				);
	}

	
	// Main-metode / testkode:
	
	public static void main(String[] args) {
		Car car = new Car("S-MAX", "Ford", "AQ12345", 2019, 356.0, 1650.0, 100);
		System.out.println(car);
		
		car.driveDistance(256.0);
		System.out.println(car);

		car.accelerate(50);
		car.driveTime(60.0);
		System.out.println(car);
	
		car.brake(40);
		
		car.driveDistance(20.0);
		System.out.println(car);
		
		// Teste diverse registreringsnumre
		car.setRegNum("ELABCDE");
		
		car.setRegNum("BATMANN");
		
		car.setRegNum("EL12345");
		
		
	}

}
