import java.text.DecimalFormat;

/**
The ShoppingBag class represents a shopping bag as an array of items.
Property of ShoppingBag is size.
Methods associated with ShoppingBag are getGroceryItemList, getSize, find, grow,
add, remove, salesTax, salesPrice, printItems (described above each respective method)
@author Joshua Atienza, Kyle Lee
*/

public class ShoppingBag {
	private GroceryItem[] bag = new GroceryItem[5];
	private int size = 0;
	
	/**
	Creates a ShoppingBag with null array of size 5.
	*/
	public ShoppingBag() { }
	
	
	/**
	Gets the array of GroceryItem objects associated with the ShoppingBag.
	@return bag The array-based implementation of the bag
	*/
	public GroceryItem[] getGroceryItemList() {
		return bag;
	}
	
	/**
	Gets the size of the ShoppingBag.
	@return size The number of items currently in the ShoppingBag
	*/
	public int getSize() {
		return size;
	}
	
	/**
	Finds a specific item in the bag and returns its index in the array.
	Performs a linear search for the target item.
	@param item The GroceryItem being searched for
	@return i The index of the found item, -1 if item does not exist in the bag
	*/
	private int find(GroceryItem item) {
		
		for (int i = 0; i < bag.length; i++) {
			if (item.equals(bag[i])) {
				return i;
			}
		}
		
		return -1;
		
	}
	
	/**
	Grows the capacity of the bag by copying over object references from old array to new array.
	Capacity of the bag increases by 5 when grow() is called.
	*/
	private void grow() {
		
		GroceryItem[] temp = bag;
		bag = new GroceryItem[bag.length+5];
		
		for (int i = 0; i < temp.length; i++) {
			bag[i] = temp[i];
		}
		
	}
	
	/**
	Adds specified GroceryItem to bag.
	GroceryItem is added in the next immediately available index within the array, and size field increases by 1.
	@param item The GroceryItem being added to the bag
	*/
	public void add(GroceryItem item) { 
		for (int i = 0; i < bag.length; i++) {
			if (bag[i] == null) {
				bag[i] = item;
				break;
			}
		}
		size++;
		
		if (size%5 == 0) { //checks whether the bag is full or not
			grow();
		}
		
		System.out.println(item + " added to the bag.");
		
	}

	
	/**
	Removes specified GroceryItem from bag.
	Replaces the removing element with the last element, and size field decreases by 1.
	@param item The GroceryItem being removed from the bag
	@return true if GroceryItem successfully removed, false if GroceryItem not found found or bag empty
	*/
	public boolean remove(GroceryItem item) { 
		
		int index = find(item);
		
		
		if(index == -1 || size < 1) { //checks if item not found or bag empty
			System.out.println("Unable to remove, this item is not in the bag.");
			return false;
			
		}
		
		bag[index] = bag[size-1]; //replaces removing element with last element
		bag[size-1] = null;
		
		size--;
		System.out.println(item + " $" + item.getPrice() + " removed.");
		return true;
		
	}
	
	/**
	Calculates the sum of the prices in the bag.
	@return salesTotal The sum of the prices of each item in the bag
	*/
	public double salesPrice() {
		
		DecimalFormat df = new DecimalFormat("0.00");
		double salesTotal = 0;
		
		
		for (int i = 0; i < size; i++) {
			salesTotal = salesTotal + bag[i].getPrice();
		}		
		
		String strSalesTotal = df.format(salesTotal);
		
		return Double.parseDouble(strSalesTotal);
	} 
	
	/**
	Calculates the sales tax total of the taxable items in the bag.
	@return totalTax The sales tax total of only the taxable items in the bag
	*/
	public double salesTax() {
		
		DecimalFormat df = new DecimalFormat("0.00");
		double totalTax = 0;
		double sumItems = 0;
		final double taxRate = 0.06625;
		
		for (int i = 0; i < size; i++) {
			if (bag[i].getTaxable() == true) {
				sumItems+= bag[i].getPrice();
			}
		}
		
		totalTax = sumItems*taxRate;
		String strSalesTax = df.format(totalTax);
		
		return Double.parseDouble(strSalesTax);
	} 
	
	/**
	Prints string representation of each item in the bag.
	Adjusts grammar of printed statement according to number of items in bag.
	*/
	public void print() {
		
		if(size < 1) { //empty bag
			
			System.out.println("The bag is empty!");
			
		}
		
		else {
			
			if(size == 1) { //singular grammar
				
				System.out.println("You have " + size + " item in the bag:");
				System.out.println(bag[0].toString());
				System.out.println("**End of list");
				
			}
			
			else { //plural grammar
				System.out.println("You have " + size + " items in the bag:");
				for(int i = 0; i < size; i++) {
					
					System.out.println(bag[i].toString());
					
				}
				System.out.println("**End of list");
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		
		// TESTBED MAIN
		
		GroceryItem milk = new GroceryItem("milk", 2.50, true);
		GroceryItem eggs = new GroceryItem("eggs", 1.99, false);
		GroceryItem toast = new GroceryItem("toast", 3.14, true);
		GroceryItem meat = new GroceryItem("meat", 7.99, true);
		GroceryItem bread = new GroceryItem("bread", 3.99, true);
		GroceryItem jelly = new GroceryItem("jelly", 3.99, true);
		
		// Constructors
		ShoppingBag traderJoes = new ShoppingBag();
		ShoppingBag target = new ShoppingBag();
		ShoppingBag wegmans = new ShoppingBag();
		
		// ADD METHOD //
		
		// ShoppingBag.add() : Test Case 1 -> Add an item into bag normally 
		System.out.println("##--ADD Method: Test Case 1 (Add MILK in ShoppingBag instance)--##");
		traderJoes.add(milk);
		
		// ShoppingBag.add() : Test Case 2 -> Add an item into bag and size%5 == 0 (Requires GroceryItem.grow())
		System.out.println("##--ADD Method: Test Case 2 (Add EGGS, TOAST, MEAT, and BREAD in ShoppingBag to check if bag grows)--##");
		traderJoes.add(eggs);
		traderJoes.add(toast);
		traderJoes.add(meat);
		traderJoes.add(bread);
		System.out.println("BAG CAPACITY: " + traderJoes.bag.length);
		
		
		// GROW METHOD //
		
		// ShoppingBag.grow() : Test Case 1 -> Bag inherently grows when size%5 == 0 (Builds off of test case 2 of Add)
		System.out.println("##--GROW Method: Test Case 1 (Check to see if bag grows by 5 given size%5 == 0)--##");
		System.out.println("BAG CAPACITY: " + traderJoes.bag.length);
		System.out.println("CURRENT # ITEMS IN BAG: " + traderJoes.size);
		
		
		
		// FIND METHOD //
		
		// ShoppingBag.find() : Test Case 1 -> Find an item that exists in the bag
		System.out.println("##--FIND Method: Test Case 1 (Check to see if item exists in bag for normal case)--##");
		int index = traderJoes.find(eggs);
		System.out.println("Index of " + eggs.getName() + ": " + index);
		
		
		// ShoppingBag.find() : Test Case 2 -> Find an item that DOES NOT exist in the bag (returns -1)
		System.out.println("##--FIND Method: Test Case 2 (Check to see if item exists in bag when it does not exist)--##");
		index = traderJoes.find(jelly);
		System.out.println("Index of " + jelly.getName() + ": " + index);
		
		
		// REMOVE METHOD //
		
		// ShoppingBag.remove() : Test Case 1 -> Remove an item from a bag normally
		System.out.println("##--REMOVE Method: Test Case 1 (Remove EGGS from ShoppingBag instance)--##");
		System.out.println("STATUS: " + traderJoes.remove(eggs));
		System.out.println("CURRENT # ITEMS IN BAG: " + traderJoes.size);
		
		// ShoppingBag.remove() : Test Case 2 -> Remove an item from a bag when it does not exist
		System.out.println("##--REMOVE Method: Test Case 2 (Remove JELLY from ShoppingBag instance traderJoes)--##");
		System.out.println("STATUS: " + traderJoes.remove(jelly));
		System.out.println("CURRENT # ITEMS IN BAG: " + traderJoes.size);
		
		// ShoppingBag.remove() : Test Case 2 -> Remove an item from a bag when it is empty
		System.out.println("##--REMOVE Method: Test Case 3 (Remove JELLY from ShoppingBag instance wegmans)--##");
		System.out.println("STATUS: " + wegmans.remove(jelly));
		System.out.println("CURRENT # ITEMS IN BAG: " + wegmans.size);
		
		
		// SALESTAX METHOD //
		
		// ShoppingBag.salesTax() : Test Case 1 -> Calculate sales tax of bag
		System.out.println("##--SALESTAX Method: Test Case 1--##");
		System.out.println("Sales Tax: " + "$" + traderJoes.salesTax());
		
		
		// SALESPRICE METHOD // 
		
		// ShoppingBag.salesPrice() : Test Case 1 -> Calculate sales price of bag
		System.out.println("##--SALESPRICE Method: Test Case 1--##");
		System.out.println("Sales Price: " + "$" + traderJoes.salesPrice());
		
		
		// PRINT METHOD //
		
		// ShoppingBag.print() : Test Case 1 -> Empty bag
		System.out.println("##--PRINT Method: Test Case 1--##");
		target.print();
		
		// ShoppingBag.print() : Test Case 2 -> One item in bag
		System.out.println("##--PRINT Method: Test Case 2--##");
		wegmans.add(jelly);
		wegmans.print();
		
		// ShoppingBag.print() : Test Case 3 -> Multiple items in bag
		System.out.println("##--PRINT Method: Test Case 3--##");
		traderJoes.print();
		
		

	}

}
