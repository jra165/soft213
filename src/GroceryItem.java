import java.text.DecimalFormat;

public class GroceryItem {
	private String name;
	private double price;
	private boolean taxable;
	
	public GroceryItem(String name, double price, boolean taxable) {
		this.name = name;
		this.price = price;
		this.taxable = taxable;
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public boolean getTaxable() {
		return taxable;
	}
	
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
	
	
	public String toString() {
		
		//System.out.println("entered");
		
		String tax_check;
		DecimalFormat df = new DecimalFormat("##.##");
		String rounded_price = df.format(this.price);
		
		
		if (this.taxable == false) {
			tax_check = "tax free";
		}
		else {
			tax_check = "is taxable";
		}
		
		return this.name + ": $" + rounded_price + " : " + tax_check;
		
	}
	
	public static void main(String[] args) {
		
		GroceryItem milk = new GroceryItem("milk", 3.645, true);
		GroceryItem milk2 = new GroceryItem("milk", 3.63, true);
		
		
		//boolean facts = milk.equals(milk2);
		
		System.out.println(milk.toString());

	}

}
