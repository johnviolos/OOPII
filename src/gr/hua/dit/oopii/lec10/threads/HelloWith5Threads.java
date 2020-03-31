package gr.hua.dit.oopii.lec10.threads;
//slide 11
//The main method creates five threads that runs concurrently.
//The counter threadNum can be used to define different functionality to each thread.
public class HelloWith5Threads extends Thread {
static int threadNum=1;
	public void run() {
		int local_threadNum=threadNum;
		threadNum++;
		for(int i=0;i<10; i++) {
			try {
				
				System.out.println("I am in the Thread "+local_threadNum+" method for " + (i+1) + " time."); 
				Thread.sleep(1000*local_threadNum);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
		}
	}

	public static void main(String args[]) {
		for (int i=0; i<5; i++) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("threadNum: "+threadNum);
		(new HelloWith5Threads()).start();
		}
		

	}
	
}