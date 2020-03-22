package shops;



public class Zara extends Shop{

	public Zara(String name, float spent) {
		super(name, spent);
		// TODO Auto-generated constructor stub
	}
	public String getMessage() {
		return "Polymorphism worke in Zara: "+name + " spent "+spent +" euro.";
	}	
}