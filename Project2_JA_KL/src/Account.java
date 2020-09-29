
public abstract class Account {

	private Profile holder;
	private double balance;
	private Date dateOpen;
	
	public void debit(double amount) { }
	public void credit(double amount) {}
	public String toString() {}
	public abstract double monthlyInterest();
	public abstract double monthlyFee();
	
	public static void main(String[] args) {
		
		
	}

}
