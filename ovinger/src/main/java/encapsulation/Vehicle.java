package encapsulation;

public class Vehicle {
	
	char vehicleType;
	char fuelType;
	String registrationNumber;
	
	public Vehicle(char vehicleType, char fuelType, String registrationNumber) {
		checkRegistrationNumber(registrationNumber, vehicleType);
		checkVehicleType(vehicleType);
		checkFuelType(fuelType);
		checkFuelTypeVehicleTypeRegistrationNumber(vehicleType,fuelType,registrationNumber);
		
		this.vehicleType = vehicleType;
		this.fuelType = fuelType;
		this.registrationNumber = registrationNumber;
	}
	
	private void checkRegistrationNumber(String registrationNumber, char vehicleType) {
		if (vehicleType == 'C') {
			//sjekker hvis det er en bil
			if (registrationNumber.length() == 7) {
				if (registrationNumber.substring(2,6).matches("[0-9]+")) {
					if (!registrationNumber.substring(0,2).matches("[A-Z]+")) {
						throw new IllegalArgumentException("De første to verdiene må være store bokstaver");
					}
				}
				else {
					throw new IllegalArgumentException("De siste fem inputene må være tall");
				}
			}
			else {
				throw new IllegalArgumentException("Lengden må være 7");
			}
		}
		
		else if (vehicleType == 'M') {
			if (registrationNumber.length() == 6) {
				if (registrationNumber.substring(2,5).matches("[0-9]+")) {
					if (!registrationNumber.substring(0,2).matches("[A-Z]+")) {
						throw new IllegalArgumentException("De første to verdiene må være store bokstaver");
					}
				}
				else {
					throw new IllegalArgumentException("De siste fire inputene må være tall");
				}
			}
			else {
				throw new IllegalArgumentException("Lengden må være 6");
			}
		}
	}
	
	public void checkVehicleType(char vehicleType) {
		if (vehicleType != 'C' && vehicleType != 'M') {
			throw new IllegalArgumentException("Det må være en bil eller motorsykkel");
		}
	}
	
	public void checkFuelType(char fuelType) {
		if (fuelType != 'H' && fuelType != 'E' && fuelType != 'D' && fuelType != 'G') {
			throw new IllegalArgumentException("Feil fuel");
		}
	}
	
	public void checkFuelTypeVehicleTypeRegistrationNumber(char vehicleType, char fuelType, String registrationNumber) {
		if (vehicleType == 'C') {
			if (registrationNumber.length() == 7) {
				if (registrationNumber.contains("EL") || registrationNumber.contains("EK")) {
					if (fuelType != 'E') {
						throw new IllegalArgumentException("Feil");
					}
				}
				else if (registrationNumber.contains("HY")) {
					if (fuelType != 'H') {
						throw new IllegalArgumentException("Feil");
					}
				}
				else {
					if (fuelType == 'E' || fuelType == 'H') {
						throw new IllegalArgumentException("Feil");
					}
				}
			}
			else {
				throw new IllegalArgumentException("Feil"); 
			}
		}
		
		
		if (vehicleType == 'M') {
			if (registrationNumber.length() == 6) {
				if (registrationNumber.contains("EL") || registrationNumber.contains("EK")) {
					if (fuelType != 'E') {
						throw new IllegalArgumentException("Feil");
					}
				}
				
				else if (registrationNumber.contains("HY")) {
					throw new IllegalArgumentException("Feil");
				}
				
				else {
					if (fuelType == 'H' || fuelType == 'E') {
						throw new IllegalArgumentException("Feil");
					}
				}
			}
			else {
				throw new IllegalArgumentException("Feil"); 
			}
		}
	}
	
	public String getRegistrationNumber() {
		return this.registrationNumber;
	}
	
	public void setRegistrationNumber(String registrationNumber) {		
		checkRegistrationNumber(registrationNumber, this.vehicleType);
		checkVehicleType(this.vehicleType);
		checkFuelType(this.fuelType);
		checkFuelTypeVehicleTypeRegistrationNumber(this.vehicleType,this.fuelType,registrationNumber);
		
		this.registrationNumber = registrationNumber;
	}
	
	public char getVehicleType() {
		return vehicleType;
	}
	
	public char getFuelType() {
		return fuelType;
	}
	
	public static void main(String[] args) {		
		//Vehicle bil1 = new Vehicle('C', 'D', "BN12345");
		
		
		//System.out.println(bil1.registrationNumber);
		

	}
}










