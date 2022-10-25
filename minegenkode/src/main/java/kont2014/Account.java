package kont2014;

public class Account {

	private int balance = 0;
	private final String accountId;
	private int withdrawLimit;
	private int monthlyLimit;
	
	public Account(String accountId) {
		if (!(accountId instanceof String)) {
			throw new IllegalArgumentException("ID kan kun være en streng");
		}
		if (!accountId.matches("[0-9]+")){
			throw new IllegalArgumentException("ID kan kun være tall i ID-en");
		}
		this.accountId = accountId;
	}
	
	public String getAccountId() {
		return accountId;
	}

	public int getBalance() {
		return balance;
	}

	public void deposit(int amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("Kan ikke sette inn negative penger");
		}
		balance += amount;
	}
	
	public void setWithdrawLimit(int withdrawLimit) {
	    this.withdrawLimit = withdrawLimit;
	}

	public void withdraw(int amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("Kan ikke ta utnegative penger");
		}
		if (balance - amount < 0) {
			throw new IllegalStateException("Du kan ikke ta ut mer penger enn du har");
		}
		if (amount > this.withdrawLimit) {
			throw new IllegalArgumentException("Du kan ikke ta ut mer enn grensen");
		}
		balance -= amount;
	}
}
