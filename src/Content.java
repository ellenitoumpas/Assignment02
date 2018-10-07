import java.util.ArrayList;

abstract class Content {
		
	// #### DECLARING VARIBALES #### //
	protected String id, name; // reviews done this way or another ??
	protected int downloads, price;	
	private ArrayList<Comment> reviews= new ArrayList<Comment>();  // Elleni changed to this
	//ArrayList<Comment> reviews;
	
	
	// #### ACCESSORS #### //
	
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
	
	public void printAttributes() {
		System.out.println("ID: "+ id);
		System.out.println("NAME: "+ name);
		System.out.println("PRICE: $" + price);
		System.out.println("DOWNLOADS: " + downloads);
		System.out.println();
	}
	
	public void showReviews(int depth) {
		// Title for the Show Reviews section
		System.out.println("");
		System.out.println("The reviews for "+name+" ("+id+"):");
		
		for (int i=0; i<reviews.size(); i++) {
			System.out.println(reviews.get(i).getUser().getName());
			System.out.println(reviews.get(i).getComment() +"\n");
			reviews.get(i).showReplies((depth - 1), 1);
		}
}
	public void showReviews(){
		// Title for the Show Reviews section
		System.out.println("");
		System.out.println("The reviews for "+name+" ("+id+"):");
		
		for (int i=0; i<reviews.size(); i++) {
			System.out.println(reviews.get(i).getUser().getName());
			System.out.println(reviews.get(i).getComment() +"\n");
			reviews.get(i).showReplies(255, 1);
		}
}
	
	// #### MUTATORS #### //
	
	public void addDownload() {
		downloads ++;
		}	
	
	// Adding a review should look like this
	public void addReview(Comment comment) {
		//System.out.println("About to add "+comment.getComment());
		reviews.add(comment);
	}


	
	//	public void addComment(Comment comment) {
	//		reviews.add(comment);
	//	}
	
	//	public void getComment(int index) {
	//		reviews.get(index);
	//	}
		
}
