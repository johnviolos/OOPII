package gr.hua.dit.oopii.lec7.shops;

public class Zara extends Shop{


	private static final long serialVersionUID = 1L;
	public Zara(String name, float spent) {
		super(name, spent);
		// TODO Auto-generated constructor stub
	}
	public String getMessage() {
		return "Polymorphism worke in Zara: "+name + " spent "+spent +" euro.";
	}	
}