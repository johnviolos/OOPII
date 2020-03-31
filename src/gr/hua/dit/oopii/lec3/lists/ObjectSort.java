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

     public static void main(String... sortingWithList) {
        List<Simpson> simpsons = new ArrayList<>();
        simpsons.add(new Simpson("Homer "));
        simpsons.add(new Simpson("Marge "));
        simpsons.add(new Simpson("Bart "));
        simpsons.add(new Simpson("Lisa "));

        Collections.sort(simpsons);
        //simpsons.stream().map(s -> s.name).forEach(System.out::print);
        //System.out.println("");
        
        
        Iterator<Simpson> it = simpsons.iterator();
        StringBuffer buf = new StringBuffer(); while (it.hasNext())
        buf.append( (it.next()).name) .append( " " ); System.out.println(buf.toString());
        
        Collections.reverse(simpsons);
        it = simpsons.iterator();
        StringBuffer buf2 = new StringBuffer(); while (it.hasNext())
        buf2.append( (it.next()).name) .append( " " ); System.out.println(buf2.toString());
        
        //simpsons.stream().map(s -> s.name).forEach(System.out::print);
        //System.out.println("");
       // simpsons.stream().forEach(System.out::print);
    }

}