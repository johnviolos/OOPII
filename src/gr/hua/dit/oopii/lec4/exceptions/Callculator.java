//lec 4 slide 11
package gr.hua.dit.oopii.lec4.exceptions;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
//import java.util.concurrent.TimeUnit;
public class Callculator{
	
public static void main(String[] args ){ 
	System.out.println("The result of the sum is: "+sumNumbers());		//1. Inside in sumNumbers()  we throw the exceptions and catch it 
	double value1=0,value2=0;
	Callculator calc_obj = new Callculator("Peter");
				calc_obj.calcs_int();
	try {																//2. The method readDouble() throws Exception and catch them in this block of code.
		 value1=calc_obj.readDouble();		//Throws Exception
		 value2=calc_obj.readDouble2();		//Throws MyException
		// for (int i=0; i<10; i++) {
		//		System.out.println("The process runs. "+i);}
	} catch (MyException e2) {					// We catch two different exceptions. 1st Our exception has also a constructor which can also work.											
		value2=100;								// The body of catch declares what will happen after we catch this specific exception.
		//e2.printStackTrace();					// So we see that we didn't have a value (cause of exception) for the value2 and now we set it equal to 100.
	}
	catch (Exception e) {						//We catch two different types of exceptions. 2nd type of exception.
		value1=150;
		try {									//This is a nested exception.
			value2=calc_obj.readDouble2();
		} catch (MyException e1) {		
			//e1.printStackTrace();
			value2=200;
		}
		//e.printStackTrace(); //The stack of the exception and every point in the code that called it. 
		//System.out.println("Caught Exception " + e.getMessage()); //It prints a message of the Exception object.
		//System.out.println("Caught Exception " + e.toString()); //It prints .toString of the exception object.
		
	} 

	System.out.println("Finally, the value1 is: "+value1);
	System.out.println("Finally, the value2 is: "+value2);
	
/*	for (int i=0; i<10; i++) {
		System.out.println("The process runs after the exception normally. "+i);
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}*/
}
	
Callculator(String name){System.out.println("Calculator constructor! Hi "+ name);}
Callculator(String name, int num){System.out.println("Calculator constructor! Hi "+ name);}
	
@SuppressWarnings("unused")
private void calcs_line() {
	BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
	String line;
	try { System.out.print("input line: ");
		line=stdin.readLine();
	}catch(IOException e) {
		line ="";
	}
	System.out.println("The line is: "+line);
	
}


private void calcs_int() {
	BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
	String line="";
	try {
		System.out.print("input line: ");
		line = stdin.readLine();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	Integer x=100;
	try { System.out.print("input line: ");
		x=Integer.parseInt(line);
	}catch(NumberFormatException e) {
		x =0;
	}
	System.out.println("The number is: "+x.toString());
}

 
public double readDouble() throws Exception{
	System.out.print("input1: ");
	@SuppressWarnings("resource")
	Scanner in = new Scanner(System.in);
	if(in.hasNextDouble()) {
		return in.nextDouble(); //if we passed a number, it will return the number.
	}
	else throw new Exception("I pass the expression Not a number."); //else we will throw a new Exception
}

public double readDouble2() throws MyException{
	System.out.print("input2: ");
	@SuppressWarnings("resource")
	Scanner in = new Scanner(System.in);
	if(in.hasNextDouble()) {
		return in.nextDouble();
	}
	else throw new MyException("Not a number.");
}


public static double readDouble3() throws MyException, Exception{
	Scanner in = new Scanner(System.in);
	if (in.hasNextDouble()) {
		return in.nextDouble();
	} else if (in.hasNext() && in.next().equals("=")){
		throw new MyException();  							//Here we throw the special exception.
	}
	else{
		throw new Exception("Not a number");
		
		
	}	
}

public static double sumNumbers() {
	double sum = 0;
	while(true) {
		try {
			System.out.print("Enter a number: ");
			sum +=readDouble3();
		} catch (MyException ex) {
			break;
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		} 
	}
	
	return sum;	
}

}