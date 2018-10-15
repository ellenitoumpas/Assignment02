import java.util.Hashtable;
import java.util.ArrayList;
import java.util.Enumeration;

public class PlayStore {
			
	private Hashtable<String, Content> contentlist = new Hashtable<String, Content>(); 
	private ArrayList<User> userlist= new ArrayList<User>();		
	
	// Keep a record of all objects added to the shop 
	public void add(String id, Content content) {
		contentlist.put(id, content);		
	}
	
	
	 // Keep a record of all user accounts added to the shop
	public void add(User user) {
		userlist.add(user);
	}
	
	
	// A method that builds then prints the header title from another method that is about to print a whole heap of attributes
	public void outputheader(String title) {
		
		// Stores the string parsed to this method 
		String headertitle = title;
		
		// Printing the header
		System.out.println("");
		
		// In the header a line of hashes are printed with the same length of the title
		hashoutput(headertitle.length());
		
		// Printing the title 
		System.out.println(headertitle.toUpperCase());
		
		// Ending with another line of hashes 
		hashoutput(headertitle.length());
	}
	
	
	// A method that prints a line of hashes to the same length of the title of that header
	public void hashoutput(int hashlength) {
		
		// A hash is printed for the length of the header title
		for (int i = 0; i < (hashlength); i++) {
			System.out.print("#");
		}
		
		// The hash line is then ended with a new line 
		System.out.println("");
	}
	
	
	// Show all available content items in the store
	public void showContent() {				

		// The header of the 'All available items' is printed
		outputheader("All available items");		
		
		// The main part of the method that goes through contentlist 
        Enumeration<String> keys = contentlist.keys();
        
        while(keys.hasMoreElements()){
            String key = keys.nextElement();
            
            // Each element printed to a line formatted by the printAttributes method 
            contentlist.get(key).printAttributes(); 
        }	
	}
	
	
	// Show all available books of a particular genre
	public void showReadingOfGenre(String genre) {				 		

		// The header of the 'Show Genre' is printed
		outputheader("ALL BOOKS IN GENRE: "+ genre.toUpperCase());	
		
		// The main part of the method that goes through contentlist
        Enumeration<String> keys = contentlist.keys();        
        while(keys.hasMoreElements()){  	
            String key = keys.nextElement();
            
            // Converts the class of the element to a string
            String classtypestring = String.valueOf(contentlist.get(key).getClass()); 
            
            // Checks if the string equals to the Reading children (book or magazine)
            if (classtypestring.equals("class Book") | classtypestring.equals("class Magazine")){            	
            	
            	// Retrieves the genre of the book or magazine
            	String genretype = ((Reading) contentlist.get(key)).getGenre();   
            	
            	// If the genre matches then it prints the item as formatted by the printAttributes method            	
            	if (genretype.equals(genre)) {
            		contentlist.get(key).printAttributes();
            	}				
			}            
        }		
	}
	
	
	// Show the content list filtered by content type.
	public void showContent(String itemfilter) {				

		// The header of the filtered content section
		outputheader("ALL BOOKS IN GENRE: "+itemfilter.toUpperCase());	
		
		// Go through the contentList and show content of all instances of the chosen object type
		Enumeration<String> keys = contentlist.keys();				
		while(keys.hasMoreElements()){			
			String key = keys.nextElement();
			
			// A switch the shows only the attributes that match the type chosen 
			switch (itemfilter) {
			case "Games": 
				if (contentlist.get(key) instanceof Game){
					contentlist.get(key).printAttributes();
					}
				break;
			case "Books": 
				if (contentlist.get(key) instanceof Book){
					contentlist.get(key).printAttributes();
					}
				break;
			case "Magazines": 
				if (contentlist.get(key) instanceof Magazine){
					contentlist.get(key).printAttributes();
					}
				break;
			default: 	
				// If the element is the last element and hasn't matched any of the items above then no items found
				if(keys.hasMoreElements() == false) {
					System.out.println("- no items found -"); 
				}
				break;
			}											  	
		}		
	}	
	
}
