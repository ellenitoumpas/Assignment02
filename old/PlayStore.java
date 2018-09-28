public class PlayStore {
	
	// Declare any instance variables you need here
	
	abstract Content() {
		
	}
	
	public void run() {

		
		//	 	// Adding new readings
//		String[] authors1 = {"L. Tolstoy"};
//		Book b1 = new Book ("r1", "War and Peace", 12, "The Russian Messenger", "Novel", 1225, authors1);
//		
//		String[] authors2 = {"F. Scott Fitzgerald"};
//		Book b2 = new Book ("r2", "The great gatsby", 10, "Charles Scribner's Sons", "Novel", 180, authors2);
//		
//		String[] authors3 = {"Thomas H. Cormen", "Charles E. Leiserson", "Ronald L. Rivest", "Clifford Stein"};
//		Book b3 = new Book ("r3", "Introduction to algorithms", 100, "MIT Press", "Computer Science", 1312, authors3);
//		
//		Magazine m1 = new Magazine("r3", "Forbes", 8, "Forbes Media", "Business", 50, "World’s richest under 30");
//		
//		admin.allContents.put(b1.getID(),b1);
//		admin.allContents.put(b2.getID(),b2);
//		admin.allContents.put(m1.getID(),m1);
//		admin.allContents.put(b3.getID(),b3);
//		
//		
//		// Adding new games
//		OS androidV4 = new OS("Android", 4);
//		OS iOSV10    = new OS("iOS", 10);
//		OS androidV3 = new OS("Android", 3);
//		
//		Game g1 = new Game("g1", "Pokemon", 5, false, androidV4);
//		Game g2 = new Game("g2", "Pokemon", 5, false, iOSV10);
//		Game g3 = new Game("g3", "MineCraft", 2, true, androidV3);
//		
//		admin.allContents.put(g1.getID(),g1);
//		admin.allContents.put(g2.getID(),g2);
//		admin.allContents.put(g3.getID(),g3);
//		
//		
//		// Adding new users
//		User u1 = new User("u1", "John Doe", "0412000", 20, androidV4);
//		User u2 = new User("u2", "Jane Doe", "0412001", 120, androidV4);
//		User u3 = new User("u3", "Dave Roe", "0412002", 100, iOSV10);
//		User u4 = new User("u4", "Diane Roe", "0412003", 50, androidV3);
//		
//		admin.allUsers.add(u1);
//		admin.allUsers.add(u2);
//		admin.allUsers.add(u3);
//		admin.allUsers.add(u4);
//				
//				
//		// Simulate transactions
//		u1.buyContent(b1);
//		u1.buyContent(b3);
//
//		u4.buyContent(g1);
//		u1.buyContent(m1);
//		
//		u4.becomePremium();
//		u4.buyContent(m1);
//		
//		u2.becomePremium();
//		u2.buyContent(g2);
//		u2.buyContent(g1);
//		
//		admin.showAllContents();
//		
//		
//		// Student to do: call a method to show all games
//		
//		
//		admin.showReadingsOfGenre("Novel");
//		u2.showContentsBought();
//		
//		Comment comment1 = new Comment(u1, "This is a fantastic game!");
//		g1.addReview(comment1);
//		
//		Comment reply1 = new Comment(u2, "I never liked this game!");
//		comment1.addReply(r1);
//		
//		Comment reply2 = new Comment(u1, "Why not??");
//		reply1.addReply(reply2);
//		
//		Comment comment2 = new Comment(u2, "I have changed my mind");
//		g1.addReview(comment2);
//		
//	
//		g1.printAllReviews();
	}
}