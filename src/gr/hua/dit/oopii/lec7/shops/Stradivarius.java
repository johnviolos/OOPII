package gr.hua.dit.oopii.lec7.shops;

public class Stradivarius extends Shop{

	private static final long serialVersionUID = 1L;
	public Stradivarius(String name, float spent) {
		super(name, spent);
		// TODO Auto-generated constructor stub
	}
	public String getMessage() {
		return "Polymorphism worked in Stradivarius: "+name + " spent "+spent +" euro.";
	}	
}