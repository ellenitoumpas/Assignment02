import java.text.*;
import java.util.ArrayList;

public class User {

	// #### DECLARING VARIBALES #### //
	
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
	
	
	public User(String a, String b, String c, int d, OS e) {
		id = a;
		name = b;
		phone = c;
		balance = d;
		os = e;		
	}	
	
	// Gets the user's premium membership status
	public boolean getPremium() {
		return premiumUser;
	}	
		
	// Gets discount value amount 
	public double getDiscount() {
			return discount;
	}
			
	// Get this user's balance		
	public double getBalance() {				
		return (double)balance;
	}
		
	// Get Balance as string with 2 decimal places		
//	public String getBalanceAsString() {				
//		return df.format((double)balance);
//	}
	
	// Gets the user's ID
	public String getID() {
		return id;
	}
	
	// Gets the user's name
	public String getName() {
		return name;
	}
		
	// Returns whether a user has enough money to buy the item		
	public boolean checkEnoughMoney(double balance, double itemamount) {
		if ((balance - itemamount) >= 0) {
			return true;
		} else {
			return false;
		}
	}
	
	// Adjust price of item if the user has Premium account
	public double getAdjustedPrice(int a) {
		if (getPremium()) {	
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
		try {
			if(contentBought.size()==0)
				throw new NoItemsException();
			for (int i=0; i<contentBought.size(); i++) {
				System.out.println(contentBought.get(i).getName());
			}
		} catch(NoItemsException se) {
			
		}         			
	}

	// Once a user has successfully bought an item it is added to the user's contentBought arrayList	
	public void addContentBought(Content a) {
		contentBought.add(a);
	}

	
	// Become a premium user 
	public void becomePremium(){							  				
		System.out.println("");
		System.out.println("#### FOR TESTING ONLY :: BECOMING PREMIUM USER ####");
		System.out.println(name+" is trying to become a premium user");
		System.out.println(name+" has a starting balance of $"+balance);	
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
			System.out.println("\n"+name + " your premium status has now been upgrade! Your discount level is now "+(int)(getDiscount()*100)+"%.");		

		} catch (AlreadyPremiumException se) {
			 errorMessage = se.getMsg();
			 System.out.println(errorMessage);
			
		} catch (BalanceTooLowException se) {			
			errorMessage = se.getMsg() + "to become a premium member. Premium costs $" + (int)se.getCost() +"." ;
			System.out.println(errorMessage);
			
		} finally {
			System.out.println(name+" your balance is now $"+df.format(balance));
		}		
	}
	
	

	// Buy an item 
	public void buyContent(Content c) {	
				
		// TESTING
		System.out.println("");
		System.out.println("#### FOR TESTING ONLY :: BUYING AN OBJECT ####");
		System.out.println(name+" is trying to buy "+c.getName());
		System.out.println(c.getName()+" costs (BEFORE CHECKING PREMIUM) $"+c.getPrice());
		System.out.println(name+" has a starting balance of $"+balance);
		
		// Set the item price (adjusted for discount if premium member)		
		double itemprice = getAdjustedPrice(c.price);
		
		System.out.println(c.getName()+" costs (AFTER CHECKING PREMIUM) $"+df.format(itemprice)+" as "+name+"'s premium status is "+premiumUser);
		 
		try {	
			
			// Check if the user has enough money to buy the item
			if (checkEnoughMoney(getBalance(), itemprice) == false) {
				 throw new BalanceTooLowException(getBalance(), itemprice);
			}	
			
			if ((c instanceof Game) && (os.getPlatform()!=((Game) c).getPlatform())) {
				throw new IncorrectPlatformException(((Game) c).getPlatform(), os.getPlatform());
			}
			
			if ((c instanceof Game) && (os.getVersion() < ((Game) c).getVersion())) {
				throw new VersionOutOfDateException((((Game) c).getVersion()),os.getVersion());
			}
			

			deductBalance(itemprice);
			c.addDownload();
			addContentBought(c);
			//System.out.println(" ");
			System.out.println(name+" has bought "+c.name+" for the price of $"+df.format(itemprice)+".\nThis item has now been download "+c.downloads+" times.");						
			System.out.println(name+" has a end balance of $"+balance);
		}
		
		
		
		
		catch (BalanceTooLowException se) {
			errorMessage = "Sorry "+name+se.getMsg() + "to buy " +c.getName()+"This item costs $" + (int)se.getCost() +"." ;
			System.out.println(errorMessage);			
		}	
		
		catch(IncorrectPlatformException se) {
			errorMessage = se.getMsg();
			System.out.println(errorMessage);
		}
		
		catch(VersionOutOfDateException se) {
			errorMessage = se.getMsg();
			System.out.println(errorMessage);
		}
			
	
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
			// If the user has enough money buy the item and then increment the download count						
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
