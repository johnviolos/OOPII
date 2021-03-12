//**slide 7 we pass an object as argument. */
package gr.hua.dit.oopii.lec2.inheritance;
public class Human {
	private String human_data="Hard coded private data";
	private String name,surname;
	private int  age;
	
	public Human(String arg){}	//1st constructor
	
	public Human(){				//2nd constructor
		System.out.println("Begin of Human construction."); 
		name="Unknown"; 
		surname="Unknown"; 
		age=0;		
		System.out.println("end of Human construction."); 
	}
	
	public void setName(String in_name) {
		name=in_name;
	}
	
	public String getName() {
		return name;
	}
	
	public void giveName(Human h, String n){ 
		h.setName(n);
	}

	public void runHumaneMethod() {
		System.out.println("A message from Human.");	
	}
	
	public String getCompleteData() {
		return human_data;
	}
	
	private String private_method() {
		return "Private method.";
	}
	
	public static void main(String args[] ){ 
		
		Human nonos=new Human(); 					//object nonos
		Human paidi=new Human(); 					//object paidi
		nonos.giveName(paidi, "Mary"); 				//nonos object acts on paidi object. The change of obj status will remain.
		System.out.println("The name of obj paidi is "+paidi.getName()); 

	}
}
