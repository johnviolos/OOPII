package gr.hua.dit.oopii.lec2.inheritance;

import java.util.Arrays;
import java.util.List;

public class Polymorphsim {
	
public static void main(String[] args) {
	//Animal myAnimal = new Animal();  // Create a Animal object. myAnimal.animalSound();
	Animal myDeer = new Deer();  // Create a Pig object. myPig.animalSound();
	Animal myDog1 = new Dog();  // Create a Dog object. myDog.animalSound();
	Animal myDog2 = new Dog();  // Create a Dog object. myDog.animalSound();
	
	Animal [] zoo = new Animal[3];	//ArrayList of class father
	zoo[0] = myDog1; //object of class child. Eventually the method of the child runs,
	zoo[1] = myDeer;
	zoo[2] = myDog2;

	// We call the method in the ArrayList of type parent in the child-objects that override the method. Eventually the methods of children runs.
	for (int i=0; i<zoo.length; i++) {
		System.out.print(i+" animal "+zoo[i].getClass().getTypeName()+": "); zoo[i].animalSound(); // We do not declare if the obj (cell) will be Deer, Dog or generic Animal. but the right method runs.
		//zoo[i].sleepDeer(); //no The father class does not have sleepDeer() method.
		if (i==1) ((Deer)zoo[i]).sleepDeer(); //with casting it works. The method sleepDeer() works only with Deer objects so we make the casting. 
	}//We can have an array declared with superclass type and each cell will be subclass object. When we call the method, it uses Run Time Type Identification
   // and dynamically selects the correct (inherited) object method to run.

	System.out.println("\nPolymorphism works also in case of ArrayList");
	List<Animal> list = (List<Animal>) Arrays.asList(zoo);
	for (int i=0; i<list.size(); i++) {
		System.out.print(i+" animal "+list.get(i).getClass().getTypeName()+": "); list.get(i).animalSound();
		if (i==1) ((Deer)list.get(i)).sleepDeer();
		} 
}
}
abstract class  Animal {
//class Animal {
	  //public void animalSound() { //same method name with children names. 
	abstract public  void animalSound(); //{ //same method name with children names.     
		//System.out.println("The animal makes a sound");
	 // }
	  
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
	    System.out.println("The dog says: wow wow");
	  }
	  
	  public void sleepAnimal() { 
		    System.out.println("The dog is sleeping");
		  }
}