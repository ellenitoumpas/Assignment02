public class BalanceTooLowException extends Exception{
	
	private double balance;
	private double cost;
	private String msg;
	
	public BalanceTooLowException(double balance, double cost) {
		// super(msg);
		msg = " you do not have enough money ";
		this.balance = balance;
		this.cost = cost;
    }
	
	public String getMsg() {
		return msg;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public double getCost() {
		return cost;
	}
	
}
