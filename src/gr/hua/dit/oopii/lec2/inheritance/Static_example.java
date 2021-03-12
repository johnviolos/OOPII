//**slide 6 we can call a static method with 3 ways. */
package gr.hua.dit.oopii.lec2.inheritance;
public class Static_example {
	int obj_var=0;
	public static void static_method(String input_text) {
		System.out.println("We run the static method via "+input_text +".");
		//obj_var++; It will hit an error.
	}
	
	public static void main(String args[] ){ 
		Static_example obj = new Static_example();
		obj.static_method("Object"+" (warning)");			//1. using the object.
		Static_example.static_method("Class");				//2. using the class.
		static_method("plain method of the same class");	//3. directly call
		
		
	}
}
