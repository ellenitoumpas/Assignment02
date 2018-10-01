import java.util.ArrayList;

public class Book extends Reading{
	
	private ArrayList<String> Authors = new ArrayList<String>();
	
	
	public Book(String a, String b, int c, String d, String e, int f, String[] g) {				
		id = a;
		name = b;
		price = c;
		publisher = d;
		genre = e;
		pages = f;
		for (int i = 0; i < g.length; i++) {
			Authors.add(g[i]);
		}
	}
	
		
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
//		System.out.println("Authors are: "+Authors);
//			}
		
	// #### DELETE BEFORE DELIVERING ASSIGNMENT ####//
	public String getAuthor(int n) {
		String auth = Authors.get(n);
		return 	auth;				
	}// #### END DELETE ###############//

	
}
