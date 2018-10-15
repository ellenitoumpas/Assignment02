import java.text.*;
import java.util.ArrayList;

public class User {

	// Formatter for creating correct currency format with two decimals 
	DecimalFormat df = new DecimalFormat("0.00");
	
	// USER variables
	private String id, name, phone;
	private int balance;	 	
	private boolean premiumUser = false;
	private OS os;
	private final double PREMIUMCOST = 100.00;
	private double discount = 0.00;
	private ArrayList<Content> contentBought= new ArrayList<Content>(); 
	private String errorMessage = null;
	private String errorType = null;
	
	
	public User(String a, String b, String c, int d, OS e) {
		id = a;
		name = b;
		phone = c;
		balance = d;
		os = e;		
	}	
	
	
	// Returns the ID of the user
	public String getID() {
		return id;
	}
	
	
	// Returns the name of the user
	public String getName() {
		return name;
	}
	
	
	// Returns the current balance of the user
	public double getBalance() {				
		return (double)balance;
	}
	
	
	// Returns the premium status of the user
	public boolean getPremium() {
		return premiumUser;
	}	
	
	
	// Returns the discount rate set for the user
	public double getDiscount() {
			return discount;
	}

	
	// Changes the premium status for the user
	public void setPremium(boolean a) {
		premiumUser = a;
	}
	
	
	// Sets the discount rate for the user
	public void setDiscount(double a) {
		discount = a;
	}
		
	
	// Deducts an amount from the balance of the user
	public void deductBalance(double a) {		
		balance -= a;				
	}

	
	// Once a user has successfully bought an item it is added to the user's contentBought arrayList	
	public void addContentBought(Content a) {
		contentBought.add(a);
	}	
	

	// When a header title is printed, the length of the # line surrounded it is calculated here
	public String hashoutput(String test1, String test2) {		
			
		// The first # is set in the hashstring variable
		String hashstring = "#";
		
		// The length of each string of the header 
		int [] lengths = {test1.length(),test2.length()};
		
		// Initiating the maxlenth set to the length of the first string
		int maxlength = lengths[0];			
		
		// Finding out which string is the longest string ?		
		for (int i = 1; i < lengths.length; i++) {
			if(lengths[i] > maxlength) {
				maxlength = lengths[i];
			}
		}
		
		// Creates the hashstring to be the length of the string in the title (+1)
		for (int i = 0; i < (maxlength); i++) {			
			hashstring += "#";
		}
		
		return hashstring;
	}
	
	
	// After a purchase is attempted the closing statement prints a receipt for the user
	public String getClosingStatement(double sBalance, String receiptLine, double fBalance) {						

		String line1, line4;
		String line2 = "PURCHASE RECEIPT";
		String line3 = "TO: " + name + "[" + id + "]";
		String line5 = "INITIAL BALANCE: $" + df.format(sBalance);
		String line6 = receiptLine;
		String line7 = "FINAL BALANCE: $" + df.format(fBalance);
		
		// Line 1 and 4 are the hashes
		line1 = hashoutput(line2, line3);
		line4 = line1;
		
		// Returns the closing statement string
		return "\n" + line1 + "\n"+ line2 + "\n"+ line3 + "\n"+ line4 + "\n"+ line5 + "\n"+ line6 + "\n"+ line7+"\n";

	}
	
	
	// Returns whether a user has enough money to buy the item		
	public boolean checkEnoughMoney(double balance, double itemamount) {
		if ((balance - itemamount) >= 0) {
			return true;
		} else {
			return false;
		}
	}
	
	
	// Become a premium user 
	public void becomePremium(){	
		
		double startingBalance = getBalance();
		String receiptLine = null;
		
		try {
			// Check if the user is already a premium member first
			if (getPremium()) {				
				throw new AlreadyPremiumException();
			}	
			
			// Check if the user has enough money to become a member
			if (!checkEnoughMoney(startingBalance, PREMIUMCOST)) {
				throw new BalanceTooLowException(startingBalance, PREMIUMCOST);
			}	
			
			// If user isn't premium and if user has enough money then upgrade to premium 			
			setPremium(true);
			deductBalance(PREMIUMCOST);
			setDiscount(0.20);
			receiptLine = "PREMIUM MEMBERSHIP: -$" + df.format(PREMIUMCOST);
			System.out.println("SUCCESS: " + name + " your premium status has now been upgraded. You now receive a " + (int)(getDiscount()*100) + "% discount on all future purchases.");		
		}
		
		catch (AlreadyPremiumException se) {
			 errorMessage = "Sorry " + name + se.getMsg();			 
			 System.out.println(errorMessage);
			 System.out.println(se.getFailedMsg());
			 receiptLine = "PURCHASE FAILED: -$0.00";	
		} 
		
		catch (BalanceTooLowException se) {				
			errorType = "< " + se.getMsgTitle().toUpperCase() + " ERROR >";
			errorMessage = "Sorry " + name + se.getMsg() + "to become a premium member.";
			System.out.println(errorType);
			System.out.println(errorMessage);
			System.out.println(se.getFailedMsg());
			receiptLine = "1 x PREMIUM UPGRADE CANCELLED: -$0.00";	
		} 
		
		finally {
			// Prints a confirmation purchase receipt using the starting and closing balance plus a receipt for the item purchased
			System.out.println(getClosingStatement(startingBalance, receiptLine, getBalance()));
		}		
	}
	
	
	// Buy an item 
	public void buyContent(Content c) {	
			
		double startingBalance = getBalance();
		String receiptLine = null;
				
		// Set the item price (adjusted for discount if premium member)		
		double itemprice = getAdjustedPrice(c.price);
				
		try {		
			// Check if the user has enough money to buy the item
			if (!checkEnoughMoney(getBalance(), itemprice)) {
				 throw new BalanceTooLowException(getBalance(), itemprice);
			}	
			
			// Error if the item is a game and the platform of the game and the platform of the user isn't the same
			if ((c instanceof Game) && (os.getPlatform()!=((Game) c).getPlatform())) {
				throw new IncorrectPlatformException(((Game) c).getPlatform(), os.getPlatform());
			}
			
			// Error if the item is a game and the version of the user is less than the version of the game
			if ((c instanceof Game) && (os.getVersion() < ((Game) c).getVersion())) {
				throw new VersionOutOfDateException((((Game) c).getVersion()), ((Game) c).getPlatform(),os.getVersion(), os.getPlatform());				
			}			

			// Buying an item if no exception is thrown
			deductBalance(itemprice);
			c.addDownload();
			addContentBought(c);
			receiptLine = "1 x "+c.getName().toUpperCase()+": -$"+df.format(itemprice);
			System.out.println("SUCCESS: "+name+" has bought "+c.name+" for the price of $"+df.format(itemprice)+".");						
		}
					
		catch (BalanceTooLowException se) {			
			errorType = "< " + se.getMsg().toUpperCase() + " ERROR >";
			errorMessage = "Sorry " + name + se.getMsg() + "to buy " +c.getName()+".This item costs $" + df.format(se.getCost()) + " and you currently have a balance of $" + df.format(balance) + ".";
			System.out.println(errorMessage);
			System.out.println(se.getFailedMsg());
			receiptLine = "1 x " + c.getName().toUpperCase() + " CANCELLED: -$0.00";	
		}	
		
		catch(IncorrectPlatformException se) {
			errorType = "< " + se.getMsg().toUpperCase() + " ERROR >";
			errorMessage = "Sorry " + name + " but the game " +c.getName()+" you are trying to purchase is on " + se.getGamePlatform() + ". As you are on " + se.getUserPlatform() + " this game can not be downloaded.";
			System.out.println(errorType);
			System.out.println(errorMessage);
			System.out.println(se.getFailedMsg());
			receiptLine = "1 x " + c.getName().toUpperCase() + " CANCELLED: -$0.00";
		}
		
		catch(VersionOutOfDateException se) {
			errorType = "< " + se.getMsg().toUpperCase() + " ERROR >";
			errorMessage = "Sorry " + name + " but the game " +c.getName()+" you are trying to purchase is on " + se.getGamePlatform() + " version " + se.getGameVersion() + ". As you are on " +se.getUserPlatform() + " version " +se.getUserVersion() + " this game can not be downloaded.";			
			System.out.println(errorType);
			System.out.println(errorMessage);
			System.out.println(se.getFailedMsg());
			receiptLine = "1 x " + c.getName().toUpperCase() + " CANCELLED: -$0.00";
		}
		
		finally {
			// Prints a confirmation purchase receipt using the starting and closing balance plus a receipt for the item purchased
			System.out.println(getClosingStatement(startingBalance, receiptLine, getBalance()));
		}	
	}	
	
	
	// Adjusts the price of item if the user has Premium account
	public double getAdjustedPrice(int a) {
		if (getPremium()) {	
			return ((double)a * (1 - discount)); 
		} else {
			return (double)a;
		}		
	}
	
	
	// Show all content bought by this user
	public void showContentBought() {		
		
		String title = "PURCHASE HISTORY FOR ";
		String subtitle = name + " (" + id + ")";
		String hashes = hashoutput(title, subtitle);
		
		// Printing out the header of this section
		System.out.println("\n" + hashes + "\n" + title + "\n" + subtitle + "\n" + hashes);				
				
		// Print out all the items bought by this user
		try {
			
			// Error if the user hasn't bought any items
			if(contentBought.size() == 0)
				throw new NoItemsException();
			
			// If user has bought items, print out all the items 
			for (int i = 0; i < contentBought.size(); i++) {
				System.out.println(contentBought.get(i).getName());
			}
		}
		
		catch(NoItemsException se) {
			errorType = se.getMsg();			
			System.out.println(errorType);
		}         			
	}

}
