package kont2014;

import java.time.LocalDateTime;

public class Transaction {
	private final Account source;
	private final Account target;

	private final int amount;

	private final LocalDateTime date;
	
	public Transaction(final Account source, final Account target, final int amount, final LocalDateTime date) {
		this.source = source;
		this.target = target;
		this.amount = amount;
		this.date = date;
	}
	
	public Account getSource() {
		return source;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public LocalDateTime getDate() {
		return date;
	}
	
	public Account getTarget() {
		return target;
	}
}
