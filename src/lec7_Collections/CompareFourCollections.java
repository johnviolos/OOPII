package lec7_Collections;
//slide 21
import com.google.common.collect.HashMultiset; 
import com.google.common.collect.Multiset;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class CompareFourCollections {
public static void main(String[] args) {
	listCollection();
	hashtableCollection();
	multiSetCollection();
	setCollection();
}

public static void listCollection(){	
	List<String> weekDaysList = new LinkedList<String>();  //Type interface List but implementation "new" LinkedList
    weekDaysList.add("Monday");
    weekDaysList.add("Tuesday");
    weekDaysList.add("Wednesday");
    weekDaysList.add("Thursday");
    weekDaysList.add("Friday");
    weekDaysList.add("Saturday");
    weekDaysList.add("Sunday");
    weekDaysList.add("Monday");
    weekDaysList.add("Tuesday");
    weekDaysList.add("Wednesday");
    System.out.println("LinkedList keeps order and duplicate values.");
    System.out.println("Original contents of weekDaysList: " + weekDaysList);
}


public static void hashtableCollection() {
    Hashtable<Integer, String> weekDaysHashTable = new Hashtable<Integer, String>(); //The collections is an object!
    weekDaysHashTable.put(2, new String("Monday"));
    weekDaysHashTable.put(3, new String("Tuesday"));
    weekDaysHashTable.put(4, new String("Wednesday"));
    weekDaysHashTable.put(5, new String("Thursday"));
    weekDaysHashTable.put(6, new String("Friday"));
    weekDaysHashTable.put(7, new String("Saturday"));
    weekDaysHashTable.put(1, new String("Sunday"));
    //weekDaysHashTable.put(2, new String("Monday"));
    weekDaysHashTable.put(3, new String("Tuesday"));
    weekDaysHashTable.put(1, new String("Monday"));
    //weekDaysHashTable.put(4, new String("Tuesday"));
    weekDaysHashTable.put(9, new String("Monday"));
    weekDaysHashTable.put(10, new String("Tuesday"));
    System.out.println("\nHashtable keeps order, keeps duplicate values but DOES NOT keep duplicate KEYS, so it does not keep duplicate nodes key-value.");
    System.out.println("Original contents of weekDaysHashTable: " + weekDaysHashTable);
}


public static void multiSetCollection() {
	Multiset<String> weekDaysMultiset = HashMultiset.create(); 
	weekDaysMultiset.add("Monday"); 
	weekDaysMultiset.add("Tuesday"); 
	weekDaysMultiset.add("Wednesday"); 
	weekDaysMultiset.add("Thursday"); 
	weekDaysMultiset.add("Friday"); 
	weekDaysMultiset.add("Saturday"); 
	weekDaysMultiset.add("Sunday"); 
	weekDaysMultiset.add("Monday"); 
	weekDaysMultiset.add("Tuesday"); 
    System.out.println("\nMultiSet does not keep order but it keeps duplicate values.");
    System.out.println("Original contents of weekDaysMultiset: " + weekDaysMultiset);	    
}


public static void setCollection() {
	 Set<String> weekDaysHashSet = new HashSet<String>();
	 weekDaysHashSet.add("Monday"); 
	 weekDaysHashSet.add("Tuesday"); 
	 weekDaysHashSet.add("Wednesday"); 
	 weekDaysHashSet.add("Thursday"); 
	 weekDaysHashSet.add("Friday"); 
	 weekDaysHashSet.add("Saturday"); 
	 weekDaysHashSet.add("Sunday"); 
	 weekDaysHashSet.add("Monday"); 
	 weekDaysHashSet.add("Tuesday");
	 System.out.println("\nSet does not keep order and it does not keep duplicate values.");
	 System.out.println("Original contents of weekDaysHashSet: " + weekDaysHashSet);	
}
}
