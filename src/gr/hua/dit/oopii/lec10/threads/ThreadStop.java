package gr.hua.dit.oopii.lec10.threads;
//Slide 13 & 15 Terminate a Thread. 
//A counter will be used to finish a thread. 
public class ThreadStop implements Runnable { 
	static int counter = 0;
	static boolean finished =false;
	static public void setCounter(int in_counter) { 
		counter =in_counter;
	}
	
	public void run() {
		System.out.println("The thread begun");
		while (true) {
			
			System.out.println("Hello from a thread!");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (counter>=7)
				break;
		}
		System.out.println("The thread finished");
		finished=true;
	} 

	public static void main(String args[]) {
		(new Thread(new ThreadStop())).start();
		
		for (int i=0; i<20; i++) {
			setCounter(i);	
			try {
				System.out.println("Counter: " + i);
				System.out.println("Finished: " + finished);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
} 