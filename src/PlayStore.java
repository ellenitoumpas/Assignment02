import java.util.Hashtable;
import java.util.ArrayList;
import java.util.Enumeration;

public class PlayStore {
	
//	private String id;
//	private Content content;		
	private Hashtable<String, Content> contentlist = new Hashtable<String, Content>(); 
	private ArrayList<User> userlist= new ArrayList<User>();
		
	
	// Keep a record of all objects added to the shop 
	public void add(String id, Content content) {
//		this.id = id;
//		this.content = content;
		contentlist.put(id, content);		
	}
	
	
	 //Keep a record of all user accounts added to the shop
	public void add(User user) {
		userlist.add(user);
	}
	
	
	// Show all available content items in the store
	public void showContent() {		
		System.out.println("");
		System.out.println("###################");
		System.out.println("ALL AVAILABLE ITEMS");
		System.out.println("###################");
        Enumeration<String> keys = contentlist.keys();
        while(keys.hasMoreElements()){
            String key = keys.nextElement(); 
            contentlist.get(key).printAttributes(); 
        }	
	}
	
	
	// Show all available books of a particular genre
	public void showReadingOfGenre(String genre) {				 		
		// Go through contentlist and return items that are of genre type		
//		String cgenre = genre;		
		System.out.println(""); 
		System.out.println("########################");
		System.out.println("ALL BOOKS IN GENRE: "+ genre.toUpperCase());
		System.out.println("########################");
        Enumeration<String> keys = contentlist.keys();        
        while(keys.hasMoreElements()){        	
            String key = keys.nextElement();                   
            String classtypestring = String.valueOf(contentlist.get(key).getClass());          
            if (classtypestring.equals("class Book") | classtypestring.equals("class Magazine")){            	
            	String genretype = ((Reading) contentlist.get(key)).getGenre();            	
            	if (genretype.equals(genre)) {
            		contentlist.get(key).printAttributes();
            	}				
			}            
        }		
	}
	

	// ########### FIX ALL METHODS THAT ARE BELOW HERE ###############	
	
	
	public void showContent(Content c) {			
		char contentType = c.getType();
		
		//Print the banner
		System.out.println("");	
		System.out.println("#####################");
		System.out.println("ALL ITEM OF TYPE "+ Character.toUpperCase(contentType));
		System.out.println("#####################");	
		
		//Go through the contentList and show content of all instances of the chosen game type.
		Enumeration<String> keys = contentlist.keys();				
		while(keys.hasMoreElements()){
			String key = keys.nextElement();
			switch (contentType) {
			case 'g': 
				if (contentlist.get(key) instanceof Game){
					contentlist.get(key).printAttributes();
					}
				break;
			case 'b': 
				if (contentlist.get(key) instanceof Book){
					contentlist.get(key).printAttributes();
					}
				break;
			case 'm': 
				if (contentlist.get(key) instanceof Magazine){
					contentlist.get(key).printAttributes();
					}
				break;
			default: 			
				System.out.println("No such class."); // TO DO: FIX THE WAY DEFAULT APPEARS....AT THE MOMENT IT WRITES 'NO SUCH CLASS' EACH ITERATION
			}											  	
		}		
	}		
}