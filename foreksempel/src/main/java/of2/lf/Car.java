package of2.lf;

public class Car {

	private String model;
	private String brand;
	private String regNum;
	private int productionYear;
	private double kmDriven;
	private double weight;
	private double velocity = 0.0;
	
	public Car(String model, String brand, String regNum, int productionYear, double kmDriven, double weight) {
		  this.model = model;
		  this.brand = brand;
		  this.regNum = regNum;
		  this.productionYear = productionYear;
		  this.kmDriven = kmDriven;
		  this.weight = weight;
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

	public String getRegNum() {
		return regNum;
	}

	public void setRegNum(String regNum) {
		this.regNum = regNum;
	}

	public int getProductionYear() {
		return productionYear;
	}

	public void setProductionYear(int productionYear) {
		this.productionYear = productionYear;
	}

	public double getKmDriven() {
		return kmDriven;
	}

	public void setKmDriven(double kmDriven) {
		this.kmDriven = kmDriven;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getVelocity() {
		return velocity;
	}
	
	public void setVelocity(double velocity) {
		this.velocity = velocity;
	}
	
	
	public static void main(String[] args) {
		
		// Modell, Produsent, Registeringsnummer, Produksjonsår, Kilometerstand, Vekt
		
		Car car = new Car("S-MAX", "Ford", "AQ12345", 2019, 356.0, 1650.0);
		
		System.out.println(car);
		/*
		car.driveDistance(256.0);
		System.out.println(car);

		car.accelerate(50);
		car.driveTime(60.0);
		System.out.println(car);
		
		car.brake(60);*/
		
	}
}
