import java.util.ArrayList;

public class Comment {

	private String comment;
	private User user;
	private ArrayList<Comment> replies = new ArrayList<Comment>();		
	
	public Comment(User a, String b) {
		user = a;
		comment = b;	
	}

	
	// Retrieves the user who made a comment
	public User getUser() {
		 return user;
	}
	
	
	// Retrieves the actual content within the comment object
	public String getComment() {
		 return comment;
	}
	
		
	// Gets the comment that has been stored as a reply
	public String getReplyComment(int i) {
		 return replies.get(i).comment;
	}
	
	
	// Returns the author of a reply
	public User getReplyAuthor(int i) {
		 return replies.get(i).getUser();
	}
	 
	 
	// Add a comment as a reply
	public void addReply(Comment reply) {
		 replies.add(reply);
	}

		
	// This method will recursively call itself and print all replies in a depth-first approach until the specified depth is reached.
	public void showReplies(int depth, int indent) {
	
		// If the number of levels of replies to look at is larger than 0 then this method will be performed 
		if (depth > 0) {

			// Repeats the following for the number of replies in the reply arraylist
			for (int i = 0; i < replies.size(); i++) {
				
				// The j-loop indents each new level of depth the correct amount to indicate who is replying to whom.
				for (int j = 0; j < indent; j++) {
					System.out.print("\t");					
				}
				
				// The actual comment line is printed (with formatting for user name and user ID)
				System.out.println(getReplyAuthor(i).getName() + " (" + replies.get(i).getUser().getID() + "): " + replies.get(i).getComment());
			
				// Recursively calls the same method on the recently printed comment. 
				replies.get(i).showReplies((depth - 1), (indent + 1));				
			}			
		}
	}	 
}

