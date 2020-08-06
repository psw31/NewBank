package newbank.server;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;

public class NewBank {
	
	private static final NewBank bank = new NewBank();
	private HashMap<String,Customer> customers;
	
	private NewBank() {
		customers = new HashMap<>();
		addTestData();
	}
	
	private void addTestData() {
		Customer bhagy = new Customer();
		bhagy.addAccount(new Account("Main", 1000.0));
		customers.put("Bhagy", bhagy);
		
		Customer christina = new Customer();
		christina.addAccount(new Account("Savings", 1500.0));
		customers.put("Christina", christina);
		
		Customer john = new Customer();
		john.addAccount(new Account("Checking", 250.0));
		customers.put("John", john);
	}
	
	public static NewBank getBank() {
		return bank;
	}
	
	public synchronized CustomerID checkLogInDetails(String userName, String password) {
		if(customers.containsKey(userName)) {
			return new CustomerID(userName);
		}
		return null;
	}

	// commands from the NewBank customer are processed in this method
	public synchronized String processRequest(PrintWriter consprint,
											  CustomerID customer, String request) {

		if (customers.containsKey(customer.getKey())) {
			if (request.equals("SHOWMYACCOUNTS")) {
				consprint.println("SHOWMYACCOUNTS DONE");
				return showMyAccounts(customer);
			} else if(request.equals("MOVE")) {
				consprint.println("SHOWMYACCOUNTS DONE");
				return move(); // not finished yet
			} else{
				return "FAIL";
			}
		}
		return "FAIL";
	}

	private String showMyAccounts(CustomerID customer) {
		return (customers.get(customer.getKey())).accountsToString();
	}

	private String moveMoney(Double amount, Account from, Account to){

	}
}

