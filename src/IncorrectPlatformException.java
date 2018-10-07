public class IncorrectPlatformException extends Exception{

	private String msg, userPlatform, gamePlatform;
	
	public IncorrectPlatformException(String userPlatform, String gamePlatform) {
		this.userPlatform = userPlatform;
		this.gamePlatform = gamePlatform;
		msg = "Incorrect platform";
	}
	
	public String getMsg() {
		return msg;
	}
	
	public String getUserPlatform() {
		return userPlatform;
	}
	
	public String getGamePlatform() {
		return gamePlatform;
	}
}
