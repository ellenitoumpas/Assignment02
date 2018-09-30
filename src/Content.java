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
