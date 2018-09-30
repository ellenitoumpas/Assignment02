
public class Game extends Content{	
	
	// #### DECLARING VARIBALES #### //
	
	private boolean isMultiPlayer;
	private OS os;
		
	
	// #### THE CONSTRUCTOR #### //
	
	public Game (String a, String b, int c, boolean d, OS e) {		
		id = a;
		name = b;
		price = c;		
		isMultiPlayer = d;
		os = e;				
	}
	
	
	// #### ACCESSORS #### //
	
	public String getPlatform() {
		return os.getPlatform();
	}
		
	// So far a testing only method...double check later if I still need to keep it?
	public int getVersion() {
		return os.getVersion();
	}
	
	
	// #### MUTATORS #### //
	
	
	// #### TESTING ONLY #### //
		
	// #### DELETE BEFORE DELIVERING ASSIGNMENT ####//
    // #### Testing the new GAME added ###############//
	public void testprint() {
		System.out.println("");
		System.out.println("GAME OBJECT");
		System.out.println("###########");
		System.out.println("ID: "+id);
		System.out.println("NAME: "+name);
		System.out.println("PRICE: "+price);
		System.out.println("IS MULTI? "+isMultiPlayer);
		System.out.println("OS? "+os.getPlatform()+" version "+os.getVersion());
		System.out.println("###########");
		System.out.println("");
	}
	 // #### END DELETE ###############//
	
	

		
}
