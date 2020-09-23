import java.text.DecimalFormat;

/**
The GroceryItem class represents the properties and methods associated with the GroceryItem object.
Properties include name, price, and whether or not GroceryItem is taxable.
Methods include getName, getPrice, getTaxable, equals, and toString (described above each respective method)
@author Joshua Atienza, Kyle Lee
*/

public class GroceryItem {
	private String name;
	private double price;
	private boolean taxable;
	
	/**
	Creates a GroceryItem with the specified name, price, and taxability.
	@param name The name of the GroceryItem
	@param price The price of the GroceryItem
	@param taxable Whether or not the GroceryItem is taxable
	*/
	public GroceryItem(String name, double price, boolean taxable) {
		this.name = name;
		this.price = price;
		this.taxable = taxable;
	}
	
	/**
	Gets the name of GroceryItem.
	@return name of GroceryItem
	*/
	public String getName() {
		return name;
	}

	/**
	Gets the price of GroceryItem.
	@return price of GroceryItem
	*/
	public double getPrice() {
		return price;
	}
	
	/**
	Gets the taxability of GroceryItem.
	@return true if GroceryItem is taxable, false otherwise
	*/
	public boolean getTaxable() {
		return taxable;
	}

	/**
	Checks if GroceryItem is equivalent to obj being compared to.
	Checks if obj is instanceof GroceryItem and if all data fields between the two objects are equivalent.
	@param obj The object being compared to a particular GroceryItem
	@return true if GroceryItem is equivalent to object, false otherwise
	*/
	// double check usage of .equals() and .compare()
	public boolean equals(Object obj){
		if (obj == this) {
			return true;
		}
		
		if (obj instanceof GroceryItem) {
			GroceryItem item = (GroceryItem) obj;	
			return name.equals(item.name) && Double.compare(price, item.price) == 0 && Boolean.compare(taxable, item.taxable) == 0; 	 
		}
		
		return false;
	}
	
	/**
	Converts GroceryItem object to String representation.
	String representation follows the format "itemName: $xx.xx : tax free."
	@return item_info The string representation of GroceryItem obejct
	*/
	public String toString() {
		
		String tax_check;
		DecimalFormat df = new DecimalFormat("##.##");
		String rounded_price = df.format(this.price);
		
		if (this.taxable == false) {
			tax_check = "tax free";
		}
		else {
			tax_check = "is taxable";
		}
		
		String item_info = this.name + ": $" + rounded_price + " : " + tax_check;
		return item_info;
		
	}
	
	
	public static void main(String[] args) {
		
		GroceryItem milk = new GroceryItem("milk", 3.645, true);
		GroceryItem milk2 = new GroceryItem("milk", 3.63, true);
		
		
		//boolean facts = milk.equals(milk2);
		
		System.out.println(milk.toString());

	}

}
