import java.util.ArrayList;

public class Comment {
	
	//COMMENT variables
 Content content;
 User user;
 String copy;
 ArrayList<Comment> replyList;
 

 //Constructor
 public Comment(User user, Content content, String copy) {
	 this.user = user;
	 this.content = content;
	 this.copy = copy;
	 content.addComment(this);
	 user.addComment(this);
	 }
 
 public Comment(User user, String copy) {
	 this.user = user;
	 this.copy = copy;
 }
 
//Methods
 public User getUser() {
	 return user;
 }
 public Content getContent() {
	 return content;
 }
 
 public void addReply(Comment reply) {
		this.replyList.add(reply);
	}
}
