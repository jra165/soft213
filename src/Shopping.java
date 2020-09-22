import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Shopping {
	
	//private int runningTotal = 0;
	//private double salesTax = 0.06625;

	private void checkoutBag(ShoppingBag bag) {
		double salesTotal = bag.salesPrice() + bag.salesTax();
		GroceryItem[] itemList = bag.getGroceryItemList();
		int itemListSize = bag.getSize();
		
		if (bag.getSize() == 1) {
			System.out.println("Checking out " + itemListSize + " item:");
		}
		
		else {
			System.out.println("Checking out " + itemListSize + " items:");
		}
		
		for (int i = 0; i < itemListSize; i++) {
			System.out.println(itemList[i].toString());
			
		}
		
		System.out.println("*Sales total: $" + bag.salesPrice());
		System.out.println("*Sales tax: $" + bag.salesTax());
		System.out.println("*Total amount paid: $" + salesTotal);
		
		itemList = null;
		itemListSize = 0;
		// shrink the bag????
		
	}
	
	
	public void run() {
		
		ShoppingBag bag = new ShoppingBag();
		
		System.out.println("Let's start shopping!");
		try {
			
			Scanner sc = new Scanner(new File("src/TestCases.txt"));
			
			while(sc.hasNext()) {
				
				String str = sc.nextLine();
				String[] splitStr = str.split(" "); // Also need to check multiple white spaces and tabs
				String action = splitStr[0];
				String name = splitStr[1];
				double price = Double.parseDouble(splitStr[2]); 
				boolean tax = Boolean.parseBoolean(splitStr[3]);
				GroceryItem item = new GroceryItem(name, price, tax);
				
				
				//check for invalid command
				if(!(action.equals("A")) || !(action.equals("R")) || !(action.equals("P")) || !(action.equals("C")) || !(action.equals("Q"))) {		
					System.out.println("Invalid command!");
				}
				
				//add
				if(action.equals("A")) {
					
					bag.add(item);
					System.out.println(name + " added to the bag.");
					
				}
				
				//remove from bag
				//does our remove cover only removing the first instance of it
				//where do we put the error message, here or in the actual remove method
				else if(action.equals("R")) {
					
					if (bag.remove(item)) {
						System.out.println(name + " $" + price + " removed.");
					}
					else {
						System.out.println("Unable to remove, this item is not in the bag.");
					}
					
				}
				
				//display items in bag
				else if(action.equals("P"))  {
					
					bag.print();
					
				}

				//checkout
				else if(action.equals("C"))  {
					
					if (bag.getSize() < 1) {
						System.out.println("Unable to check out, the bag is empty!");
					}
					else {
						checkoutBag(bag);
					}
					
					
				}
				
				//quit program and automatically checkout
				else if(action.equals("Q"))  {
					
					if (bag.getSize() >= 1) {
						checkoutBag(bag);
					}
					else {
						System.out.println("Thank you for shopping with us!");
					}
							
					break;
		
				}
				
			}
			
			
			sc.close();
			
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	public static void main(String[] args) {
		


	}
	
}