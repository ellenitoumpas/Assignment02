public class AlreadyPremiumException extends Exception{		
	
	private String msg;
	
	public AlreadyPremiumException(String msg) {
		msg = "Sorry you do not have enough money ";
	}
	
}
