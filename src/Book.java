
public class Book extends Reading{
	
	// #### DECLARING VARIBALES #### //	
	private String [] author; 	
	
	// #### THE CONSTRUCTOR #### //	
	public Book(String a, String b, int c, String d, String e, int f, String [] g) {				
		id = a;
		name = b;
		price = c;
		publisher = d;
		genre = e;
		pages = f;
		author = g;				
	}
		
	// #### ACCESSORS #### //		
	// #### MUTATORS #### //		
	// #### TESTING ONLY #### //	
	// #### DELETE BEFORE DELIVERING ASSIGNMENT ####//
    // #### Testing the new BOOK added ###############//
//	public void testprint() {
//		System.out.println("");
//		System.out.println("BOOK OBJECT");
//		System.out.println("###########");
//		System.out.println("ID: "+id);
//		System.out.println("NAME: "+name);
//		System.out.println("PRICE: "+price);
//		System.out.println("PUBLISHER: "+publisher);
//		System.out.println("GENRE: "+genre);
//		System.out.println("PAGES: "+pages);
//		System.out.print("AUTHORS: "); 
//		for(int i = 0; i < author.length; i++) {
//			System.out.print(getAuthor(i)+" ");
//			if (i< (author.length-1)) {
//				System.out.print(", ");
//			}
//		}	
//		System.out.println("");
//		System.out.println("###########");
//		System.out.println("");
//	} // #### END DELETE ###############//
	
// #### DELETE BEFORE DELIVERING ASSIGNMENT ####//
//	public String getAuthor(int n) {
//		int i = n;
//		return author[i];					
//	}// #### END DELETE ###############//

	
}
