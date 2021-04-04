package gr.hua.dit.oopii.lec3.lists;
//slide 14
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class Simpson implements Comparable<Simpson> {
    String name;

    Simpson(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Simpson simpson) {
        return this.name.compareTo(simpson.name);
    }
}

public class ObjectSort {
		
     public static void main(String... sortingWithList) {// ... zero or more String objects (or a single array of them) may be passed as the argument(s)
        List<Simpson> simpsons_list = new ArrayList<>();
        simpsons_list.add(new Simpson("Homer "));
        simpsons_list.add(new Simpson("Marge "));
        simpsons_list.add(new Simpson("Bart "));
        simpsons_list.add(new Simpson("Lisa "));

        Collections.sort(simpsons_list);
        //simpsons_list.stream().map(s -> s.name).forEach(System.out::print);
        //System.out.println("");
        
        System.out.println("Sorted:");
        Iterator<Simpson> it = simpsons_list.iterator();
        StringBuffer buf = new StringBuffer(); while (it.hasNext())
        buf.append( (it.next()).name) .append( " " ); System.out.println(buf.toString());
        
        System.out.println("\n2nd and 3rd element in the sorted list:");
        System.out.println("2st: "+simpsons_list.get(1).name);
        System.out.println("3nd: "+simpsons_list.get(2).name);
        
        System.out.println("\nReverse Sorted:");
        Collections.reverse(simpsons_list);
        it = simpsons_list.iterator();
        StringBuffer buf2 = new StringBuffer(); while (it.hasNext())
        buf2.append( (it.next()).name) .append( " " ); System.out.println(buf2.toString());
        
        //simpsons.stream().map(s -> s.name).forEach(System.out::print);
        //System.out.println("");
       // simpsons.stream().forEach(System.out::print);
    }

}