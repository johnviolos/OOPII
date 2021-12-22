package gr.hua.dit.oopii.lec10.threads;
//Java only supports single inheritance, so you can only extend one class.
public class HelloRunnable implements Runnable { 
	HelloRunnable(int num){ // The constructor of a class that implements the Runnable is executed.
		System.out.println("This is the construction! We took the argument: "+Integer.toString(num));
		
	} 
	public void run() {
		System.out.println("Hello from a thread!");
	} 

	public static void main(String args[]) {
		(new Thread(new HelloRunnable(5))).start();
	}
} 