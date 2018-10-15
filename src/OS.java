public class OS {
	
	private String platform;
	private int version;	
	
	public OS (String a, int b){
		platform = a;
		version = b;
	}
	
	
	// Returns the platform of the operating system 
	public String getPlatform() {
		return platform;
	}
	
	
	// Returns the version number of the operating system
	public int getVersion() {
		return version;
	}
		
}
