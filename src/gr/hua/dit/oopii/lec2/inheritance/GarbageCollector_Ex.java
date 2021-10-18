package gr.hua.dit.oopii.lec2.inheritance;
//slide 16
public class GarbageCollector_Ex {
	public GarbageCollector_Ex() {System.out.println("The object created.");}
	public void finalize() {System.out.println("The object discarded.");}

	
	public static void main(String args[] ){ 
		GarbageCollector_Ex obj = new GarbageCollector_Ex();   
	System.out.println("Object hash code: "+obj.hashCode());   
	obj = null;   
	// calling garbage collector    
	//System.out.println(obj.hashCode());   //If we call obj.hashCode, we get NullPoinnterException
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("We call the garbage collection"); 
	System.gc();   
	  
	}

}
