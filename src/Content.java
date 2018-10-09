import java.util.ArrayList;

abstract class Content {
		
	protected String id, name;
	protected char type;
	protected int downloads, price;	
	private ArrayList<Comment> reviews = new ArrayList<Comment>(); 	
		
	public String getID(){
		return id;
	}
	
	
	public String getName(){
		return name;
	}
	
	
	public int getPrice(){
		return price;
	}
	
	
	public int getDownload(){
		return downloads;
	}
	
	
	public char getType() {
		return type;
	}
	
	
	public void printAttributes() {	
		String downloadString = ((downloads == 1) ? "download" : "downloads");
		System.out.println(name + " [" + downloads + " " + downloadString.toUpperCase() + "]");	
	}
	
	
	//the depth integer indicates how far down a discussion thread to go, e.g. depth = 1 shows only reviews, no replies to those reviews.
	public void showReviews(int depth) {
		// Title for the Show Reviews section
		System.out.println("");
		System.out.println("#############################");
		System.out.println("THE REVIEWS FOR: " + name + " (" + id + ")");
		System.out.println("#############################");
		
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
