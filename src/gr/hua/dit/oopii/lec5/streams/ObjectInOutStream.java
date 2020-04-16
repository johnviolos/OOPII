package gr.hua.dit.oopii.lec5.streams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import gr.hua.dit.oopii.lec7.shops.Shop;
import gr.hua.dit.oopii.lec7.shops.Stradivarius;
import gr.hua.dit.oopii.lec7.shops.Zara;

public class ObjectInOutStream {

public static void main(String[] args) throws IOException, ClassNotFoundException {
	//writeObjectShop("shops.dat");
	//readObjectShop("shops.dat");
	
	//writeCollectionOfObjectShops("collShops.dat");
	readCollectionOfObjectShops("collShops.dat");
	
}	


public static void writeObjectShop(String shopFileName) {

      Shop newShop1 = new Shop("Attica", 250);				// Shop implements java.io.Serializable
      Shop shop2 = new Shop("Anna Riska", 300);
      try {
         // create a new file with an ObjectOutputStream
         FileOutputStream out = new FileOutputStream(shopFileName);
         ObjectOutputStream oout = new ObjectOutputStream(out);

         // write something in the file
         oout.writeObject(newShop1);
         oout.writeObject(shop2);
         oout.flush();
         // close the stream
         oout.close();    
      } catch (Exception ex) {
         ex.printStackTrace();
      }
   }	
public static void readObjectShop(String shopFileName) {
	// create an ObjectInputStream for the file we created before
    ObjectInputStream ois;
	try {
		ois = new ObjectInputStream(new FileInputStream(shopFileName));
	    // read and print what we wrote before
		Shop inShop_1 = (Shop) ois.readObject();
		Shop inShop_2 = (Shop) ois.readObject();
	    System.out.println("The data of the 1st shop:" + inShop_1);
	    System.out.println("The data of the 2nd shop:" + inShop_2);
	    ois.close();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}	


public static void writeCollectionOfObjectShops(String shopFileName) throws IOException {
    HashMap<String, Shop> hashmapShops = new HashMap<String, Shop>();   
	   
    // Put nodes to the map
    hashmapShops.put("shop1", new Shop("Lucy",343.20f));
    hashmapShops.put("shop2", new Shop("Beatrice",170.50f));
    hashmapShops.put("shop3", new Shop("Beatrice",170.50f)); //accepted duplicate values.
    hashmapShops.put("shop4", new Zara("Lucy",100.20f));
    hashmapShops.put("shop4", new Stradivarius("Lucy",130.50f)); // duplicate keys are not accepted. The new put in the same key will replace the old value.
  
    FileOutputStream out = new FileOutputStream(shopFileName);
    ObjectOutputStream oout = new ObjectOutputStream(out);

    // write something in the file
    oout.writeObject(hashmapShops);
    oout.flush();
    oout.close();
    System.out.println("Data are writen in the file.");
}


public static void readCollectionOfObjectShops(String shopFileName) throws FileNotFoundException, IOException, ClassNotFoundException {
	ObjectInputStream ois;

	ois = new ObjectInputStream(new FileInputStream(shopFileName));
    // read and print what we wrote before
	
	HashMap<String, Shop>  hashmapShops = (HashMap<String, Shop> ) ois.readObject();

	
	Set<?> set = hashmapShops.entrySet(); // Get a set of the entries    
    Iterator<?> i = set.iterator(); // Get an iterator
        
    while(i.hasNext()) { // We iterate and display Entries (nodes) one by one.
       @SuppressWarnings("rawtypes")
		Map.Entry me = (Map.Entry)i.next();
       System.out.print("key: "+me.getKey() + ". ");
       System.out.print("Class: "+me.getValue().getClass() + ". ");
       System.out.println("value: "+((Shop)me.getValue()).getMessage());
    }
    ois.close();	
}


}
