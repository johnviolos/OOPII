package lec2_inheritance;

public class Employee extends Human{
	Address residence;   
	String position;
	public Employee(){ 
		System.out.println("Begin of Employee constructor.");	
		residence=new Address(); position="Unemployed";
		System.out.println("end of Employee constructor.");
	}
	public void runEmployeeMethod() {
		System.out.println("A message from Employee.");	
	}
}
