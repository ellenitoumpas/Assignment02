public class VersionOutOfDateException  extends Exception{

	private String msg, userPlatform, gamePlatform, msgfailed;
	private int userVersion, gameVersion;
	
	public VersionOutOfDateException(int gameVersion, String gamePlatform, int userVersion, String userPlatform) {		
		this.gameVersion = gameVersion;
		this.gamePlatform = gamePlatform;
		this.userVersion = userVersion;
		this.userPlatform = userPlatform;		
		msg = "Version out of date";
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

	
	// Returns the User's operating system version 
	public int getUserVersion() {
		return userVersion;
	}
	
	
	// Returns the User's operating system platform
	public String getUserPlatform() {
		return userPlatform;
	}
	
	
	// Returns the Game the user was trying to purchase's operating system version
	public int getGameVersion() {
		return gameVersion;
	}
	
	
	// Returns the Game the user was trying to purchase's operating system platform
	public String getGamePlatform() {
		return gamePlatform;
	}
	
}
