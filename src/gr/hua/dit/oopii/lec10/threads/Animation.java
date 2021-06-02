package gr.hua.dit.oopii.lec10.threads;

class Animation implements Runnable { 
	boolean finished;
	static int counter=0;
	public void run( ) {
		counter++;
		System.out.println("We run the Animation thread " + counter + ".");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("The Animation thread " + counter + " finished. ");
		finished=true; 
	}
	
	
	public static void main(String args[]) {
		Animation happy = new Animation();		//Thread
		Thread myThread = new Thread( happy );	//Controller. The controller takes as input the real thread.
		myThread.start( );						//And runs it.
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		myThread = new Thread( new Animation() ); 	//The controller is connected with another thread.
		myThread.start( );							//And we run the next thread.
		
	}
}