package gr.hua.dit.oopii.lec10.threads;

public class SavingsAccount {
	private float balance;
	public synchronized void withdraw(String name, float anAmount) throws InterruptedException {
		
		if ((anAmount>0.0) && (anAmount<=balance)) { 
			balance = balance - anAmount;
			System.out.println(name+" withdraws: "+anAmount);
			System.out.println("Current balance: "+balance);
			notify();
		} else 
			wait();
	}
	
	public synchronized void deposit(String name, float anAmount) throws InterruptedException {
		
		if (anAmount>0.0) {
			balance = balance + anAmount;
			System.out.println(name+" deposits: "+anAmount);
			System.out.println("Current balance: "+balance);
			notify();			
		} else 
			wait();
	}
}
