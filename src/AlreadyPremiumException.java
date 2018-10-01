public class AlreadyPremiumException extends Exception{		
	
	private String msg;
	
	public AlreadyPremiumException(String msg) {
		msg = "You are already a Premium Member.";
	}
	
}
