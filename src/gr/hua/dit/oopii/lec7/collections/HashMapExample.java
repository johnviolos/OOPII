package gr.hua.dit.oopii.lec7.collections;
//slide 32

import java.util.*;

import gr.hua.dit.oopii.lec7.shops.Shop;
import gr.hua.dit.oopii.lec7.shops.Stradivarius;
import gr.hua.dit.oopii.lec7.shops.Zara;
public class HashMapExample {

   public static void main(String args[]) {
   
      // Create a hash map
      HashMap<String, Shop> hm = new HashMap<String, Shop>();
	   
	   
      // Put nodes to the map
      hm.put("shop1", new Shop("Lucy",343.20f));
      hm.put("shop2", new Shop("Beatrice",170.50f));
      hm.put("shop3", new Shop("Beatrice",170.50f)); //accepted duplicate values.
      hm.put("shop4", new Zara("Lucy",100.20f));
      hm.put("shop4", new Stradivarius("Lucy",130.50f)); // duplicate keys are not accepted. The new put in the same key will replace the old value.
     
      Set<?> set = hm.entrySet(); // Get a set of the entries    
      Iterator<?> i = set.iterator(); // Get an iterator
          
      while(i.hasNext()) { // We iterate and display Entries (nodes) one by one.
         @SuppressWarnings("rawtypes")
		Map.Entry me = (Map.Entry)i.next();
         System.out.print("key: "+me.getKey() + ". ");
         System.out.print("Class: "+me.getValue().getClass() + ". ");
         System.out.println("value: "+((Shop)me.getValue()).getMessage());
      }
      
      //We check if a node (Shop) exist in the HashMap if we don't override hashCode() and equals() it will not work.
      System.out.println( "Does the hashmap contain (Zara,Beatrice) shop: "+hm.containsValue(new Shop("Beatrice",171.50f))); 
      
      
      hm.remove("shop2");//We remove a node with the key:shop2
      System.out.println("shop2 does not exist in the hashMap:\n"+hm.entrySet());
      System.out.println("Available keys: "+hm.keySet());
      System.out.println("Available values: "+hm.values());
   }
   
}