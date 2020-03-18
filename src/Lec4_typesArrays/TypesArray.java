package Lec4_typesArrays;
//Lec 2 Slide 49
import java.util.Date;


public class TypesArray {

public static void main(String[] args) {
	//Case 1. UpCasting because the have an inheritance relation.
	Human[] arrayOfHumans = new Human[10]; 
	arrayOfHumans[0] = new Human();
	arrayOfHumans[0].setName("Magda");
	System.out.println("The name is: "+arrayOfHumans[0].getName());
	arrayOfHumans[0].runHumaneMethod(); //It is ok.
	arrayOfHumans[1] = new Employee(); //SOS UpCasting (Implicit) is accepted! 
	arrayOfHumans[1].runHumaneMethod(); //array type father. Employee inherits the father method runHumaneMethod().	
	//arrayOfHumans[1].runEmployeeMethod(); //Undefined, because it is type of Human and we assigned an Employee object and run a method of Employee. 
	//(It understands only Humans methods as declared).
	//((Employee) arrayOfHumans[1]).runEmployeeMethod(); // But with Casting it is Perfect.
	
	//Case 2. We cannot assign an  (out of inheritance) class type object to an Array
	Date date = new Date();
	date.setTime(1583365418); //https://www.epochconverter.com
	System.out.println("The date is: "+date);	
	//arrayOfHumans[2] = date;  //Even if the Array is just a sequence of Pointers. We cannot assign sth out of the inheritance of the type in which we declared it.
	//arrayOfHumans[2] = new Date();
	
	//Case 3. DownCasting type child and we assign object of type father.
	Employee[] arrayOfEmployee = new Employee[10]; 
	arrayOfEmployee[0] = new Employee(); //Of course accept.
	//arrayOfEmployee[1] = new Human(); //Not accept. Except we make casting.
	//arrayOfEmployee[1] = (Employee) new Human(); //SOS DownCasting NOT accepted. Class Cast Exception. Compiler accept it but in runtime we have exception.
	//arrayOfEmployee[1] = (Employee) new Date(); //Compiler will not accept it. Out of inheritance.
	//arrayOfEmployee[1].runEmployeeMethod();
	
	//Case 4. Java Object (The most general, the oldest ancestor): https://stackoverflow.com/questions/31019157/how-do-all-classes-inherit-from-object
	Object[] arrayOfObjects = new Object[10]; //SOS Everyone implicitly inherits from the Object class, so we can assign any type in an Object[]
	arrayOfObjects[0] =  new Human();
	arrayOfObjects[1] =  new Employee();
	arrayOfObjects[2] =  new Date();
	
	((Human)arrayOfObjects[0]).runHumaneMethod(); //In fact it is DownCasting.
	((Employee)arrayOfObjects[1]).runEmployeeMethod();
	System.out.println((Date)arrayOfObjects[2]);
	
	
}
}
