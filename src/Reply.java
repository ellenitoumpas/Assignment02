
public class Reply extends Comment {

private Comment replyTo;

// Constructor drops Content, adds replyTo. Replies refer to other comment objects rather than content objects.
public Reply(User user, Comment replyTo,String copy){
	super(user, copy);
	this.replyTo = replyTo;
		
}



}
