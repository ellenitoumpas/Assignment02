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
	
		
	public String getReplyComment(int i) {
		 return replies.get(i).comment;
	}
	
	
	public User getReplyAuthor(int i) {
		 return replies.get(i).getUser();
	}
	 
	 
	public void addReply(Comment reply) {
		 replies.add(reply);
	}
	
	
	public void printReply(int i) {
		System.out.println(this.getReplyAuthor(i));
		System.out.println(this.getReplyComment(i));
	}
		
	//showReplies will recursively call itself and print all replies in a depth-first approach until the specified depth is reached.
	public void showReplies(int depth, int indent) {
		if (depth > 0)
		for (int i = 0; i < replies.size(); i++) {
			//the j-loop indents each new level of depth the correct amount to indicate who is replying to whom.
			for (int j = 0; j < indent; j++) {
				System.out.print("\t");
			}
			System.out.println(getReplyAuthor(i).getName() + " (" + replies.get(i).getUser().getID() + "): " + replies.get(i).getComment());
			//recursively calls the same method on the recently printed comment. 
			replies.get(i).showReplies((depth - 1), (indent + 1));
		}
	}
	 
}

