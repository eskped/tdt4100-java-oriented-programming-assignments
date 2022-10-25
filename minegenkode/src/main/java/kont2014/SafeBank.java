package kont2014;

import java.time.LocalDateTime;
import java.util.HashMap;

public class SafeBank extends Bank {
	
	private HashMap<String,Integer> accounts;
	
	public Integer getMonthlyLimit(String accountId) {
		return accounts.get(accountId);
	}
	
	public void setMonthlyLimit(String accountId, int monthlyLimit) {
		if (monthlyLimit < 0) {
			throw new IllegalArgumentException("Kan ikke sette måendlig beløp til mindre enn 0");
		}
		accounts.put(accountId, monthlyLimit);
	}
	
	public boolean checkMonthlyLimit(String accountId, int withdraw) {
		if (accounts.get(accountId) < withdraw + getTransferSum(super.getAccount(accountId), LocalDateTime.now().getYear(), LocalDateTime.now().getMonthValue())) {
			return false;
		}
		
		return true;
	}
	
}
