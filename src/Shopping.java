import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Shopping {
	
	//private int runningTotal = 0;
	//private double salesTax = 0.06625;

	
	public void run() {
		
		ShoppingBag bag = new ShoppingBag();
		
		System.out.println("Let's start shopping!");
		try {
			
			Scanner sc = new Scanner(new File("src/TestCases.txt"));
			
			while(sc.hasNext()) {
				
				String str = sc.nextLine();
				String[] splitStr = str.split(" ");
				String name = splitStr[1];
				double price = Double.parseDouble(splitStr[2]); 
				boolean tax = Boolean.parseBoolean(splitStr[3]);
				GroceryItem item = new GroceryItem(name, price, tax);
				
				
				//check for invalid command
				if(!(splitStr[0].equals("A")) || !(splitStr[0].equals("R")) || !(splitStr[0].equals("P")) || !(splitStr[0].equals("C")) || !(splitStr[0].equals("Q"))) {		
					System.out.println("Invalid command!");
				}
				
				//add
				if(splitStr[0].equals("A")) {
					
					bag.add(item);
					System.out.println(name + " added to the bag.");
					
				}
				
				//remove from bag
				else if(splitStr[0].equals("R")) {
					
					bag.remove(item);
					
				}
				
				//display items in bag
				else if(splitStr[0].equals("P"))  {
					
					bag.print();
					
				}

				//checkout
				else if(splitStr[0].equals("C"))  {
					
					
					
				}
				
				//quit program and automatically checkout
				else if(splitStr[0].equals("Q"))  {
					
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