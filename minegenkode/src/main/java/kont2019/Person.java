package kont2019;

public class Person {
	
	
	private double personalRebate;
	
	/**
	 * Withdraws the provided amount from this person's account. If the transaction
	 * couldn't be completed, i.e. no money was actually withdrawn, one of the
	 * indicated exceptions will be thrown.
	 * 
	 * @param amount the amount to withdraw
	 * @throws IllegalArgumentException
	 * @throws IllegalStateException
	 */
	public void withdraw(double amount) throws IllegalArgumentException, IllegalStateException {
		// ...
	}
	
	public void setPersonalRebate(double pr) {
		this.personalRebate = pr;
	}
	
	public double getPersonalRebate() {
		return personalRebate;
	}
	

}
