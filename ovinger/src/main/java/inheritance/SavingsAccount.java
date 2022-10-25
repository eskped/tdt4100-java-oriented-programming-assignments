package inheritance;

public class SavingsAccount implements Account {
	
	double balance;
	double yield;
	
	public SavingsAccount(double yield) {
		if (yield < 0) {
			throw new IllegalArgumentException("renten må være positiv");
		}
		this.balance = 0;
		this.yield = yield;
	}
	
	
	@Override 
	public void deposit(double amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException("Det innsatte beløpet må være positivgt");
		}
		this.balance += amount;
	}

	public void withdraw(double amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException("Det innsatte beløpet må være positivgt");
		}
		if (this.balance < amount) {
			throw new IllegalStateException("Det er ikke dekning på kontoen");
		}
		this.balance -= amount;
	}

	public double getBalance() {
		return this.balance;
	}
	
	public void endYearUpdate() {
		balance += (balance * yield);
	}
	
}
