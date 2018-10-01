import java.util.ArrayList;

abstract class Content {
	
	
	// #### DECLARING VARIBALES #### //
	
	String id, name; // reviews done this way or another ??
	int downloads, price;
	ArrayList<Comment> reviews;
		

	
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
	
	// #### MUTATORS #### //
	
	public void addDownload(int a){
		downloads += a;
	}
	public void addDownload() {
		downloads ++;
		}
	
	public void addComment(Comment comment) {
		reviews.add(comment);
	}
	
	public void getComment(int index) {
		reviews.get(index);
	}
		
}
