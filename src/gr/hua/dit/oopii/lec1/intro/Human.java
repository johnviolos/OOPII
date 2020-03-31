//**page 15/
package gr.hua.dit.oopii.lec1.intro;

class Human {
	boolean alive;
	int age;
	String name;
	
	void born(){
		alive = true;
	}
	
	void speak(){
	    System.out.println("Hello World! I am the Default method");
	}
	
	void incr_age(){
	    age = age +1;
	}
	
private void private_method() {
	System.out.println("I am the private method");
}

protected void protected_method() {
	System.out.println("I am the protected method");
}

public void public_method() {
	System.out.println("I am the public method");
}
}
