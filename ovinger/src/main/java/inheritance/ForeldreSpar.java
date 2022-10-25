package inheritance;

public class ForeldreSpar extends SavingsAccount{
	
	private int remainingWithdrawals;
	private int originalRemainingWithdrawals;

	
	public ForeldreSpar(double yield, int remainingWithdrawals) {
		super(yield);
		this.remainingWithdrawals = remainingWithdrawals;
		this.originalRemainingWithdrawals = remainingWithdrawals;
	}
	
	public int getRemainingWithdrawals() {
		return this.remainingWithdrawals;
	}
	
	public void withdraw(double amount) {
		if(this.remainingWithdrawals < 1) {
			throw new IllegalStateException("Du har ikke flere uttak igjen");
		}
		super.withdraw(amount);
		this.remainingWithdrawals--;
	}
	
	public void endYearUpdate() {
		super.endYearUpdate();
		this.remainingWithdrawals += this.originalRemainingWithdrawals;
	}
	
	
}
