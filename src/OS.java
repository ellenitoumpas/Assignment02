
public class OS {
	
	// #### DECLARING VARIBALES #### //
	
	// Private variables for the OS object
	private String platform;
	private int version;	
	
	
	// #### THE CONSTRUCTOR #### //
	
	// Constructor for the OS object - inputs include a string for platform type and integer for version number
	public OS (String a, int b){
		platform = a;
		version = b;
	}
	
	
	// #### ACCESSORS #### //
	
	// So far a testing only method...double check later if I still need to keep it?
	public String getPlatform() {
		return platform;
	}
	
	
	// So far a testing only method...double check later if I still need to keep it?
	public int getVersion() {
		return version;
	}
		
	
	
	// #### MUTATORS #### //
	
	// #### TESTING ONLY #### //
	
	// #### DELETE BEFORE DELIVERING ASSIGNMENT ####//
    // #### Testing the new OS added ###############//	
	public void testprint() {
		System.out.println("");
		System.out.println("OS");
		System.out.println("###########");		
		System.out.println("OS? "+platform+" version "+version);
		System.out.println("###########");
		System.out.println("");
	}
	// ######## END DELETE ########################//
	
}
