package encapsulation;

public class Account {

	
	private double balance;
	private double interestRate;
	
	
	public Account(double balance, double interesertRate) {
		if (checkPositiveValue(balance)) {
			if (checkPositiveValue(interesertRate)) {
				this.balance = balance;
				this.interestRate = interesertRate;
			}
			else {
				throw new IllegalArgumentException("Ikke positivt tall");
			}
		}
		else {
			throw new IllegalArgumentException("Ikke positivt tall");
		}
	}
	
	public void deposit(double money) {
		if (checkPositiveValue(money)) {
			this.balance += money;
		}
		else {
			throw new IllegalArgumentException("Ikke positivt tall");
		}
	}
	
	public void addInterest() {
		this.balance += this.balance * (this.interestRate)/100;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public double getInterestRate() {
		return this.interestRate;
	}
	
	public void setInterestRate(double newRate) {
		if (checkPositiveValue(newRate)) {
			this.interestRate = newRate;
		}
		else {
			throw new IllegalArgumentException("Ikke positivt tall");
		}
	}
	
	public void withdraw(double amount) {
		if (!checkPositiveValue(amount)) {
			throw new IllegalArgumentException("Ikke positivt tall");
		}
		
		if (balance-amount < 0) {
			throw new IllegalArgumentException("Du kan ikke ta ut mer enn beløp på konto");
		}
		else {
			balance -= amount;
		}
	}
	
	private boolean checkPositiveValue (double value) {
		if (value >= 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "På kontoen er det nå " + balance + "kr og renten er " + interestRate + "%";
	}
	
	public static void main(String[] args) {
		
		Account account1 = new Account(100.0,5.0);
		
		account1.deposit(100.0);
		account1.setInterestRate(3.0);
		
		account1.addInterest();
		
		
		System.out.println(account1.getBalance());
		System.out.println(account1.getInterestRate());
		
		account1.setInterestRate(4.0);
		account1.deposit(100.0);
				
		
		System.out.println(account1.getBalance());
		System.out.println(account1.getInterestRate());
		
		System.out.println(account1);
		
		
	}
}
