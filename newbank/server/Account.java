package newbank.server;
import java.util.Arrays;

public class Account {
	
	private String accountName;
	private double openingBalance;
	public static String[] accountArray = {"Main","Checking","Savings"};

	public Account(String accountName, double openingBalance) {
		this.accountName = accountName;
		this.openingBalance = openingBalance;

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
