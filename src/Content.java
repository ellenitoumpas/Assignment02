import java.util.ArrayList;

abstract class Content {
	
	String id, name;
	int downloads, price;
	ArrayList<Comment> reviews;
		
	public String getID(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	
	// #### ACCESSORS #### //	
	public int getPrice(){
		return price;
	}
	
	public int getDownload(){
		return downloads;
	}
	
	public void getComment(int index) {
		reviews.get(index);
	}
	
	public void showcomment(int index) {
		System.out.print(reviews.get(index));
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

		
}
