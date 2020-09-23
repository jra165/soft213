import java.text.DecimalFormat;

public class ShoppingBag {
	private GroceryItem[] bag = new GroceryItem[5]; // array-based implementation of the bag
	private int size = 0; // number of items currently in the bag
	private int capacity = 5; // current capacity
	
	public ShoppingBag() { }
	
	
	// Getter methods for retrieving private variables from different classes
	public GroceryItem[] getGroceryItemList() {
		return bag;
	}
	
	public int getSize() {
		return size;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	
	private int find(GroceryItem item) {  // helper method to find an item
		
		for (int i = 0; i < bag.length; i++) {
			if (item.equals(bag[i])) {
				return i;
			}
		}
		
		//System.out.println("Error");
		return -1;
		
	}
	
	private void grow() {  // helper method to grow the capacity
		
		GroceryItem[] temp = bag;
		bag = new GroceryItem[bag.length+5];
		System.out.println("Bag length: " + bag.length);
		capacity = capacity + 5;
		//newBag = bag;
		
		for (int i = 0; i < temp.length; i++) {
			bag[i] = temp[i];
		}
		
		//System.out.println("Bag length2: " + bag.length);
		//System.out.println("Bag Size: " + bag.length);
		//System.out.println("Capacity: " + capacity);
	}
	
	
	public void add(GroceryItem item) { 
		for (int i = 0; i < bag.length; i++) {
			if (bag[i] == null) {
				bag[i] = item;
				break;
			}
		}
		size++;
		
		// Check whether the bag is full or not
		if (size%5 == 0) {
			//System.out.println("HERE");
			//System.out.println("Size: " + size);
			grow();
		}
		
	}
	
	//we rushed this shit, come back
	public boolean remove(GroceryItem item) { 
		
		int index = find(item);
		
		if(index == -1 || size < 1) {
			
			return false;
			
		}
		
		bag[index] = bag[size-1];
		bag[size-1] = null;
		//for (int i = index; i < bag.length - 1; i++) {
		//	bag[i] = bag[i+1];
		//}
		
		size--;
		return true;
		
	}
	
	
	public double salesPrice() { // sales total; the sum of the prices in the bag
		//double totalTax = salesTax();
		double salesTotal = 0;
		//DecimalFormat df = new DecimalFormat("##.##");
		
		
		for (int i = 0; i < size; i++) {
			salesTotal = salesTotal + bag[i].getPrice();
		}
		//double salesTotalRounded = df.format(salesTotal);
		
		//salesTotal = salesTotal + totalTax;
		
		
		return salesTotal;
	} 
	
	
	public double salesTax() { // sales tax total of the taxable items in the bag
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
	
	
	public void print() { //print each item in bag
		
		if(size < 1) {
			
			System.out.println("The bag is empty!");
			
		}
		
		else {
			
			//singular grammar
			if(size == 1) {
				
				System.out.println("You have " + size + " item in the bag:");
				System.out.println(bag[0].toString());
				System.out.println("**End of list");
				
			}
			
			//plural grammar
			else {
				System.out.println("You have " + size + " items in the bag:");
				for(int i = 0; i < size; i++) {
					
					//System.out.println("Check: " + bag[i].getName());
					//System.out.println("Check: " + bag[i].getPrice());
					//System.out.println("size: " + size);
					//System.out.println(bag[i].getName());
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
