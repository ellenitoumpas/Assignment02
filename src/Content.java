import java.util.ArrayList;

abstract class Content {
		
	protected String id, name;
	protected char type;
	protected int downloads, price;	
	private ArrayList<Comment> reviews = new ArrayList<Comment>(); 	

	
	// Returns the ID of the item 
	public String getID(){
		return id;
	}
	
	
	// Returns the name of the item 
	public String getName(){
		return name;
	}
	
	
	// Returns the price of the item 
	public int getPrice(){
		return price;
	}
	
	
	// Returns the total number of downloads/ purchases of the item 
	public int getDownload(){
		return downloads;
	}
	
	
	// Returns the ID of the item 
	public char getType() {
		return type;
	}
	
	
	// Print details of the object 
	public void printAttributes() {	
		
		// If the product has only been downloaded once then the string says 'Download' instead of 'Downloads'
		String downloadString = ((downloads == 1) ? "download" : "downloads");
		
		// The format for an attribute line (for all objects)
		System.out.println(name + " [" + downloads + " " + downloadString.toUpperCase() + "]");	
	}

	
	// A method that prints a line of hashes to the same length of the title of that header
	public void hashoutput(int hashlength) {
		
		// A hash is printed for the length of the header title
		for (int i = 0; i < (hashlength - 1); i++) {
			System.out.print("#");
		}
		
		// The hash line is then ended with a new line
		System.out.println("#");
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
	
	
	// The depth integer indicates how far down a discussion thread to go, e.g. depth = 1 shows only reviews, no replies to those reviews.
	public void showReviews(int depth) {
		// Title for the Show Reviews section		
		outputheader("THE REVIEWS FOR: " + name + " (" + id + ")");	
		for (int i = 0; i < reviews.size(); i++) {
			System.out.println(reviews.get(i).getUser().getName() + " ("+reviews.get(i).getUser().getID() + "): "+reviews.get(i).getComment());
			reviews.get(i).showReplies((depth - 1), 1);
			}
	}
		

	// When an item is successfully ordered, the item's download count increases by 1.
	public void addDownload() {
		downloads++;
	}	
	
	
	// Adding a review should look like this
	public void addReview(Comment comment) {		
		reviews.add(comment);
	}
		
}
