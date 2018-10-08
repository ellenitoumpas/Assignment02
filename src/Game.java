
public class Game extends Content{	
	
	private boolean isMultiPlayer;
	private OS os;

	public Game (String a, String b, int c, boolean d, OS e) {		
		id = a;
		name = b;
		price = c;		
		isMultiPlayer = d;
		os = e;
		type = 'g';
	}
	
	
	public void printAttributes() {		
		String downloadString = ((downloads == 1) ? "download" : "downloads");
		System.out.println(name+" "+os.getPlatform()+" v"+os.getVersion()+" ["+downloads+" "+downloadString.toUpperCase()+"]");  		
	}
	
	
	public String getPlatform() {
		return os.getPlatform();
	}
		
	
	public int getVersion() {
		return os.getVersion();
	}			
}
