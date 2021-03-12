//* page 43, 46*/
package gr.hua.dit.oopii.lec1.intro;

public class Complex { private double x,y;
	private double real() { return x; } 
	private double imag() { return y; } 
	private void setReal(double u) {x=u; } 
	private void setImag(double v) {y=v; }
	
	public boolean equals(Complex c) {
		if (x==c.x && y==c.y) return true;
		else return false; } 

	public static void main(String args[]){
		Complex c1 = new Complex(); 
		Complex c2 = new Complex(); 
		c1.setReal(1); 
		c1.setImag(2);
		c2.setReal(100); 
		c2.setImag(200);
		
		c2=c1;											//c1, c2 are two pointers that show in the same memory cell. In doing so, they also have the same values.
		System.out.println("c2 real: " + c2.real());	//We assigned into c2 100 and 200 but this memory cell is not accessible now.
		System.out.println("c2 imag: " + c2.imag());
		
		c2.setReal(500); 								//We changed c2 but c1 also affected.
		c2.setImag(550);
		
		System.out.println("c1 real: " + c1.real());	//c1 and c2 show in the same memory cell.
		System.out.println("c1 imag: " + c1.imag());	
		
		Complex c3 = new Complex();
		c3.setReal(500); 
		c3.setImag(550);
		System.out.println("c1: " + c1);					//c1, c2, c3 are pointers and if we print them we see only a memory address.
		System.out.println("c2: " + c2);
		System.out.println("c3: " + c3);
		
		if(c1==c2) {										//The pointers c1 and c2 are equal.
			System.out.println("Pointers Comparison: Equal c1 and c2.");
		}
		
		if(c1==c3) {
			System.out.println("Pointers Comparison: Equal c1 and c3.");
		}else {
			System.out.println("Pointers Comparison: NOT Equal c1 and c3.");		//Even if the values of variables c1 and c3 are equal. The pointers c1 and c3 are not equal. We compare pointers.
		}	
		
		
		if(c1.equals(c2)) {															// We must override the equals. (Next slide)
			System.out.println("Objects Comparison: Equal c1 and c2.");				//We must explicitly define what means two objects to be equal.
		}
		
		if(c1.equals(c3)) {
			System.out.println("Objects Comparison: Equal c1 and c3.");
		}else {
			System.out.println("Objects Comparison: NOT Equal c1 and c3.");		
		}	
		
		
		multi_comas();
		add_Strings();
		int num =15;
		String msg = num > 10 ? "Number is greater than 10" : "Number is less than or equal to 10"; //If the expression is true happens the 1st part else happens the 2nd part.
		System.out.println(msg);
	}
	
	
	
	static void multi_comas() {	//Run two indexes.
		for(int i = 1, j = i + 10; i < 5; i++, j = i * 2) {
			System.out.println("i= " + i + " j= " + j);
			}
	}
	
	static void add_Strings() {
		int x = 0, y = 1, z = 2;
		String sString = "x, y, z "; 
		System.out.println(sString + x + y + z);
		System.out.println("The value of x is: " + x);					//It makes casting the int to String.
		System.out.println("The value of x + y is: " + x + y);			//It makes casting the int to String.
		System.out.println("The value of (x + y) is: " + (x + y) );		//It calculates (x+y) and then it makes the casting into String.
	}
	
	
}
