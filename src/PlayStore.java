import java.util.Hashtable;
import java.util.ArrayList;
import java.util.Enumeration;

public class PlayStore {
	
	
	
	// #### DECLARING VARIBALES #### //
	
	private String id;
	private Content content;		
	private Hashtable<String, Content> contentlist = new Hashtable<String, Content>(); 
	private ArrayList<User> userlist= new ArrayList<User>();
	
	
	
	// #### THE CONSTRUCTOR #### //
	
	public PlayStore() {}
	
	
	// #### ACCESSORS #### //
	
	// Get a feature of the store item by index 
	// Allows an iterative approach to get ALL features 
	// From any generic object  (not specific to class)
	public void getFeatureByIndex(int i) {
		//
	}
	
	
	public void showReadingOfGenre(String genre) {				 		
		// Go through contentlist and return items that are of genre type
		// Is there an issue with hard coding "class Book/ Magazine" in if then statement ??
		// Ideally I want to get super.classname but this causes issues (returns java.object)
		String cgenre = genre;		
		System.out.println(""); 
		System.out.println("########################");
		System.out.println("ALL BOOKS IN GENRE: "+cgenre.toUpperCase());
		System.out.println("########################");
		System.out.println(""); 
        Enumeration<String> keys = contentlist.keys();        

        while(keys.hasMoreElements()){
        	
            String key = keys.nextElement();                   
            String classtypestring = String.valueOf(contentlist.get(key).getClass());
          
            if (classtypestring.equals("class Book") | classtypestring.equals("class Magazine")){            	
            	String genretype = ((Reading) contentlist.get(key)).getGenre();            	
            	if (genretype.equals(cgenre)) {
            		System.out.println("ID: "+contentlist.get(key).getID());
            		System.out.println("ID: "+ (((Reading) contentlist.get(key)).getGenre()));
            	}				
			}            
        }		
	}
	
	// **** AN EXPERIMENT ** //
	// Show all content available in the store using a generic approach
	
//	public void showContent() {		
//		System.out.println("ALL AVAILABLE ITEMS");
//		System.out.println("###################");
//		System.out.println("");  
//        Enumeration<String> keys = contentlist.keys();
//        while(keys.hasMoreElements()){
//            String key = keys.nextElement();   
//            Object o = contentlist.get(key);
//            System.out.println("Object retrieved: "+ o);
//            
//            System.out.println("ID: "+contentlist.get(key).getID()); 
//            System.out.println("TYPE: "+contentlist.get(key).getClass()); 
//            System.out.println("NAME: "+contentlist.get(key).getName()); 
//            System.out.println("DOWNLOADS: "+contentlist.get(key).getDownload()); 
//            System.out.println("");             
//        }	
//	}
//	
	
	
//	 **** THIS VERSION WORKS ** //
//	 Show all content available in the store
	
	public void showContent() {		
		System.out.println("");
		System.out.println("###################");
		System.out.println("ALL AVAILABLE ITEMS");
		System.out.println("###################");
		System.out.println("");  
		
        Enumeration<String> keys = contentlist.keys();
        while(keys.hasMoreElements()){
            String key = keys.nextElement();               
            System.out.println("ID: "+contentlist.get(key).getID()); 
            System.out.println("TYPE: "+contentlist.get(key).getClass()); 
            System.out.println("NAME: "+contentlist.get(key).getName()); 
            System.out.println("DOWNLOADS: "+contentlist.get(key).getDownload()); 
            System.out.println("");             
        }	
	}
	
	// SOLUTION 1 FOR SHOWCONTENT(CLASS TYPE):: 
	// 1. Parse a string that should match the object type (manually type in)
	// 2. Convert to lowercase
	// 3. Grab the first character of the Show content of type using first char of ID name
	// book -> b, magazine -> m, game -> g
	public void showContent(String s) {		
		
		String objectName = s.toLowerCase();
		char chosenchar = objectName.charAt(0);
		System.out.println("");
		System.out.println("#########################");
		System.out.println("ALL ITEMS OF TYPE: "+s.toUpperCase());
		System.out.println("#########################");
		System.out.println("");
		
		Enumeration<String> keys = contentlist.keys();		
		
		while(keys.hasMoreElements()){
			
			String key = keys.nextElement();
			Class elementid = contentlist.get(key).getClass();
			String classname = String.valueOf(elementid).toLowerCase();			
			char classfirstchar = classname.charAt(6);				
					
			if (classfirstchar == chosenchar){
				System.out.println("ID: "+contentlist.get(key).getID());
			}
			
			// ADD exception :: if no items matching type 			  	
		}		
	}
	
	
	
	// SOLUTION 2 :: ANOTHER VERSION ??
//	public void showContent(String s) {
//		String generic = "class ";
//		String objectName = generic.concat(s);		
//		System.out.println("ALL ITEM TYPES");
//		System.out.println("###################");
//		System.out.println(""); 		
//		Enumeration<String> keys = contentlist.keys();
//		while(keys.hasMoreElements()){
//			String key = keys.nextElement();				
//			System.out.println("ID: "+contentlist.get(key).getID()); 
//			System.out.println("TYPE: "+contentlist.get(key).getClass()); 			
//			System.out.println("TEST: Is "+ contentlist.get(key).getClass() + " of type "+objectName+" RESULT "+ (String)contentlist.get(key).getClass().equals(objectName));
//			System.out.println("");   	
//		}		
//	}
	
	
	
	
	
	// #### MUTATORS #### //
	
	// Add content to the contentlist hashtable
	public void add(String id, Content content) {
		this.id = id;
		this.content = content;
		contentlist.put(id, content);
	}
	
	// Add user to userlist arraylist
	public void add(User user) {
		userlist.add(user);
	}
	

	
	

	

	// #### TESTING ONLY #### //
	
	// ##### TESTING STATEMENT ##### //	
	public void testingOutput(String a){
		System.out.println(a);
	}
	
}