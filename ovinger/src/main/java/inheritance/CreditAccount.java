package inheritance;

public class CreditAccount extends AbstractAccount {
	
	public double creditLine;
	
	public CreditAccount(double creditLine) {
		super();
		this.creditLine = creditLine;
	}
	
	@Override
	void internalWithdraw(double amount) {
		if (super.isNegative(this.getBalance()+this.getCreditLine()-amount)) {
			throw new IllegalStateException("Du kan ikke ta ut mer enn du har");
		}
	}
	
	public double getCreditLine() {
		return this.creditLine;
	}
	
	public void setCreditLine(double creditLine) {
		if (super.isNegative(creditLine)) {
			throw new IllegalArgumentException("Den nye kredittlinjene må være positiv");
		}
		if (super.isNegative(this.getBalance()+creditLine)) {
			throw new IllegalStateException("Den nye kredittlinjen må passe beløpet");
		}
		this.creditLine = creditLine;
	}
	
}
