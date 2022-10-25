package inheritance;


public class DebitAccount extends AbstractAccount {
	
	public DebitAccount() {super();}
	
	@Override
	public void internalWithdraw(double amount) {
		if (super.isNegative((this.getBalance() - amount))) {
			throw new IllegalStateException("Du kan ikke ta ut mer enn du har");
		}
	}
	
}
