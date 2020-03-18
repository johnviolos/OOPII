package lec4_typesOfArrays;
//slide 7
public class Human {
	String name,surname;
	int age;
	public Human(String arg){}
	public Human(){
		//System.out.println("Begin of Human construction."); 
		name="Unknown"; 
		surname="Unknown"; 
		age=0;		
		//System.out.println("end of Human construction."); 
	}
	
	public Human setName(String in_name) {name=in_name; return this;}
	public String getName() {return name;}
	
	public void giveName(Human h, String n){ h.setName(n);
	}

	public void runHumaneMethod() {
		System.out.println("A message from Human.");	
	}
	

}
