public class AlreadyPremiumException extends Exception{		
	
	private String msg, msgfailed;
	
	public AlreadyPremiumException() {
		msg = " you are already a Premium Member.";
		msgfailed = "Your purchase has failed and you have not been charged for this item.";
	}
	

	public String getMsg() {
		return msg;
	}
	
	
	public String getFailedMsg() {
		return msgfailed;
	}
	
}
