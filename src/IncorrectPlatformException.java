public class IncorrectPlatformException extends Exception{

	private String msg, userPlatform, gamePlatform, msgfailed;
	
	// Exception custom messages (reasons for failure and confirmation of failure of purchase)
	public IncorrectPlatformException(String gamePlatform, String userPlatform) {		
		this.userPlatform = userPlatform;
		this.gamePlatform = gamePlatform;
		msg = "Incorrect Platform";		
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
	
	
	// Returns the User's operating system platform
	public String getUserPlatform() {
		return userPlatform;
	}
	
	
	// Returns the Game the user was trying to purchase's operating system platform
	public String getGamePlatform() {
		return gamePlatform;
	}
}
