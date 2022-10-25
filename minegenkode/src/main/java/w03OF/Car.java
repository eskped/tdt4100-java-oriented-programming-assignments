package w03OF;


public class Car {
	
	private String model;
	private String brand;
	private String regNum;
	private int productionYear;
	private Double kmDriven;
	private Double weight;
	
	
	//to forskjerllige måter å lage konstruktørere
	public Car(String model, String brand, String regNum, int productionYear, double kmDriven, double weight) {
		this(model, brand, regNum, productionYear, weight);
		this.kmDriven = kmDriven;
	}
	
	
	public Car(String model, String brand, String regNum, int productionYear , double weight) {
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


	public Double getKmDriven() {
		return kmDriven;
	}


	public void setKmDriven(Double kmDriven) {
		this.kmDriven = kmDriven;
	}


	public Double getWeight() {
		return weight;
	}


	public void setWeight(Double weight) {
		this.weight = weight;
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
		
		car.brake(60);
		*/
	}
}

