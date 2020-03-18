package lec10_threads;

public class FamilyDemo {
	
	public static void main(String args[]) throws InterruptedException{
		SavingsAccount acc=new SavingsAccount();
		acc.deposit("bank", 1000);
		Parent p=new Parent("Bill",acc);
		Child c1=new Child("John",acc);
		Child c2=new Child("Mary",acc);
		new Thread(p).start();
		new Thread(c1).start();
		new Thread(c2).start();
		Child c3=new Child("Martha",acc);
		Child c4=new Child("Magda",acc);
		//Child c5=new Child("Kon",acc);
		//Child c6=new Child("Orestis",acc);
		new Thread(c3).start();
		new Thread(c4).start();
		//new Thread(c5).start();
		//new Thread(c6).start();
		
	}

}
