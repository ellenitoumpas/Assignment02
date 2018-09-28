
public class Game extends Content{
	
	private boolean isMultiPlayer;
	private OS os;
		
	public Game (String a, String b, int c, boolean d, OS e) {		
		id = a;
		name = b;
		price = c;		
		isMultiPlayer = d;
		os = e;				
	}
			
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
