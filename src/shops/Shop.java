package shops;

public class Shop{
	protected float spent;
	protected String name;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Shop( String name, float spent) {
		super();
		this.spent = spent;
		this.name = name;
	}
	public String getMessage() {
		return "Shop: "+name + " spent "+spent +" euro.";
	}	

@Override //Search the bucket for the right element (using equals() )
 public boolean equals(Object object) { 

  Shop in_shop = (Shop) object; 

 if(in_shop.getName() == name 
		 &&in_shop.getClass()==this.getClass()
		 ) 
	 return true; 
 	else 
	 return false; 
} 

 @Override //Find the right bucket (using hashCode()) We want the same objects to go in the same buckets.
 public int hashCode() { 
 int value; 
 value =  name.hashCode(); 

 return value; 
 }
@Override
public String toString() {
	return "Shop [spent=" + spent + ", name=" + name + "]";
}  
 
} 