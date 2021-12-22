package gr.hua.dit.oopii.lec7.collections;




import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Class needs to be cloneable
class GfG implements Cloneable {

	String username;
	String msg;

	// Constructor
	GfG(String username, String msg)
	{
		this.username = username;
		this.msg = msg;
	}

	// To print the objects in the desired format
	@Override
	public String toString()
	{
		return "\nHello " + username + " !\n" + msg + "\n";
	}

	// Overriding the inbuilt clone class
	@Override
	protected GfG clone()
	{
		return new GfG(username, msg);
	}
}

// Program to clone a List in Java
class CloneList {
	public static void main(String[] args)
	{
		// Creating a list
		List<GfG> original
			= Arrays.asList(
				new GfG("user_one","first message"),
				new GfG("user_two", "second message"));

		
		System.out.println("Original List");
		System.out.println(original);
		
		// Creating an empty list
		List<GfG> cloned_list
			= new ArrayList<GfG>();

		// Looping through the list
		// and cloning each element
		for (GfG temp : original)
			cloned_list.add(temp.clone());
		
		System.out.println("\nCloned List");
		System.out.println(cloned_list);
		
		original.set(0, new GfG("user_three","third message"));
		
		System.out.println("\n\nWe modified the Original List");
		System.out.println("Original List");
		System.out.println(original);
		
		System.out.println("\nCloned List");
		System.out.println(cloned_list);
		
	}
}
