import java.text.*;
import java.util.ArrayList;

public class User {

	// #### DECLARING VARIBALES #### //
	
	// Formatter for creating currency decimal value 
	DecimalFormat df = new DecimalFormat("0.00");
		
	// USER variables
	private String id, name, phone;
	private int balance;		
	private boolean premiumUser = true;
	private OS os;
	private final double PREMIUMCOST = 100.00;
	private double discount = 0.00;
	private ArrayList<Content> contentBought= new ArrayList<Content>();  

	
	
	// #### THE CONSTRUCTOR #### //
		
	// USER constructor 
	public User(String a, String b, String c, int d, OS e) {
		id = a;
		name = b;
		phone = c;
		balance = d;
		os = e;		
	}
	
	
	// #### ACCESSORS #### //
	
	// Check if Premium
	public boolean getPremium() {
		return premiumUser;
	}	
		
	// Check Discount value
	public double getDiscount() {
			return discount;
	}
			
	// Check Balance		
	public double getBalance() {				
		return (double)balance;
	}
		
	// Get Balance as string with 2 decimal places		
	public String getBalanceAsString() {				
		return df.format((double)balance);
	}
	
	public String getID() {
		return id;
	}
		
	// Check Balance		
	public boolean checkEnoughMoney(double a, double b) {
		if ((a-b)>= 0) {
			return true;
		} else {
			return false;
		}
	}
	
	// Adjust price of item if the user has Premium account
	public double getDiscountedPrice(int a) {
		if (getPremium() == true) {	
			return ((double)a * (1 - discount)); 
		} else {
			return (double)a;
		}		
	}
		
	// Show content bought for this user
	public void showContentBought() {		
		System.out.println("");
		System.out.println("###################################");
		System.out.println("PURCHASE HISTORY FOR "+name+" ("+id+")");
		System.out.println("###################################");
		for (int i=0; i<contentBought.size(); i++) 
            System.out.println(contentBought.get(i).getName());			
	}

		
	public void addContentBought(Content a) {
		contentBought.add(a);
	}

	
	// Become a premium user 
	public void becomePremium(){							  		
		
		String errorMessage = null;
		
		// CHECK if the user is a premium member
	
		try {
			
			if (getPremium() == true) {				
				// Throw exception if user is already premium
				throw new AlreadyPremiumException("your membership can not be created as you are already a member.");
			}						
			
			// CHECK if the user has enough money to become a member
			if (checkEnoughMoney(getBalance(), PREMIUMCOST)== false) {
				throw new BalanceTooLowException(balance, PREMIUMCOST);
			}		
			
			// If upgrade to premium is allowed the following actions performed			
			setPremium(true);
			deductBalance(PREMIUMCOST);
			setDiscount(0.20);
			System.out.println("\n"+name + " your premium status has now been upgrade! Your discount level is now "+(int)(getDiscount()*100)+"%.");		

		} catch (AlreadyPremiumException se) {
			 errorMessage = se.getMessage();
			 System.out.println(errorMessage);
			
		} catch (BalanceTooLowException se) {			
			errorMessage = se.getMsg() + "to become a premium member. Premium costs $" + (int)se.getCost() +"." ;
			System.out.println(errorMessage);
			
		} finally {
			System.out.println("Your balance is now $"+df.format(balance));
		}		
	}
	
	
//	// Buy an item - VERSION 02
//	public void buyContent(Content c) throws BalanceTooLowException, IncorrectPlatformException, VersionOutOfDateException{	
//						
//		// Set the item price (adjusted for discount if premium member)		
//		double itemprice = getDiscountedPrice(c.price);
//		 
//		// Check if the user has enough money to buy the item
//		if (checkEnoughMoney(getBalance(), itemprice)==false) {
//			throw new BalanceTooLowException("You do not have enough money to buy this item.");
//		}	
//		
//		// Check if item is of type game
//		if (c instanceof Game) {
//			testingOutput("This is a game!");
//							
//			// Check if platform of user os is equal to Game 
//			if ((os.getPlatform()!=((Game) c).getPlatform())) {
//				throw new IncorrectPlatformException("DOWNLOAD FAILED :: \nYour platform is incompatible with game.\nDOWNLOAD CANCELLED.");
//			}
//			
//			// Check if version meets minimum specifications
//			if (os.getVersion() < ((Game) c).getVersion()) {
//				throw new VersionOutOfDateException("DOWNLOAD FAILED :: \nYour computer specifications does not meet the minimum specifications for this game.\nDOWNLOAD CANCELLED");
//			}
//			
//			// #### DELETE BEFORE DELIVERING ASSIGNMENT ####//
//		    // #### User and game platforms ################// 
//			testingOutput("The user is on platform "+os.getPlatform());
//			testingOutput("The game platform is "+((Game) c).getPlatform());
//			// #################### End ####################//
//			
//		}
//		
//		// If the user has enough money buy the item and then increment the download count						
//		deductBalance(itemprice);
//		c.addDownload();
//		addContentBought(c);
//		testingOutput(name+" has bought a "+c.name+" for the price of $"+df.format(itemprice)+".\nThis item has now been download "+c.downloads+" times.");
//		
//	}
	
	// Buy an item - VERSION 01
	public void buyContent(Content c) {	
						
		// Set the item price (adjusted for discount if premium member)		
//		double itemprice = getDiscountedPrice(c.price);
//		 
//		try {												
//			
//			// Check if the user has enough money to buy the item
//			if (checkEnoughMoney(getBalance(), itemprice)==false) {
//				// throw new BalanceTooLowException("You do not have enough money to buy this item.");
//			}	
//			
//			// Check if item is of type game
////			if (c instanceof Game) {
//
////								
////				// Check if platform of user os is equal to Game 
////				if ((os.getPlatform()!=((Game) c).getPlatform())) 
////					
////				
////				// Check if version meets minimum specifications
////				if (os.getVersion() < ((Game) c).getVersion())
////					
////					throw new VersionOutOfDateException("Test");
////				
//				
////			}
//			
//			// If the user has enough money buy the item and then increment the download count						
//			deductBalance(itemprice);
//			c.addDownload();
//			addContentBought(c);
//			System.out.println(" ");
//			System.out.println(name+" has bought a "+c.name+" for the price of $"+df.format(itemprice)+".\nThis item has now been download "+c.downloads+" times.");						
//		} 

		// NOTES: Research better ways to format the exception		
//		catch (BalanceTooLowException se) {
//			System.out.println(se.getMessage());
//		}	
		
//		catch (IncorrectPlatformException se) {
//			System.out.println(se.getMessage());
//		}
		

	}
		
	
	// Set Premium
	public void setPremium(boolean a) {
		premiumUser = a;
	}
	
	
	// Set Discount
	public void setDiscount(double a) {
		discount = a;
	}
	
	
	// Add to Balance
	public void addBalance(double a) {
		balance += a;
	}
		
	
	// Deduct from balance	
	public void deductBalance(double a) {
		// Checking whether user is a member happens in the buyContent method		
		balance -= a;				
	}
		
	
}
