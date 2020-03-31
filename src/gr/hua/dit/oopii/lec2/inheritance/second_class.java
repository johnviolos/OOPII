package gr.hua.dit.oopii.lec2.inheritance;

public class second_class extends Calculator {

	
	second_class(String name2){ super(name2,1); System.out.println("second_class constructor.");}	
	protected void finalize() throws Throwable  {
		
	       System.out.println("finalize method called"); 
	}
	
}
