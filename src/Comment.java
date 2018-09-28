import java.util.ArrayList;

public class Comment {
	
	//COMMENT variables
 String userID, contentID, comment;
 ArrayList<Reply> replyList;
 

 //Constructor
 public Comment(String userID, String contentID, String comment) {
	 this.userID = userID;
	 this.contentID = contentID;
	 this.comment = comment;
	//TODO: method to add comment to User
	 }
 public Comment(String UserID, String comment) {
	 this.userID = userID;
	 this.comment = comment;
 }
 
//Methods
 public String getUser() {
	 return userID;
 }
 public String getContent() {
	 return contentID;
 }

}
