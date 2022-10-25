package inheritance;

public class SavingsAccount2 extends AbstractAccount {
	
	int remaningWithdrawals;
	double fee;
	
	public SavingsAccount2(int remaningWithdrawals, double fee) {
		super();
		this.remaningWithdrawals = remaningWithdrawals;
		this.fee = fee;
	}
	
	@Override
	void internalWithdraw(double amount) {
		if (super.isNegative(this.getBalance()-amount)) {
			throw new IllegalStateException("Nå er det negativ saldo på konto");
		}
		
		if (super.isNegative(this.getRemaningWithdrawals())) {
			if (super.isNegative(this.getBalance()-this.getFee() - amount)) {
				throw new IllegalStateException("Nå er det negativ saldo på konto");
			}
			System.out.println("nå kjøerer denne");
			this.balance -= this.getFee();
		}
		this.remaningWithdrawals--;
	}
	
	public int getRemaningWithdrawals() {
		return this.remaningWithdrawals;
	}
	
	public double getFee() {
		return this.fee;
	}
}
