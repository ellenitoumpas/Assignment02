import java.util.Hashtable;
import java.util.ArrayList;

public class PlayStore {
	
	// whatever variables you need here.
	// They must all be marked as private
	
	private String id;
	private Content content;
	
	// Declare a private variable (array or similar) to store your Content objects here
	Hashtable<String, Content> contentlist = new Hashtable<String, Content>(); 
	
	
	// Declare a private variable (array or similar) to store your User objects here
	// use a hashtable for user ?? 
	
	
	
	public PlayStore() {		
		System.out.println("PlayStore Created");// any code you need here
	}
	
		
	public void add(String id, Content content) {
		this.id = id;
		this.content = content;
		contentlist.put(id, content);
	}
	

	
//	public void add(User user) {
//		// add the user to your list of users
//	}
//	
//	
//	public void showReadingOfGenre(String genre) {
//		// add your code here
//	}

	public void showContent(Object o) {	
		System.out.println("");
		System.out.println("ITEM ADDED TO CONTENT HASHTABLE");
		System.out.println("###########");
		System.out.println(contentlist.get(o).getID());
		System.out.println(contentlist.get(o).getName());
		System.out.println(contentlist.get(o).getPrice());				
		System.out.println("###########");
		System.out.println("");
	}
	
	// ####TESTING STATEMENT #### //	
	public void testingOutput(String a){
		System.out.println(a);
	}
	
}