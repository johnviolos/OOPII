package lec4_typesArrays;
//Lec 2 Slide 49
import java.util.ArrayList;
import java.util.Date;


public class TypesArrayList {

public static void main(String[] args) {
	//Case 1. UpCasting because the have an inheritance relation.
	ArrayList <Human> arrayListOfHumans = new ArrayList<Human>(10); 
	arrayListOfHumans.add(0, (new Human()).setName("Magda"));
	
	System.out.println("The name is: "+arrayListOfHumans.get(0).getName());
	arrayListOfHumans.get(0).runHumaneMethod(); //It is ok.
	arrayListOfHumans.add(1, (new Employee())); //SOS UpCasting (Implicit) is accepted! 
	arrayListOfHumans.get(1).runHumaneMethod(); //array type father. Employee inherits the father method runHumaneMethod().	
	//arrayOfHumans.get(1).runEmployeeMethod(); //Undefined, because it is type of Human and we assigned an Employee object and run a method of Employee. 
	//(It understands only Humans methods as declared).
	//((Employee) arrayOfHumans.get(1)).runEmployeeMethod(); // But with Casting it is Perfect.
	
	//Case 2. We cannot assign an  (out of inheritance) class type object to an Array
	Date date = new Date();
	date.setTime(1583365418); //https://www.epochconverter.com
	System.out.println("The date is: "+date);	
	//arrayOfHumans.add(2,date);  //Even if the ArrayList is just a sequence of Pointers. We cannot assign sth out of the inheritance of the type in which we declared it.
	//arrayOfHumans.add(2,new Date());
	
	//Case 3. DownCasting type child and we assign object of type father.
	ArrayList <Employee> arrayListOfEmployee = new ArrayList<Employee>(10); 
	arrayListOfEmployee.add(0,new Employee()); //Of course accept.
	//arrayOfEmployee.add(1, new Human()); //Not accept. Except we make casting.
	//arrayOfEmployee.add(1,(Employee) new Human()); //SOS DownCasting NOT accepted. Class Cast Exception. Compiler accept it but in runtime we have exception.
	//arrayOfEmployee.add((Employee) new Date()); //Compiler will not accept it. Out of inheritance.
	//arrayOfEmployee.get(0).runEmployeeMethod();
	
	//Case 4. Java Object (The most general, the oldest ancestor): https://stackoverflow.com/questions/31019157/how-do-all-classes-inherit-from-object
	ArrayList <Object> arrayListOfObjects = new ArrayList<Object>(10); //SOS Everyone implicitly inherits from the Object class, so we can assign any type in an Object[]
	arrayListOfObjects.add(0, new Human());
	arrayListOfObjects.add(1,  new Employee());
	arrayListOfObjects.add(2, new Date());
	
	((Human)arrayListOfObjects.get(0)).runHumaneMethod(); //In fact it is DownCasting.
	((Employee)arrayListOfObjects.get(1)).runEmployeeMethod();
	System.out.println((Date)arrayListOfObjects.get(2));
	
	
}
}
