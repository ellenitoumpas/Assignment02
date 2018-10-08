public class IncorrectPlatformException extends Exception{

	private String msg, userPlatform, gamePlatform, msgfailed;
	
	public IncorrectPlatformException(String gamePlatform, String userPlatform) {		
		this.userPlatform = userPlatform;
		this.gamePlatform = gamePlatform;
		msg = "Incorrect Platform";		
		msgfailed = "Your purchase has failed and you have not been charged for this item.";
	}
	
	
	public String getMsg() {
		return msg;
	}
	
	
	public String getFailedMsg() {
		return msgfailed;
	}
	
	
	public String getUserPlatform() {
		return userPlatform;
	}
	
	
	public String getGamePlatform() {
		return gamePlatform;
	}
}
