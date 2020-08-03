package newbank.server;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;

public class NewBank {

	private static final NewBank bank = new NewBank();
	private HashMap<String, Customer> customers;

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
		if (customers.containsKey(userName)) {
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
			}
			else if (request.contains("DEPOSIT")){
				//split request and cast amount to double
				consprint.println("LOAN DONE");
				return depositMoney (customer);

			}
			else if (request.contains("NEWACCOUNT")){
				return newAccount(customer, request);

			}
			else if (request.contains("LOANS")){
				System.out.println("LOAN DONE");

			}
			else{
				return "FAIL";
			}
		}
		return "FAIL";
	}

	private String showMyAccounts(CustomerID customer) {
		return (customers.get(customer.getKey())).accountsToString();
	}

	private String depositMoney(//Double amount,
							   CustomerID customer
							   //newbank.server.Customer customer
	){
		//customer.put(amount, bhagy);
		//customers.get((customer.getKey())).deposit(amount);
		return (customers.get(customer.getKey())).accountsToString();
	}


	private String newAccount(CustomerID customer, String request) {
		String[] requestArray = request.split(" ");
		String req = requestArray[0];
		String acc = requestArray[1];
		if (Arrays.asList(Account.accountArray).contains(acc)){
			if (!customers.get(customer.getKey()).accountsToString().contains(acc)){
				(customers.get(customer.getKey())).addAccount(new Account(acc, 0));
				//customer.accounts.acc.openingBalance += 100;
				return "Success";
			}
			else{
				return "Account already exists";
			}
		}
		else{
			return "Invalid account type";
		}
	}

}





