package gr.hua.dit.oopii.lec2.inheritance;
//slide 21 we call three times with different parameters and execute different methods.
class Calculator{
	
	Calculator(String name){System.out.println("Calculator constructor! Hi "+ name);}
	Calculator(String name, int num){System.out.println("Calculator constructor! Hi "+ name);}
	
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
 
	public static void main(String args[] ){ 
		int x=5; int y=6;
		float k=5.3f; double m=4.5; System.out.println("Atrhoisma "+ add(x,y)+"\n"); 
		System.out.println("Athroisma "+ add(k,m)+"\n"); 
		System.out.println("Athroisma "+ add(x,m)+"\n");
	} 
}