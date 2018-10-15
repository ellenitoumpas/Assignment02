public class AlreadyPremiumException extends Exception{		
	
	private String msg, msgfailed;
	
	public AlreadyPremiumException() {
		// Exception custom messages (reasons for failure and confirmation of failure of purchase) 
		msg = " you are already a Premium Member.";
		msgfailed = "Your purchase has failed and you have not been charged for this item.";
	}
	
	
	// Returns the reason for this exception 
	public String getMsg() {
		return msg;
	}
	
	
	// Returns the failure of purchase confirmation message
	public String getFailedMsg() {
		return msgfailed;
	}
	
}
