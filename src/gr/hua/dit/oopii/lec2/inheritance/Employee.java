/** slide 32 use of super. We cannot have access in super-class private data and we also override the only method that gas access on them, but using super.method() we can have access.*/
package gr.hua.dit.oopii.lec2.inheritance;
public class Employee extends Human{
	Address residence;   
	String position;
	public Employee(){ 
		System.out.println("Begin of Employee constructor.");	
		residence=new Address(); 
		position="Unemployed";
		System.out.println("end of Employee constructor.");
	}
	public void runEmployeeMethod() {
		System.out.println("A message from Employee.");	
	}
	public String getCompleteData() {		//We override.
		return super.getCompleteData();		//and we also call the method of the father.
		//super.private_method();			//But of course we cannot access the private methods of the super-class.
	}
	
	public static void main(String args[] ){ 
		Employee emp = new Employee();
		System.out.println("\n\ndata of emp: "+emp.getCompleteData());
		
	}
}
