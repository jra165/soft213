import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Shopping {
	
	//private int runningTotal = 0;
	//private double salesTax = 0.06625;
	
	public void run() {
		
		System.out.println("Let's start shopping!");
		try {
			Scanner sc = new Scanner(new File("src/TestCases.txt"));
			
			while(sc.hasNext()) {
				
				String str = sc.nextLine();
				String[] splitStr = str.split(" ");
				
				//check for invalid command
				if(!(splitStr[0].equals("A")) || !(splitStr[0].equals("R")) || !(splitStr[0].equals("P")) || !(splitStr[0].equals("C")) || !(splitStr[0].equals("Q"))) {		
					System.out.println("Invalid command!");
				}
				
				//add
				if(splitStr[0].equals("A")) {
					
					

					
				}
				
				//remove from bag
				else if(splitStr[0].equals("R")) {
					
					
					
				}
				
				//display items in bag
				else if(splitStr[0].equals("P"))  {
					
					
					
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
	
	

	
	private void updateTotal(String price) {
		
		
		
		
	}
	
	
	public static void main(String[] args) {
		


	}
	
}