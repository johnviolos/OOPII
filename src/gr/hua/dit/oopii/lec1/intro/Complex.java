//* page 43, 46*/
package gr.hua.dit.oopii.lec1.intro;

public class Complex { private double x,y;
	public double real() { return x; } 
	public double imag() { return y; } 
	public void setReal(double u) {x=u; } 
	public void setImag(double v) {y=v; }

	public static void main(String args[]){
		Complex c1 = new Complex(); 
		Complex c2 = new Complex(); 
		c1.setReal(9); 
		c1.setImag(47);
		c2.setReal(10); 
		c2.setImag(10);
		
		c2=c1;
		System.out.println("Real:" + c2.real());
		System.out.println("Imag:" + c2.imag());
		
		c2.setReal(50); 
		c2.setImag(55);
		
		System.out.println("Real:" + c1.real());
		System.out.println("Imag:" + c1.imag());	
		
		Complex c3 = new Complex();
		c3.setReal(50); 
		c3.setImag(55);
		System.out.println("c1: "+c1);
		System.out.println("c2: "+c2);
		System.out.println("c3: "+c3);
		
		if(c1==c2) {
			System.out.println("Equal c1 and c2.");
		}
		
		if(c1==c3) {
			System.out.println("Equal c1 and c3.");
		}else {
			System.out.println("NOT Equal c1 and c3.");
		}	
		
		multi_comas();
		add_Strings();
	}
	
	static void multi_comas() {
		for(int i = 1, j = i + 10; i < 5; i++, j = i * 2) {
			System.out.println("i= " + i + " j= " + j);
			}
	}
	
	static void add_Strings() {
		int x = 0, y = 1, z = 2;
		String sString = "x, y, z "; 
		System.out.println(sString + x + y + z);
		System.out.println("The value of x is: " + x);
		System.out.println("The value of x + y is: " + x + y);
		System.out.println("The value of (x + y) is: " + (x + y) );
	}
	
	
}
