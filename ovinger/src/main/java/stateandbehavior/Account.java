package stateandbehavior;

public class Account {
	
	private int balance;
	private int interestRate;
	
	
	public Account() {
		/*
		 * Double balance, Double interestRate
		 * this.balance = balance;
		this.interestRate = interestRate;*/
	}
	
	public void deposit(int money) {
		if (money > 0) {
			this.balance += money;
		}
	}
	
	public void addInterest() {
		int interest = this.balance * (this.interestRate)/100;
		this.balance += interest;
	}
	
	public int getBalance() {
		return this.balance;
	}
	
	public int getInterestRate() {
		return this.interestRate;
	}
	
	public void setInterestRate(int newRate) {
		this.interestRate = newRate;
	}
	
	@Override
	public String toString() {
		return "På kontoen er det nå " + balance + "kr og renten er " + interestRate + "%";
	}
	
	public static void main(String[] args) {
		
		Account account1 = new Account();
		
		account1.deposit(100);
		account1.setInterestRate(3);
		
		account1.addInterest();
		
		
		System.out.println(account1.getBalance());
		System.out.println(account1.getInterestRate());
		
		account1.setInterestRate(4);
		account1.deposit(100);
				
		
		System.out.println(account1.getBalance());
		System.out.println(account1.getInterestRate());
		
		System.out.println(account1);
		
		
	}
	
}
