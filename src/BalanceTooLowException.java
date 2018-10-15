public class BalanceTooLowException extends Exception{
	
	private double balance;
	private double cost;
	private String msg, msgfailed, msgTitle;
	
	public BalanceTooLowException(double balance, double cost) {
		// Exception custom messages (reasons for failure and confirmation of failure of purchase)
		msgTitle = "Balance Low";
		msg = " you do not have enough money ";
		msgfailed = "Your purchase has failed and you have not been charged for this item.";		
		this.balance = balance;
		this.cost = cost;
    }
	
	
	// Returns the reason for this exception
	public String getMsg() {
		return msg;
	}
	
	
	// Returns the title of the failure message
	public String getMsgTitle() {
		return msgTitle;
	}
	
	
	// Returns the failure of purchase confirmation message
	public String getFailedMsg() {
		return msgfailed;
	}
	
	
	// Returns the balance of the user to parse through the failure message
	public double getBalance() {
		return balance;
	}
	
	
	// Returns the cost of the item the user was attempting to buy when the failure occurred
	public double getCost() {
		return cost;
	}
	
}
