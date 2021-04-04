//slide 8 collection with objects of different types & 11 Override equal to compare objects.
package gr.hua.dit.oopii.lec3.lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;


public class ObjectComparison  {

    public static void main(String... equalsExplanation) {
    	ArrayList<Object> list = new ArrayList<Object>();		//A collection that can take any type of object
    	list.add(new Simpson("Homer", 35, 120));
    	list.add(new Date());
    	list.add(new String("haha"));
    	
    	System.out.println(list.get(1));//It can see the method of Object.
    	System.out.println(((Date)list.get(1)).getTime()); // After the casting it can also see the methods of Date class.
    	
        System.out.println(new Simpson("Homer", 35, 120)
                 .equals(new Simpson("Homer",35,120)));
        
        System.out.println(new Simpson("Bart", 10, 120)
                 .equals(new Simpson("El Barto", 10, 45)));
        
        System.out.println(new Simpson("Lisa", 54, 60)
                 .equals(new Object()));
        
        List<Simpson> simpsons_list = new ArrayList<>();
        simpsons_list.add(new Simpson("Homer",20,70));
        simpsons_list.add(new Simpson("Bart",21,75));
        simpsons_list.add(new Simpson("Lisa",19,65));
        
        System.out.println("indexOf :"+simpsons_list.indexOf(new Simpson("Bart",21,75)));	//The position of the new object in the ArrayList
        System.out.println("Index:"+simpsons_list.contains(new Simpson("Bart",21,75)));		//Does the ArrayList contains the object?
        System.out.println("Index:"+simpsons_list.contains(new Simpson("Bart",20,75)));		//What means equal is defined in the overridden method, In this case involves all the elemnts.
    
        Collections.sort(simpsons_list);
        simpsons_list.stream().map(s -> s.name+" ").forEach(System.out::print);
    }
	
    static class Simpson implements Comparable<Simpson>{

        private String name;
        private int age;
        private int weight;

        public Simpson(String name, int age, int weight) {
            this.name = name;
            this.age = age;
            this.weight = weight;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Simpson simpson = (Simpson) o;
            return age == simpson.age &&
                    weight == simpson.weight &&
                    name.equals(simpson.name);
        }

		@Override
		public int compareTo(Simpson arg0) {
			if (this.age>arg0.age)
				return -1;
			else if (this.age<arg0.age)
				return 1;
			else
				return 0;
		}


    }


}