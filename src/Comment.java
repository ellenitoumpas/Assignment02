import java.util.ArrayList;

public class Comment {

	
	// #### DECLARING VARIBALES #### //
	private String comment;
	private User user;
	private ArrayList<Comment> replies = new ArrayList<Comment>();		
	
	
	// #### THE CONSTRUCTOR #### //
	public Comment(User a, String b) {
		user = a;
		comment = b;	
	}

	
	// #### ACCESSORS #### //
	public User getUser() {
		 return user;
	}
	 
	public String getComment() {
		 return comment;
	}
	
	public int getNumReplies() {
		 return replies.size();
	}
		
	public String getReplyComment(int i) {
		 return replies.get(i).comment;
	}
	
	public User getReplyAuthor(int i) {
		 return replies.get(i).getUser();
	}
	 
	 
	// #### MUTATORS #### //
	public void addReply(Comment reply) {
		 replies.add(reply);
	}
	
	// #### OTHER FUNCTIONS#### //
	
	public void printReply(int i) {
		System.out.println(this.getReplyAuthor(i));
		System.out.println(this.getReplyComment(i));
		}
	
	public void showAllReplies(int depth) {
			System.out.println("");
			System.out.println("The reviews for "+ user.getName() +" ("+ user.getID() +"):");
			
			for (int i = 0; i < replies.size(); i++) {
				System.out.println(replies.get(i).getUser().getName());
				System.out.println(replies.get(i).getComment() + "\n");
				replies.get(i).showReplies((depth - 1), 1);
			}
	}
	
	public void showReplies(int depth, int indent) {
		if (depth > 0)
		for (int i = 0; i < replies.size(); i++) {
			for (int j = 0; j < indent; j++) {
				System.out.print("\t");
			}
			System.out.print(getReplyAuthor(i).getName() + "\n");
			for (int k = 0; k < indent; k++) {
				System.out.print("\t");
			}
			System.out.print(replies.get(i).getComment()+ "\n\n");
			replies.get(i).showReplies((depth - 1), (indent + 1));
		}
	}
// DELETE BEFORE SUBMITTING	`
//	 public String getContent() {
//	 return contentID;
// }
//	public String getCommentID() {
//	 return getSimpleName();
//} 
 
}

