package gr.hua.dit.oopii.lec2.inheritance;

public class Polymorphsim {
	
public static void main(String[] args) {
	Animal myAnimal = new Animal();  // Create a Animal object. myAnimal.animalSound();
	Animal myDeer = new Deer();  // Create a Pig object. myPig.animalSound();
	Animal myDog = new Dog();  // Create a Dog object. myDog.animalSound();
	
	Animal [] zoo = new Animal[3];
	zoo[0] = myAnimal;
	zoo[1] = myDeer;
	zoo[2] = myDog;
	
	for (int i=0; i<zoo.length; i++) {
		System.out.print(i+" animal "+zoo[i].getClass().getTypeName()+": "); zoo[i].animalSound(); // We do not declare if the obj (cell) will be Deer, Dog or generic Animal. but the right method runs.
		//zoo[i].sleepDeer(); //no
		((Deer)zoo[1]).sleepDeer(); //with casting it works
	}//We can have an array declared with superclass type and each cell will be subclass object. When we call the method, it uses Run Time Type Identification
}   // and dynamically selects the correct (inherited) object method to run.

}

class Animal {
	  public void animalSound() { //same method name with children names. 
	    System.out.println("The animal makes a sound");
	  }
	  
	  public void sleepAnimal() { //Different method name with children names. 
		    System.out.println("The animal is sleeping");
		  }
}

class Deer extends Animal {
	  public void animalSound() {
	    System.out.println("The Deer says: wee wee");
	  }
	  public void sleepDeer() {
		    System.out.println("The Deer is sleeping");
		  }
}

class Dog extends Animal {
	  public void animalSound() {
	    System.out.println("The dog says: bow wow");
	  }
	  
	  public void sleepAnimal() { 
		    System.out.println("The dog is sleeping");
		  }
}