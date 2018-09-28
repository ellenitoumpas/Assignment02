abstract class Content {
	
	String id, name, reviews; // reviews done this way or another ??
	int downloads, price;	
		
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
	
	
	// #### MUTATORS #### //	
	public void addDownload(int a){
		downloads += a;
	}
	public void addDownload() {
		downloads ++;
		}

		
}
