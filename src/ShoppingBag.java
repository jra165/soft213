
public class ShoppingBag {
	private GroceryItem[] bag; // array-based implementation of the bag
	private int size; // number of items currently in the bag
	private int capacity = 5; // current capacity
	
	public ShoppingBag() { }
	
	
	private int find(GroceryItem item) {  // helper method to find an item
		
		for (int i = 0; i < bag.length; i++) {
			if (item.equals(bag[i])) {
				return i;
			}
		}
		
		System.out.println("Error");
		return -1;
		
	}
	
	private void grow() {  // helper method to grow the capacity
		
		GroceryItem[] newBag = new GroceryItem[bag.length+5];
		bag = newBag;
	}
	
	
	public void add(GroceryItem item) { 
		for (int i = 0; i < bag.length; i++) {
			if (bag[i] == null) {
				bag[i] = item;
				break;
			}
		}
		size++;
	}
	
	//we rushed this shit, come back
	public boolean remove(GroceryItem item) { 
		
		int index = find(item);
		
		if(index == -1 || size < 1) {
			
			return false;
			
		}
		
		for (int i = index; i < bag.length - 1; i++) {
			bag[i] = bag[i+1];
		}
		
		size--;
		return true;
		
	}
	
	
	public double salesPrice() { // sales total; the sum of the prices in the bag
		double totalTax = salesTax();
		double salesTotal = 0;
		
		for (int i = 0; i < bag.length; i++) {
			salesTotal = salesTotal + bag[i].getPrice();
		}
		
		salesTotal = salesTotal + totalTax;
		
		return salesTotal;
	} 
	
	
	public double salesTax() { // sales tax total of the taxable items in the bag
		double totalTax = 0;
		double sumItems = 0;
		double taxRate = 0.06625;
		
		for (int i = 0; i < bag.length; i++) {
			if (bag[i].getTaxable() == true) {
				sumItems+= bag[i].getPrice();
			}
		}
		
		totalTax = sumItems*taxRate;
		
		
		return totalTax;
	} 
	
	
	//public void print() { }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
