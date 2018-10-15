
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
	
	
	// Print details of the object (Game specific) 
	public void printAttributes() {		
				
		// If the product has only been downloaded once then the string says 'Download' instead of 'Downloads'
		String downloadString = ((downloads == 1) ? "download" : "downloads");
		
		// The format for an attribute line (game specific)
		System.out.println(name + " " + os.getPlatform() + " v" + os.getVersion() + " [" + downloads + " " + downloadString.toUpperCase() + "]");  		
	}
	
	
	// Returns the platform of the Game
	public String getPlatform() {
		return os.getPlatform();
	}
		
	
	// Returns the version number of the Game
	public int getVersion() {
		return os.getVersion();
	}			
}
