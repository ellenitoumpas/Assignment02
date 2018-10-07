import java.util.ArrayList;

public class Comment {

	
	// #### DECLARING VARIBALES #### //
	private String comment;
	private User userID;
	private ArrayList<Comment> replyList = new ArrayList<Comment>();		
	
	
	// #### THE CONSTRUCTOR #### //
	public Comment(User a, String b) {
		userID = a;
		comment = b;	
	}

	
	// #### ACCESSORS #### //
	public String getUser() {
		 return userID.getID();
	}
	 
	public String getComment() {
		 return comment;
	}
	
	public int getNumReplies() {
		 return replyList.size();
	}
		
	public String getReplyComment(int i) {
		 return replyList.get(i).comment;
	}
	
	public String getReplyAuthor(int i) {
		 return replyList.get(i).userID.getID();
	}
	 
	 
	// #### MUTATORS #### //
	public void addReply(Comment reply) {
		 replyList.add(reply);
	}
	
	
// DELETE BEFORE SUBMITTING	
//	 public String getContent() {
//	 return contentID;
// }
//	public String getCommentID() {
//	 return getSimpleName();
//} 
 
}

