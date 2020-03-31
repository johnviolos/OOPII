package gr.hua.dit.oopii.lec10.threads;
//Java only supports single inheritance, so you can only extend one class.
public class HelloRunnable implements Runnable { 
	public void run() {
		System.out.println("Hello from a thread!");
	} 

	public static void main(String args[]) {
		(new Thread(new HelloRunnable())).start();
	}
} 