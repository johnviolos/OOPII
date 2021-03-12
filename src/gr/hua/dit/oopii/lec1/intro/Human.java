package gr.hua.dit.oopii.lec1.intro;

class Human {
	private String name;
	private int age;
	private boolean alive; //Source -> Generate Getters & Setters

	void born(){
		setAlive(true);
		private_method();// But we can call the private from the same class. 
	}
	
	void speak(){
	    System.out.println("Hello World! I am the Default method");
	}
	
	void incr_age(){
	    setAge(getAge() +1);
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

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}

public boolean isAlive() {
	return alive;
}

public void setAlive(boolean alive) {
	this.alive = alive;
}



}
