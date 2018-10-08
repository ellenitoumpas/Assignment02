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
	
	
	public String getMsg() {
		return msg;
	}
	
	
	public String getFailedMsg() {
		return msgfailed;
	}

	
	public int getUserVersion() {
		return userVersion;
	}
	
	
	public String getUserPlatform() {
		return userPlatform;
	}
	
	
	public int getGameVersion() {
		return gameVersion;
	}
	
	
	public String getGamePlatform() {
		return gamePlatform;
	}
	
}
