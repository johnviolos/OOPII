package lec10_threads;

class Parent implements Runnable { 
	SavingsAccount account;
	String name;
	boolean bankrupted = false;
	public Parent(String n, SavingsAccount s) {
		this.name = n;
		this.account = s;
	}

	public void run() { 
		while (true) {
			try { 
				Thread.sleep(5000);
			} catch (InterruptedException ex) {} 
			try {
				account.deposit(this.name, 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (bankrupted) {
				return;
			}
		}
	}
}