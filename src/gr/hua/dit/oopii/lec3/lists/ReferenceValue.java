/** Primitive types pass by value, collections and objects "seem to be passed by reference". 
* In fact, everything in Java is passed by value because they are pointers.
* We also have the unmodifiable collections */
package gr.hua.dit.oopii.lec3.lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import gr.hua.dit.oopii.lec2.inheritance.Human;

//slide 7
public class ReferenceValue {
 int obj_value;
 public final static List<String> public_final_strings = new ArrayList<String>();
 public static final Human human = new Human();
ReferenceValue(){
	this.obj_value=5;
}

ReferenceValue(ReferenceValue in_obj){//Easy way to duplicate an object with a constructor that copies (duplicates) all elements. 
	this.obj_value=in_obj.obj_value;
	System.out.println("Argument-object hascode is: " + in_obj.hashCode());
	System.out.println("The new-created object hascode is: " + this.hashCode());
}

public static void passPrimitiveTypes(int number) { //The changes of the primitive types inside the class do not take effect outside the class.
	number=1000;
}

public static void passObject( ReferenceValue obj , int number) {
	obj.obj_value=number;
}

public static void passObject_withNew( ReferenceValue obj) {
	ReferenceValue object2 = new ReferenceValue();
	object2.obj_value=100;
	obj=object2; //The object pointer will not change.
}

public static void passArray( int[] in_array) {

	in_array[0]=100;
	in_array[1]=100;
	in_array[2]=100;
}

public static void passObject_withfinal(final ReferenceValue obj , final int number) {
	
	//number=50;
	obj.obj_value=number;

}

public static void main(String[] args) {
	int number=5;
	System.out.println("Before call the func: Primitive types passed by value: "+number);
	passPrimitiveTypes(number);	//It adds 10 to the primitive type argument but no changes take place.
	System.out.println("After call the func: Primitive types passed by value: "+number +"\n");	//Primitive type passed by Value. 

	ReferenceValue object = new ReferenceValue();
	System.out.println(object.hashCode() + " Before call the func: Objects seems to be passed by \"reference\" "+object.obj_value); //the object's hash code, which is the object's memory address in hexadecimal.
	passObject(object,200);
	System.out.println(object.hashCode() + " After call the func: Objects seems to be passed by \"reference\": "+object.obj_value +"\n"); //Objects seems passed by "Reference". The changes took place.

	int[] in_array = {11,12,13,14,15};
	System.out.println(in_array.hashCode() + " Before call the func: Arrays also seem to be passed by \"reference\": "+in_array[0 ] +" "+ in_array[1] +" "+ in_array[2] +" "+ in_array[3] +" "+ in_array[4]);
	passArray(in_array);
	System.out.println(in_array.hashCode() + " After call the func: Arrays also seem to be passed by \"reference\": "+in_array[0 ] +" "+ in_array[1] +" "+ in_array[2] +" "+ in_array[3] +" "+ in_array[4]+"\n"); //Objects passed by "Reference".
	
	ReferenceValue object3 = new ReferenceValue(); //Reference to the values of the object. But passed with value thepointer to the object. We cannot change the object that we point.
	System.out.println(object3.hashCode() + " Before call the func: On the left we have the object's hash code, which is the object's memory address: " +object3.obj_value);
	passObject_withNew(object3); //But we can change the variables of the object that we pass in. Δεν μπορώ να δειξω σε άλλο αντικείμενο. O pointer θα δείχνει πάντα στο ιδιο object. 
	System.out.println(object3.hashCode() + " But, we cannot change the reference (pointer) of the object: On the left we have again the hase hashcode: "+object3.obj_value); //So if we re-think our statement everything is passed by value!!! you cannot change where that pointer points.
	System.out.println("In fact everything in Java is PASSED BY VALUE!");

	final ReferenceValue object4 = new ReferenceValue();
	//object4 = object; //Final declaration of objects cannot change objects. But object4 = object; is acceptable.
	
	System.out.println("\n\n\nHow can define that some collections or objects should not be modified?\n");
	
	ReferenceValue object5 = new ReferenceValue();

	passObject(new ReferenceValue(object5), 200);	//we really make a new object that duplicate the status of object5 and pass it as argument into the function. 
	System.out.println(object5.hashCode() + " With the new object as argument and constructor that makes a deep copy, we can pass the object: "+object5.obj_value); //Objects passed by "Reference".
	
	
	unmodifiedcollection(); //Unmodifiable collections!
	
	System.out.println("Old name: "+human.getName()); 	// human is public static final. We cannot change the pointer, but we can change the state of the object.
	human.setName("Theodoros");
	System.out.println("New name: "+human.getName());
	//human= new Human(); We cannot because the pointer cannot point a different object.
}

public static void unmodifiedcollection() {  // We can explicitly declare a collection as unmodifiable and we will not be able to modify this collection.
List<String> strings = new ArrayList<String>();
List<String> unmodifiable = Collections.unmodifiableList(strings);	//Now the collection cannot be modified. We cannot add or remove items from the list. 
//unmodifiable.add("New string"); // will fail at runtime
strings.add("Aha!"); // will succeed
System.out.println(unmodifiable);

public_final_strings.add("word1");	//In the public final list we can add or remove elements.
public_final_strings.add("word2");
public_final_strings.add("word3");
public_final_strings.remove(1);
System.out.println(public_final_strings);
//public_final_strings = strings; //When the pointer is final, it cannot point another object (even if it is the same class).  

List<Human> list_data_obj = new ArrayList<Human>();
Human x1 = new Human();
x1.setName("\nDimitris");
list_data_obj.add(x1);
List<Human> unmodifiable_list_data_obj = Collections.unmodifiableList(list_data_obj);
System.out.println(unmodifiable_list_data_obj.get(0).getName());
x1.setName("Peter");
System.out.println(unmodifiable_list_data_obj.get(0).getName());
}

public class ImmutableClass {	//Immutable class has a constructor to initialize the objects. It has getters to return the values but it does not have setters.
	private int var1;
	private int var2;
	
	ImmutableClass(int in_var1, int in_var2){
		this.var1=in_var1;
		this.var2=in_var2;
	}
	public int getVar1() {
		return var1;
	}
	public int getVar2() {
		return var2;
	}
	
}



}



