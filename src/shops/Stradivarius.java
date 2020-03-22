package shops;

public class Stradivarius extends Shop{

	public Stradivarius(String name, float spent) {
		super(name, spent);
		// TODO Auto-generated constructor stub
	}
	public String getMessage() {
		return "Polymorphism worked in Stradivarius: "+name + " spent "+spent +" euro.";
	}	
}