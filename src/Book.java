public class Book extends Reading{
		
	private String [] author; 	
	
	public Book(String a, String b, int c, String d, String e, int f, String [] g) {				
		id = a;
		name = b;
		price = c;
		publisher = d;
		genre = e;
		pages = f;
		author = g;	
		type = 'b';
	}
		
}
