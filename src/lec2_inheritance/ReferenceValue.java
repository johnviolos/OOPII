package lec2_inheritance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//slide 7
public class ReferenceValue {
 int obj_value;
 
ReferenceValue(){
	this.obj_value=5;
}

public static void passPrimitiveTypes(int number) {
	number=10;
}

public static void passObject( ReferenceValue obj , int number) {
	obj.obj_value=number;
}

public static void passObject_withNew( ReferenceValue obj) {
	ReferenceValue object2 = new ReferenceValue();
	object2.obj_value=100;
	obj=object2; //The object pointer will not change.
}

public static void passObject_withfinal(final ReferenceValue obj , final int number) {
	
	obj.obj_value=number;
	//.obj_value=number;
}

public static void main(String[] args) {
	int number=5;
	passPrimitiveTypes(number);
	System.out.println("Primitive type value: "+number);	//Primitive type passed by Value.

	ReferenceValue object = new ReferenceValue();
	passObject(object,10);
	System.out.println("Object value: "+object.obj_value); //Objects passed by "Reference".

	ReferenceValue object3 = new ReferenceValue(); //Reference to the values of the object. But passed with value thepointer to the object. We cannoz change the object that we point.
	passObject_withNew(object3); //But we can change the variables of the object that we pass in. Δεν μπορώ να δειξω σε άλλο αντικείμενο. O pointer θα δείχνει πάντα στο ιδιο object.
	System.out.println("Object value: "+object3.obj_value);
	
	ReferenceValue object4 = new ReferenceValue();
	final ReferenceValue object5 = object4;
	
	passObject(object5,10);
	System.out.println("Object value: "+object5.obj_value);
	
}

public static void unmodifiedcollection() {
List<String> strings = new ArrayList<String>();
List<String> unmodifiable = Collections.unmodifiableList(strings);
unmodifiable.add("New string"); // will fail at runtime
strings.add("Aha!"); // will succeed
System.out.println(unmodifiable);
}

public class ImmutableClass {
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



