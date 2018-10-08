public class BalanceTooLowException extends Exception{
	
	private double balance;
	private double cost;
	private String msg, msgfailed, msgTitle;
	
	public BalanceTooLowException(double balance, double cost) {
		msgTitle = "Balance Low";
		msg = " you do not have enough money ";
		msgfailed = "Your purchase has failed and you have not been charged for this item.";
		this.balance = balance;
		this.cost = cost;
    }
	
	
	public String getMsg() {
		return msg;
	}
	
	
	public String getMsgTitle() {
		return msgTitle;
	}
	
	
	public String getFailedMsg() {
		return msgfailed;
	}
	
	
	public double getBalance() {
		return balance;
	}
	
	
	public double getCost() {
		return cost;
	}
	
}
