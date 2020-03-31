package gr.hua.dit.oopii.lec2.inheritance;
//slide 7
public class Human {
	String name,surname;
	int age;
	public Human(String arg){}
	public Human(){
		System.out.println("Begin of Human construction."); 
		name="Unknown"; 
		surname="Unknown"; 
		age=0;		
		System.out.println("end of Human construction."); 
	}
	
	public void setName(String in_name) {name=in_name;}
	public String getName() {return name;}
	
	public void giveName(Human h, String n){ h.setName(n);
	}

	public void runHumaneMethod() {
		System.out.println("A message from Human.");	
	}
	
	public static void main(String args[] ){ 
		
		Human nonos=new Human(); 
		Human paidi=new Human(); 
		nonos.giveName(paidi, "Mary"); //The change of obj status will remain.
		System.out.println("The name of obj paidi is "+paidi.getName()); 

	}
}
