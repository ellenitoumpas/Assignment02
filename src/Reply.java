
public class Reply extends Comment {

private String replyTo;

public Reply(String userID, String replyTo,String comment){
	super(userID, comment);
	this.userID = userID;
	
	
}
}
