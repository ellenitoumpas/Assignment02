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
	
	
	// Gets the user's ID
	public String getID() {
		return id;
	}
	
	
	// Gets the user's name
	public String getName() {
		return name;
	}
	
	
	// Get this user's balance		
	public double getBalance() {				
		return (double)balance;
	}
	
	
	// After a purchase is attempted the closing statement prints a receipt for the user
	public String getClosingStatement(double sBalance, String receiptLine, double fBalance) {				
		return "\n#######################"
				+ "\nPURCHASE RECEIPT"
				+ "\nTO: "+name + "[" + id + "]"
				+ "\n#######################"
				+ "\nINITIAL BALANCE: $" + df.format(sBalance) + "\n"+receiptLine
				+ "\nFINAL BALANCE: $" + df.format(fBalance)+"\n";
	}
	
	
	// Gets the user's premium membership status
	public boolean getPremium() {
		return premiumUser;
	}	
	
	
	// Gets discount value amount 
	public double getDiscount() {
			return discount;
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
			if (getPremium() == true) {				
				throw new AlreadyPremiumException();
			}						
			// Check if the user has enough money to become a member
			if (checkEnoughMoney(getBalance(), PREMIUMCOST)== false) {
				throw new BalanceTooLowException(balance, PREMIUMCOST);
			}		
			// If user isn't premium and if user has enough money then upgrade to premium 			
			setPremium(true);
			deductBalance(PREMIUMCOST);
			setDiscount(0.20);
			receiptLine = "PREMIUM MEMBERSHIP: -$" + df.format(PREMIUMCOST);
			System.out.println("SUCCESS: "+name + " your premium status has now been upgraded. You now receive a "+(int)(getDiscount()*100)+"% discount on all future purchases.");		
		} catch (AlreadyPremiumException se) {
			 errorMessage = "Sorry " + name + se.getMsg();			 
			 System.out.println(errorMessage);
			 System.out.println(se.getFailedMsg());
			 receiptLine = "PURCHASE FAILED: -$0.00";	
		} catch (BalanceTooLowException se) {				
			errorType = "< " + se.getMsgTitle().toUpperCase() + " ERROR >";
			errorMessage = "Sorry " + name + se.getMsg() + "to become a premium member.";
			System.out.println(errorType);
			System.out.println(errorMessage);
			System.out.println(se.getFailedMsg());
			receiptLine = "1 x PREMIUM UPGRADE CANCELLED: -$0.00";	

		} finally {
			// Prints a confirmation purchase receipt using the starting and closing balance plus a receipt for the item purchased
			System.out.println(getClosingStatement(startingBalance, receiptLine, getBalance()));
		}		
	}
	
	
	// Set Premium
	public void setPremium(boolean a) {
		premiumUser = a;
	}
	
	
	// Set Discount
	public void setDiscount(double a) {
		discount = a;
	}
		
	
	// Deduct from balance	
	public void deductBalance(double a) {
		// Checking whether user is a member happens in the buyContent method		
		balance -= a;				
	}
	
	
	// Buy an item 
	public void buyContent(Content c) {	
			
		double startingBalance = getBalance();
		String receiptLine = null;
				
		// Set the item price (adjusted for discount if premium member)		
		double itemprice = getAdjustedPrice(c.price);
				
		try {	
			
			// Check if the user has enough money to buy the item
			if (checkEnoughMoney(getBalance(), itemprice) == false) {
				 throw new BalanceTooLowException(getBalance(), itemprice);
			}	
			
			if ((c instanceof Game) && (os.getPlatform()!=((Game) c).getPlatform())) {
				throw new IncorrectPlatformException(((Game) c).getPlatform(), os.getPlatform());
			}
			
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
			
		} finally {
			
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
	
	// Once a user has successfully bought an item it is added to the user's contentBought arrayList	
	public void addContentBought(Content a) {
		contentBought.add(a);
	}	
			
	// Show content bought for this user
	public void showContentBought() {		
		System.out.println("");
		System.out.println("###################################");
		System.out.println("PURCHASE HISTORY FOR "+name+" ("+id+")");
		System.out.println("###################################");
		try {
			if(contentBought.size()==0)
				throw new NoItemsException();
			for (int i=0; i<contentBought.size(); i++) {
				System.out.println(contentBought.get(i).getName());
			}
		} catch(NoItemsException se) {
			// Add an exception if the user hasn't bought any items
		}         			
	}

}
