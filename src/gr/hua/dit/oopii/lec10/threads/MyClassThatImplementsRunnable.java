package gr.hua.dit.oopii.lec10.threads;
//slide 28
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyClassThatImplementsRunnable implements Runnable { 
	public void run() {
		System.out.println(Thread.currentThread().getName() + " Start."); 
		//processCommand(); 
		System.out.println(Thread.currentThread().getName() + " End.");
} 
	

	public static void main(String args[]) throws InterruptedException{
		ExecutorService executor = Executors.newFixedThreadPool(5); 
		Runnable worker = new MyClassThatImplementsRunnable(); 
		executor.execute(worker);	
		Runnable another_worker = new MyClassThatImplementsRunnable(); 
		executor.execute(another_worker);
		
		Runnable another_worker3 = new MyClassThatImplementsRunnable(); 
		executor.execute(another_worker3);
		Runnable another_worker4 = new MyClassThatImplementsRunnable(); 
		executor.execute(another_worker4);
		Runnable another_worker5 = new MyClassThatImplementsRunnable(); 
		executor.execute(another_worker5);
		
	}


}
