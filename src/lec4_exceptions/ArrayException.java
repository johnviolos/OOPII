package lec4_exceptions;
//lec 4 slide 3
import java.util.Date;

public class ArrayException {

public static void main(String[] args) {
	noCatchArrayException(11);
	//catchArrayException(11);
	//referenceNullObject(2);
}	

public static void noCatchArrayException(int index) {
	int[] arrayOfInt = new int[10];	
	System.out.println("The Array value in the position "+index+" is: "+arrayOfInt[index]);
	System.out.println("After the exception, the program should continue.");
}


public static void catchArrayException(int index) {
int[] arrayOfInt = new int[10];	
	try {
		System.out.println("The Array value in the position "+index+" is: "+arrayOfInt[index]);
	}
	catch(ArrayIndexOutOfBoundsException exception) {
		System.out.println("You asked the array index: "+index+" that is out of bound, but the program continues.");
		//handleTheExceptionSomehow(exception);
	}
	System.out.println("After the exception, the program should continue (but not).");
}


public static void referenceNullObject(int index) {
	Date[] arrayDates = new Date[5];  
	arrayDates[0] = new Date();
	//System.out.println(arrayDates[index].toString());
	int var;
	try {
		
		System.out.println(arrayDates[index].toString());
	}
	catch(NullPointerException e) {
		System.out.println("We handle the NullPointerException.\nWe create a new object and assign it in the index: "+index);
		arrayDates[index] = handleNullPointerException();
		System.out.println(arrayDates[index].toString());
		
		
	}	
	System.out.println("After the exception, the program should continue.");	
}

public static Date handleNullPointerException() {
	return new Date();
}
}
