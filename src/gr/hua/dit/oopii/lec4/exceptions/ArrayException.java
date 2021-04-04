//lec 4 slide 3
package gr.hua.dit.oopii.lec4.exceptions;
import java.util.Date;

public class ArrayException {

public static void main(String[] args) {
	//noCatchArrayException(11);			//The code throws the exception: ArrayIndexOutOfBoundsException and we don't catch it.
	//catchArrayException(11);				//An exception is raised but because we catch it, the program continues normally (normal execution).
	referenceNullObject(2);
	
}	

public static void noCatchArrayException(int index) {
	int[] arrayOfInt = new int[10];	
	System.out.println("The Array value in the position "+index+" is: "+arrayOfInt[index]);
	System.out.println("After the exception, the program does not continue.");
}


public static void catchArrayException(int index) {
int[] arrayOfInt = new int[10];	
	try {
		System.out.println("The Array value in the position "+index+" is: "+arrayOfInt[index]);
	}
	catch(ArrayIndexOutOfBoundsException exception) {	//We catch the execution and next the execution continues.
		System.out.println("You asked the array index: "+index+" that is out of bound, but the program continues.");
		//handleTheExceptionSomehow(exception);
	}
	System.out.println("After the exception, the program continues because of the [catch] of the exception.");
}


public static void referenceNullObject(int index) {
	Date[] arrayDates = new Date[5];  
	arrayDates[0] = new Date();
	try {		
		System.out.println(arrayDates[index].toString());		//There is no element in the ArrayList with index 2, so an exception is raised.
	}
	catch(NullPointerException e) {
		System.out.println("We handle the NullPointerException.\nWe create a new object and assign it in the index: "+index);
		arrayDates[index] = handleNullPointerException();	// It understands that we didn't pass what it requires and it creates from its own what it needs.
		System.out.println(arrayDates[index].toString());		
	}	
	System.out.println("After the exception, the program should continue.");	
}

public static Date handleNullPointerException() {
	return new Date();
}
}
