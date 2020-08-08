package newbank.server;

public class Account {
	
	private String accountName;
	private double openingBalance;

	public Account(String accountName, double openingBalance) {
		this.accountName = accountName;
		this.openingBalance = openingBalance;
	}
	
	public String toString() {
		return (accountName + ": " + openingBalance);
	}

	/**
	 * makePayment: returns true deducts amount from openingBalance if openingBalance >= amount,
	 * otherwise returns false and does not alter openingBalance.
	 */
	public boolean makePayment(double amount) {
		if (openingBalance >= amount) {
			openingBalance -= amount;
			return true;
		}
		return false;
	}

}
