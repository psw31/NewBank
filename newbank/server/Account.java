package newbank.server;

public class Account {
	
	private String accountName;
	private double openingBalance;

	public Account(String accountName, double openingBalance) {
		this.accountName = accountName;
		this.openingBalance = openingBalance;
	}

	public void debit(double amount){
		if(amount > 0){
			this.openingBalance -= amount;
		}
	}

	public void deposit(double amount){
		if (amount >0){
			this.openingBalance +=amount;
		}

	}

	public String toString() {
		return (accountName + ": " + openingBalance);
	}

}

