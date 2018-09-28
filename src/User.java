
public class User {

	
	// USER variables
	private String id, name, phone;
	private int balance;
	
			
	private boolean premiumUser = false;
	private OS os;
	private final int PREMIUMCOST = 100;
	private double discount = 0.00;

		
	// USER constructor 
	public User(String a, String b, String c, int d, OS e) {
		id = a;
		name = b;
		phone = c;
		balance = d;
		os = e;		
	}
	
	
		
	// METHOD for becoming a premium user 
	public void becomePremium(){		

		
// Turn this If Else statement into a Try and Catch	
//		try {} catch(Exception e) {}	
		
//		try {
//			
//			// If not enough money
//			if (getBalance() - PREMIUMCOST < 0)
//				throw new BalanceTooLowException("premium membership");
//			
//			
//		}	
//		 } catch (BalanceTooLowException e) {
//			System.out.println(e + "");
//		}
		
						
		if (checkEnoughMoney(getBalance(), PREMIUMCOST)==true) {			
			if (getPremium() == false) {
				setPremium(true);	
				setDiscount(0.20);
			} else {
				System.out.println("You are already a premium member.");	
			}			
		} else {
			System.out.println("You do not have enough money to upgrade to Premium.");
		}		
	}
	

	
	
	
	
	
	
	
//	// METHOD for buying content	
//	public void buyContent(Content c) {
//				
//		
//		// #### TESTING ####//
//		System.out.println("\nUser "+name+" wants to buy a "+c.name +" which costs $"+c.price);
//		// #### TESTING ####//
//		
//		
//		// SET ITEM PRICE		
//		double itemprice;		
//		if (getPremium() == true) {			
//			itemprice = (c.price * (1 - discount)); // Need to convert to double
//			System.out.println("User "+name+" gets a discount for "+c.name +". The discount is for $"+(c.price - itemprice));
//		} else {
//			itemprice = c.price;
//		}
//		
//			
//		
//		// CHECK IF ENOUGH MONEY TO BUY		
//		// Turn this If Else statement into a Try and Catch	??
//		// try {} catch(Exception e) {}
//		
//		if (getBalance() - itemprice >= 0) {			
//			
//			// #### TESTING ####//
//			System.out.println("Before the transaction "+name+" had $"+balance);
//			
//			
//			deductBalance(itemprice);
//			
//			
//			// #### TESTING ####//
//			System.out.println("After the transaction "+name+" had $"+balance);
//			
//			// ADD ITEM TO USER LIST ?? 
//			// ADD +1 to NUMBER of DOWNLOADS for this items
//			c.addDownload(1);
//			System.out.println("The item "+c.name+" has been download "+c.downloads+" times.");
//			
//			// ADD A PRINT STATEMENT 
//			
//			// INCREASE NUM DOWNLOADED			
//		} else {
//			System.out.println("You do not have enough money to purchase this item.");
//		}	
//		
//	}
	
	
	
	
	// ######### ACCESSORS ########## //
		
	// Check if Premium
	public boolean getPremium() {
		return premiumUser;
	}
	
	// Check Discount value
		public double getDiscount() {
			return discount;
	}
		
	// Check Balance		
	public int getBalance() {
		return balance;
	}
	
	
	// Check Balance		
	public boolean checkEnoughMoney(double a, double b) {
		if ((a-b)>= 0) {
			return true;
		} else {
			return false;
		}
	}
	
	
	
	
	// ######### MUTATORS ########## //
		
	// Set Premium
	public void setPremium(boolean a) {
		premiumUser = a;
	}
	
	// Set Discount
	public void setDiscount(double a) {
		discount = a;
	}
	
	// Add to Balance
	public void addBalance(int a) {
		balance += a;
	}
	
	
	// Deduct from balance	
	public void deductBalance(double a) {
		// Checking whether user is a member happens in the buyContent method		
		balance -= a;				
	}
		
	
	
	
	
	
	// #### DELETE BEFORE DELIVERING ASSIGNMENT ####//
    // #### Testing the new USER added ###############//
	public void testprint() {
		System.out.println("");
		System.out.println("USER CREATED");
		System.out.println("###########");
		System.out.println("ID: "+id);
		System.out.println("NAME: "+name);
		System.out.println("PHONE: "+phone);
		System.out.println("BALANCE: "+balance);
		System.out.println("OS? "+os.getPlatform()+" version "+os.getVersion());
		System.out.println("###########");
		System.out.println("");
	}
	 // #### END DELETE ###############//
	
}
