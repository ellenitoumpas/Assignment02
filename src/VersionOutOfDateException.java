public class VersionOutOfDateException  extends Exception{

	private String msg;
	private int userVersion, gameVersion;
	
	public VersionOutOfDateException(int userVersion, int gameVersion) {
		this.userVersion = userVersion;
		this.gameVersion = gameVersion;
		msg="Version out of date";
	}
	
	public String getMsg() {
		return msg;
	}

	public int getUserVersion() {
		return userVersion;
	}
	
	public int getGameVersion() {
		return gameVersion;
	}
	
}
