package gr.hua.dit.oopii.lec2.inheritance;
//slide 21 we call three times with different parameters and execute different methods.
public class Callculator{
	Callculator(){	//Default Constructor.
		System.out.println("Callculator Default constructor!");}
	Callculator(String name){	// Constructor with one argument.
		System.out.println("Callculator constructor with one argument. "+ name);}
	Callculator(String name, int num){	// Constructor with two arguments.
		System.out.println("Callculator constructor with two argumets. "+ name);}

	public int object_method (int a, int b) {
		System.out.println("int"); 
		return a+b;
	}
	
	static int add(int a, int b) {
		System.out.println("int"); 
		return a+b;
	}

	static double add(double a, double b) {
		System.out.println("double"); 
		return a+b;
	}
	
	static float add(float a, float b) {
		System.out.println("float"); 
		return a+b;
	}
 
	static int add(int a, int b, int c) {
		System.out.println("Three arguments"); 
		return a+b+c;
	}
	
	public static void main(String[] args ){ 
		int x=5; int y=6;
		float k=5.3f; double m=4.5; //By default, floating-point numbers are double in Java. 32bits 64bits 
		//In order to store them into a float variable, you need to cast them explicitly or suffix with 'f' or 'F'

		System.out.println("Atrhoisma "+ add(x,y)+"\n"); 
		System.out.println("Athroisma "+ add(k,m)+"\n"); 
		System.out.println("Athroisma "+ add(x,m)+"\n");	//(int,double)->(double,double)
		System.out.println("Athroisma "+ add(x,10,100)+"\n");
		
	} 
}