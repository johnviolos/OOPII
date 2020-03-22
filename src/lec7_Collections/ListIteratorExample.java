package lec7_Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class ListIteratorExample {

	
	
	public static void main(String args[]) {
	      // Create an array list
		LinkedList<String> linkedList = new LinkedList<String>();
	      
	      // add elements to the array list
	      linkedList.add("C");
	      linkedList.add("A");
	      linkedList.add("E");
	      linkedList.add("B");
	      linkedList.add("D");
	      linkedList.add("F");

	      // Use iterator to display contents of linkedList
	      System.out.print("Original contents of linkedList: "+ linkedList);
	      Iterator<String> itr = linkedList.iterator();
	      
	/*      while(itr.hasNext()) {
	         Object element = itr.next();
	         System.out.print(element + " ");
	      }*/
	      System.out.println();
	      
	      // Modify objects being iterated
	      ListIterator<String> litr = linkedList.listIterator();
	      
	      while(litr.hasNext()) {
	    	  System.out.println("The net index is: "+litr.nextIndex());
	         Object element = litr.next();
	         litr.set("Modified_"+element);
	      }
	      System.out.print("Modified contents of linkedList: ");
	      itr = linkedList.iterator();
	      
	      while(itr.hasNext()) {
	         Object element = itr.next();
	         System.out.print(element + " ");
	      }
	      System.out.println();

	      // Now, display the list backwards
	      System.out.print("Modified list backwards: ");
	      
	      while(litr.hasPrevious()) {
	         Object element = litr.previous();
	         System.out.print(element + " ");
	      }
	      System.out.println();
	   }
	}