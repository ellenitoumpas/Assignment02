public class OS {
	
	private String platform;
	private int version;	
	
	public OS (String a, int b){
		platform = a;
		version = b;
	}
	
		
	public String getPlatform() {
		return platform;
	}
	
	
	public int getVersion() {
		return version;
	}
		
}
