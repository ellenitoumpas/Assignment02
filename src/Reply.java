
public class Reply extends Comment {

private Comment replyTo;

public Reply(User user, Comment replyTo,String copy){
	super(user, copy);
	this.replyTo = replyTo;
	
	
}
}
