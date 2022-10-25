package kont2014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bank {
	SafeBank safeBank;
	
	private Collection<Account> accounts;
	private Collection<Transaction> transactions;
	
	public void addAccount(Account account) {
		if (accounts == null) {
			accounts = new ArrayList<>();
		}
		if (!accounts.contains(account)) {
			accounts.add(account);
		}
	}
	
	public Account createAccount() {
		String accountId1 = createRandomAccountId();
		boolean bool = true;
		while (bool) {
			bool = false;
			for (Account account : accounts) {
				if (account.getAccountId().equals(accountId1)) {
					bool = true;
				}
			}
			accountId1 = createRandomAccountId();
		}
		Account account1 = new Account(accountId1);
		addAccount(account1);
		return account1;
	}
	
	public void transfer(Account source, Account target, int amount) {
		try {
			source.withdraw(amount);
			target.deposit(amount);
		} catch (Exception e) {
			throw new IllegalArgumentException(e.getMessage());
		}
		
		
		if (transactions == null) {
			transactions = new ArrayList<>();
		}
		
		transactions.add(new Transaction(source, target, amount, LocalDateTime.now()));
	}
	
	protected void checkTransaction(Transaction transaction) {
		if (!accounts.contains(transaction.getSource()) || !accounts.contains(transaction.getTarget())) {
			throw new IllegalArgumentException("En av kontoene finnes ikke i bnken");
		}
		
	}
	
	
	protected String createRandomAccountId() {
		Random random = new Random();
		String s = "";
		
		for (int i = 0; i < 11; i++) {
			s += String.valueOf(random.nextInt(9));
		}
		return s;
	}
	
	public int getTransferSum(Account account, int year, int month) {
		return transactions.stream()
				.filter(t -> t.getSource().getAccountId().equals(account.getAccountId()))
				.filter(t -> t.getDate().getMonth().getValue() == month && t.getDate().getYear() == year)
				.map(t -> t.getAmount())
				.collect(Collectors.summingInt(Integer::intValue));
	}
	
	protected Account getAccount(String accountId) {
		return (Account) accounts.stream().filter(a -> a.getAccountId().equals(accountId));
	}
	
	public void doTransactions(InputStream input) {
		Scanner scanner = new Scanner(input);
		try  {
			while(scanner.hasNextLine()) {
			     String[] line = scanner.nextLine().split(":"); //har valgt formatet 1:2:150
			     transfer(getAccount(line[0]), getAccount(line[1]), Integer.valueOf(line[2]));
			}
		} catch (Exception e) {
			
		}
		scanner.close();
	}
}






