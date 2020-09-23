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
		System.out.println("Bag length: " + bag.length);
		
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
			
			return false;
			
		}
		
		bag[index] = bag[size-1]; //replaces removing element with last element
		bag[size-1] = null;
		
		size--;
		return true;
		
	}
	
	/**
	Calculates the sum of the prices in the bag.
	@return salesTotal The sum of the prices of each item in the bag
	*/
	public double salesPrice() {
		double salesTotal = 0;
		
		
		for (int i = 0; i < size; i++) {
			salesTotal = salesTotal + bag[i].getPrice();
		}		
		
		return salesTotal;
	} 
	
	/**
	Calculates the sales tax total of the taxable items in the bag.
	@return totalTax The sales tax total of only the taxable items in the bag
	*/
	public double salesTax() {
		double totalTax = 0;
		double sumItems = 0;
		double taxRate = 0.06625;
		
		for (int i = 0; i < size; i++) {
			if (bag[i].getTaxable() == true) {
				sumItems+= bag[i].getPrice();
			}
		}
		
		totalTax = sumItems*taxRate;
		
		
		return totalTax;
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
		// TODO Auto-generated method stub
		
		

	}

}
