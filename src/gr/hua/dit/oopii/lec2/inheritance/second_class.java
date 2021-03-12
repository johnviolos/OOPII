/**Slide 29 use of finalize() as plain method is a bad practice. super-class constructors are not inherited except from the default construct that is called if we don't call super(,)*/
package gr.hua.dit.oopii.lec2.inheritance;
public class second_class extends Callculator {

	
	second_class(String name2){ // Constructor with one argument
		//super(name2,1); //By default we call the default super-class constructor. But, we can  explicitly select a different super-class constructor.
		System.out.println("second_class constructor!");
	}
	
	protected void finalize() throws Throwable  {		
	       System.out.println("finalize method called"); 
	}
	
	public static void main(String[] args ){
		second_class child1 = new second_class("child1");
		System.out.println("We call the inherited super-class method: "+child1.object_method(5, 10)); //We can call a plain super-class methods.
		//second_class child2 = new second_class("hello world", 5); //We cannot inherit super-class constructors explicitly.
		
		try {
			child1.finalize();					//We can call finalize() but it does not really terminate the object. It just runs as a plain method.
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		System.out.println("The object child1 is still alive even if we called the finalize: "+child1.object_method(5, 10));
	}
	
}
