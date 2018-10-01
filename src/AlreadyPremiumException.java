public class AlreadyPremiumException extends Exception{		
	
	private String msg;
	
	public AlreadyPremiumException() {
		msg = "You are already a Premium Member.";
	}
	
	public String getMsg() {
		return msg;
	}
	
}
