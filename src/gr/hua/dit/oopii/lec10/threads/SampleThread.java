package gr.hua.dit.oopii.lec10.threads;
//https://www.baeldung.com/java-thread-join
class SampleThread extends Thread {
    public int processingCount = 5;
    private String name;

    SampleThread(int processingCount, String name) {
        this.processingCount = processingCount;
        this.name=name;
    }

    @Override
    public void run() {
        while (processingCount > 0) {
            try {
            	System.out.println("We run the: "+this.name);
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
            processingCount--;
        }
    }

public static void main(String args[]) {
	try {
		givenStartedThread_whenJoinCalled_waitsTillCompletion();
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
}

public static void givenStartedThread_whenJoinCalled_waitsTillCompletion() 
  throws InterruptedException {
	System.out.println("We are in the main.");
    Thread t1 = new SampleThread(5,"thread-1");
    Thread t2 = new SampleThread(8,"thread-2");
    t1.start();
    t2.start();

    t1.join();
    t2.join();
    System.out.println("Returned from join");

}

}