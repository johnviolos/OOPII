//**page 25 Encapsulation & visibility. */
package gr.hua.dit.oopii.lec1.intro;

class Demo{
	  public static void main(String args[]){
		Human john=new Human();
		john.setAge(250);
	    john.born();
	    john.speak();
	    john.protected_method();
	    //john.private_method(); //It is private. We cannot call it out of its class.
	   
	  }
	  

	

}
