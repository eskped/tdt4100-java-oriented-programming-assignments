package inheritance;


public class BSU extends SavingsAccount{
	
	public double amountLastYear;
	public double yield;
	public double maxAmountPerYear;

	
	public BSU(double yield, double maxAmountPerYear) {
		super(yield);
		this.maxAmountPerYear = maxAmountPerYear;
		this.amountLastYear = 0;
	}
	
	
	public double getTaxDeduction() {
		return amountLastYear * 0.2;
	}
	
	
	public void deposit(double amount) {
		if (amount > this.maxAmountPerYear || (this.amountLastYear + amount) >this.maxAmountPerYear) {
			throw new IllegalStateException("Du kan ikke sette inn mer penger enn maksgrensen" + amount + amountLastYear);
		}
		
		this.amountLastYear += amount;
		super.deposit(amount);
	}
	
	public void endYearUpdate() {
		this.amountLastYear = 0;
		super.endYearUpdate();
	}
	
	public void withdraw(double amount) {
		if ((this.maxAmountPerYear < (amount + this.amountLastYear)) || (amount > this.amountLastYear)) {
			throw new IllegalStateException("Du kan ikke ta ut mer enn " + maxAmountPerYear + " per år");
		}
		super.withdraw(amount);
	}
	
//	public static void main(String[] args) {
//		BSU bsu = new BSU(0.05, 25000.0);
//		bsu.deposit(10000.0);
//		System.out.println(bsu.getBalance());
//		assertEquals(10000.0, bsu.getBalance(), epsilon, "Saldoen på kontoen ble feil");
	

}
