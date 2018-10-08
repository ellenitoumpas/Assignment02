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
	
	
	// Retrieves the actual string within the comment object
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
	
	
//  TESTING ONLY :: DELETE WHEN COMMENT SECTION FINISHED	
//	public void showAllReplies(int depth) {
//			System.out.println("");
//			System.out.println("The reviews for "+ user.getName() +" ("+ user.getID() +"):");
//			
//			for (int i = 0; i < replies.size(); i++) {
//				System.out.println(replies.get(i).getUser().getName());
//				System.out.println(replies.get(i).getComment() + "\n");
//				replies.get(i).showReplies((depth - 1), 1);
//			}
//	}
//	
	
	
	public void showReplies(int depth, int indent) {
		if (depth > 0)
		for (int i = 0; i < replies.size(); i++) {
			for (int j = 0; j < indent; j++) {
				System.out.print("\t");
			}
			System.out.println(getReplyAuthor(i).getName()+" ("+replies.get(i).getUser().getID()+"): "+replies.get(i).getComment());
			replies.get(i).showReplies((depth - 1), (indent + 1));
		}
	}
	 
}

