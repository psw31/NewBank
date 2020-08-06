package newbank.server;

import java.util.ArrayList;

public class Customer {
	
	private ArrayList<Account> accounts;
	
	public Customer() {
		accounts = new ArrayList<>();
	}
	
	public String accountsToString() {
		String s = "";
		for(Account a : accounts) {
			s += a.toString();
		}
		return s;
	}

	public void move(Double amount, Account from, Account to){
		if(amount > 0){
			from.debit(amount);
			to.deposit(amount);
		}
	}

	public void addAccount(Account account) {
		accounts.add(account);		
	}
}
