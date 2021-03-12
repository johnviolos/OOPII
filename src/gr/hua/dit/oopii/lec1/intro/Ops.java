//*page 42*/
package gr.hua.dit.oopii.lec1.intro;

public class Ops {

	public static void main(String args[]){
		//telestes1();
		telestes2();
	}
	  static void telestes1() {
		  int var1=10;
		  
		  System.out.print("1.The value of var: ");
		  System.out.print(++var1);	//1st we make the operation, next we pass the argument.
		  System.out.println();
		  System.out.print("2.The value of var: "+var1);
		  
	  }
	  
	  static void telestes2() {
		  int var1=10;
		  
		  System.out.print("1.The value of var: ");
		  System.out.print(var1++); //1st we pass the argument, next the make the operation. 
		  System.out.println();
		  System.out.print("2.The value of var: "+var1);
		  
	  }

}
