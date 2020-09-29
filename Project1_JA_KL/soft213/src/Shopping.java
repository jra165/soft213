import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
The Shopping class is the user interface class that handles inputs commands, outputs data, and messages. 
Input commands should begin with either A, R, P, C, Q as standalone strings.
Assume that commands beginning with A or R are followed by item name, price, and taxability.
Commands beginning with P, C, or Q should stand alone and should not be followed by any other characters.
@author Joshua Atienza, Kyle Lee
*/

public class Shopping {
	
	/**
	Checks out GroceryItems within the bag.
	List items in the bag being checked out.
	Calculates sales price, sales tax, and total amount paid accordingly.
	@param bag The ShoppingBag of items being checked out
	@return bag A new empty ShoppingBag with the default data fields
	*/
	private ShoppingBag checkoutBag(ShoppingBag bag) {
		
		DecimalFormat df = new DecimalFormat("0.00");
		double salesTotal = bag.salesPrice() + bag.salesTax();
		GroceryItem[] itemList = bag.getGroceryItemList();
		int itemListSize = bag.getSize();
		
		if (bag.getSize() == 1) {
			System.out.println("**Checking out " + itemListSize + " item:");
		}
		
		else {
			System.out.println("**Checking out " + itemListSize + " items:");
		}
		
		for (int i = 0; i < itemListSize; i++) {
			System.out.println(itemList[i].toString());
			
		}
		
		
		System.out.println("*Sales total: $" + df.format(bag.salesPrice()));
		System.out.println("*Sales tax: $" + df.format(bag.salesTax()));
		System.out.println("*Total amount paid: $" + df.format(salesTotal));
		
		
		bag = new ShoppingBag();
		
		return bag;
		
	}
	
	/**
	Runs the project, reads text file with input commands, and returns outputs/messages accordingly.
	*/
	public void run() {
		
		ShoppingBag bag = new ShoppingBag();
		
		System.out.println("Let's start shopping!");
			
		Scanner sc = new Scanner(System.in); 				//create a scanner object
		
		while(sc.hasNext()) {								//reads keyboard input
			
			String[] inputArr = new String[4];
			String str = sc.nextLine().trim();
			StringTokenizer st = new StringTokenizer(str);
			
			
			int count = 0;
			while (st.hasMoreTokens() && count < 4) {
		    	inputArr[count] = st.nextToken();			//appends current token to inputArr
		    	count++;
		    }
			
			String action = "";
			String name = "";
			double price = 0;
			boolean tax = false;
			
			// iterate through inputArr which contains tokens from string input line and sets above variables to casted values 
			for(int i = 0; i < inputArr.length; i++) {
				
				if(i == 0 && inputArr[0] != null) {
					action = inputArr[0];
					
					if(!(action.equals("A")) && !(action.equals("R")) && !(action.equals("P")) 
							&& !(action.equals("C")) && !(action.equals("Q"))) {	
						break;
					}
					
				}
				else if(i == 1 && inputArr[1] != null) {
					name = inputArr[1];
				}
				else if(i == 2 && inputArr[2] != null) {
					price = Double.parseDouble(inputArr[2]);
				}
				else if(i == 3 && inputArr[3] != null) {
					tax = Boolean.parseBoolean(inputArr[3]);
				}
				
			}
			
		    
			GroceryItem item = new GroceryItem(name, price, tax);
			
			//check for invalid command
			if((!(action.equals("A")) && !(action.equals("R")) && !(action.equals("P")) 
					&& !(action.equals("C")) && !(action.equals("Q")))) {	
				System.out.println("Invalid command!");
			}
			
			
			if(action.equals("A")) {			//add item to bag
				
				bag.add(item);
				
			}
			
			else if(action.equals("R")) {		//remove item from bag
				
				bag.remove(item);
				
			}
			
			else if(action.equals("P"))  {		//display item from bag
				
				bag.print();
				
			}

			else if(action.equals("C"))  { 		//checkout items in bag
				
				if (bag.getSize() < 1) {
					System.out.println("Unable to check out, the bag is empty!");
				}
				else {
					bag = checkoutBag(bag);
				}
					
			}
			
			else if(action.equals("Q"))  { 		//quit program and automatically checkout
				
				if (bag.getSize() >= 1) {
					bag = checkoutBag(bag);
				}
				
				System.out.println("Thank you for shopping with us!");
				
				break;
	
			}
				
		}
			
			
			sc.close();
			
	}
		
}