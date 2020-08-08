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


	public void addAccount(Account account) {
		accounts.add(account);		
	}

	/**
	 * Returns the first account in the accounts array or null is accounts is empty.
	 */
	public Account getAccount() {
		if (accounts.isEmpty()) {
			return null;
		}

		return accounts.get(0);
	}
}
