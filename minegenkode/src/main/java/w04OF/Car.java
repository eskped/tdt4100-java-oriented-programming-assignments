package w04OF;


public class Car {
	
	private String model;
	private String brand;
	private String regNum;
	private int productionYear;
	private Double kmDriven;
	private Double weight;
	private Double velocity;
	
	
	//to forskjerllige måter å lage konstruktørere
	public Car(String model, String brand, String regNum, int productionYear, double kmDriven, double weight, double velocity) {
		this(model, brand, regNum, productionYear, weight);
		this.kmDriven = kmDriven;
		this.velocity = velocity;
	}
	
	
	public Car(String model, String brand, String regNum, int productionYear , double weight) {
		checkNumberNotNegative(weight);
		if (!checkRegNumber(regNum)) {
			throw new IllegalArgumentException("Ugyldig bilskilt");
		}
		this.model = model;
		this.brand = brand;
		this.regNum = regNum;
		this.productionYear = productionYear;
		this.weight = weight;
	}
	
	public Car() {
		//WW
	}
	
	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}

	
	public void setRegNum(String regNum) {
		if (!checkRegNumber(regNum)) {
			throw new IllegalArgumentException("Ugyldig bilskilt");
		}
		this.regNum = regNum;
	}
	
	public String getRegNum() {
		return regNum;
	}
	

	public int getProductionYear() {
		return productionYear;
	}


	public void setProductionYear(int productionYear) {
		this.productionYear = productionYear;
	}


	public Double getKmDriven() {
		return kmDriven;
	}


	public Double getWeight() {
		return weight;
	}


	public void setWeight(Double weight) {
		this.weight = weight;
	}
	
	public void driveTime(Double minutes) {
		checkNumberNotNegative(minutes);
		this.kmDriven += timeAndVelocityToDistance(minutes);
	}
	
	private Double timeAndVelocityToDistance(double minutes) {
		return this.velocity * (minutes/60);
	}
	
	public void accerlerate1(double velocityChange) {
		checkNumberNotNegative(velocityChange);
		this.velocity += velocityChange;
	}
	
	public void brake(double velocityChange) {
		if(this.velocity - velocityChange < 0) {
			throw new IllegalStateException("Fart blir negativ");
		}
		this.velocity -= velocityChange;
;	}
	
	
	private void checkNumberNotNegative(Double number) {
		if (number < 0) {
			throw new IllegalArgumentException("Tall kan ikke være negativ");
		}
	}
	
	private boolean checkRegNumber(String regNum) {
		return (regNum.length() == 7 && regNum.substring(0,2).matches("[A-Z]+") && regNum.substring(2,7).matches("[0-9+]")) || (regNum.substring(0,7).matches("[0-9+]"));
				
	}
	/*
	@Override
	public String toString() {
		
		//return String.format();
	}
	*/
	
	public static void main(String[] args) {
		
		// Modell, Produsent, Registeringsnummer, Produksjonsår, Kilometerstand, Vekt
		Car car = new Car("S-MAX", "Ford", "AQ12345", 2019, 356.0, 1650.0, 50.0);
		
		System.out.println(car.kmDriven);
		
		car.brake(26.0);
		
		System.out.println(car.kmDriven);
		
		/*
		car.driveDistance(256.0);
		System.out.println(car);
		
		car.accelerate(50);
		car.driveTime(60.0);
		System.out.println(car);
		
		car.brake(60);
		*/
	}
}

