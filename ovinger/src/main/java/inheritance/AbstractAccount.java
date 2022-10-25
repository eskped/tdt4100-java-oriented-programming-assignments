package inheritance;

public abstract class AbstractAccount {
	
	protected double balance;
	
	protected void deposit(double amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException("Det innsatte beløpet må være positivt");
		}
		
		this.balance += amount;
	}
	
	protected void withdraw (double amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException("Det innsatte beløpet må være positivgt");
		}
		internalWithdraw(amount);
		this.balance -= amount;
	}
	
	abstract void internalWithdraw(double amount);
	
	protected double getBalance() {
		return this.balance;
	}
	
	public boolean isNegative (double value) {
		return value <= 0;
	}
	
	public AbstractAccount() {
		this.balance = 0;
	}
}
