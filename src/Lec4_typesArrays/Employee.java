package lec4_typesArrays;

public class Employee extends Human{
	Address residence;   
	String position;
	public Employee(){ 
		//System.out.println("Begin of Employee constructor.");	
		residence=new Address(); position="Unemployed";
		//System.out.println("end of Employee constructor.");
	}
	public void runEmployeeMethod() {
		System.out.println("A message from Employee.");	
	}
	public class Address {
		String street,city;
		int number;
		public Address(){
		//System.out.println("Begin of Address constructor");
			street="Unknown"; number=0; city="Unknown";
		//System.out.println("end of Address constructor"); }

		}
	}

}
