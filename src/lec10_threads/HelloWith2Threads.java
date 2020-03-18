package lec10_threads;
//slide 10
//We have the main and one other thread to run concurrently. 
public class HelloWith2Threads extends Thread {

	public void run() {
		
		for(int i=0;i<10; i++) {
			try {
				System.out.println("I am in the Thread method for " + (i+1) + " time."); 
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
		}
	}

	public static void main(String args[]) {
		(new HelloWith2Threads()).start();
		
		for(int i=0;i<10; i++) {
			try {
				System.out.println("I am in the main method for " + (i+1) + " time."); 
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
		}
	}
	
}