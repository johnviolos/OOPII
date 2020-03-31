package gr.hua.dit.oopii.lec10.threads;

class Child implements Runnable { 
	SavingsAccount account;
	String name;
	boolean foundajob= false;
	public Child(String n, SavingsAccount s) {
		this.name = n; 
		this.account = s;
	}


	public void run() { 
		while (true) {
			try { 
				Thread.sleep(3000);
			} catch (InterruptedException ex) {} 
			try {
				account.withdraw(this.name, 200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (foundajob) {
				return;
			}
		}
	}
}