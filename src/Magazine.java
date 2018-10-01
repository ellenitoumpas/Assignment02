
public class Magazine extends Reading{
	
	
	// #### DECLARING VARIBALES #### //
	
	private String mainFeature;
	
	
	// #### THE CONSTRUCTOR #### //
		
	public Magazine(String a, String b, int c, String d, String e, int f, String g) {
		id = a;
		name = b;
		price = c;
		publisher = d;
		genre = e;
		pages = f;
		mainFeature = g;				
	}
	
	
	// #### ACCESSORS #### //
	
	// #### MUTATORS #### //
	
	
	
	// #### TESTING ONLY #### //	
			
	// #### DELETE BEFORE DELIVERING ASSIGNMENT ####//
    // #### Testing the new BOOK added ###############//
	public void testprint() {
		System.out.println("");
		System.out.println("MAGAZINE OBJECT");
		System.out.println("###########");
		System.out.println("ID: "+id);
		System.out.println("NAME: "+name);
		System.out.println("PRICE: "+price);
		System.out.println("PUBLISHER: "+publisher);
		System.out.println("GENRE: "+genre);
		System.out.println("PAGES: "+pages);
		System.out.println("MAIN FEATURE: "+mainFeature);		
		System.out.println("###########");
		System.out.println("");
	} // #### END DELETE ###############//
		
}
