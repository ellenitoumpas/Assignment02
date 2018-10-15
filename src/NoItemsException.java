public class NoItemsException extends Exception{

	private String msg;
	
	// Exception custom messages (reason for failure)
	public NoItemsException() {
		msg = "no items";
		
	}
	
	// Returns the reason for this exception
	public String getMsg() {
		return msg;
	}

}
