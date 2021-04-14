package gr.hua.dit.oopii.lec7.collections;

import java.util.ArrayList;

//slide 9

public class ObjectComparison {

    public static void main(String... equalsExplanation) {
       /* System.out.println(new Simpson("Homer", 35, 120)
                 .equals(new Simpson("Homer",35,120)));
        
        System.out.println(new Simpson("Bart", 10, 120)
                 .equals(new Simpson("El Barto", 10, 45)));
        
        System.out.println(new Simpson("Lisa", 54, 60)
                 .equals(new Object())); */
    

    
        ArrayList<Simpson> arrayListOfSimpsons = new ArrayList<Simpson>();
        arrayListOfSimpsons.add(new Simpson("Homer", 35, 120));
        arrayListOfSimpsons.add(new Simpson("Nick", 30, 100));
        arrayListOfSimpsons.add(new Simpson("Jim", 25, 105));
        arrayListOfSimpsons.add(new Simpson("Mike", 40, 110));
        arrayListOfSimpsons.add(new Simpson("Homer", 35, 120));
        arrayListOfSimpsons.add(new Simpson("Magda", 30, 95));
        arrayListOfSimpsons.add(new Simpson("Helen", 35, 90));
        
        System.out.println("Does the arraylist contain Homer age 34? "+arrayListOfSimpsons.contains(new Simpson("Homer", 34, 120)));
        System.out.println("Does the arraylist contain Homer age 35? "+arrayListOfSimpsons.contains(new Simpson("Homer", 35, 120)));
        System.out.println("What is the index of Helen? "+arrayListOfSimpsons.indexOf(new Simpson("Helen", 35, 90)));
        System.out.println("What is the index of Helen? "+arrayListOfSimpsons.indexOf(new Simpson("Helen", 25, 90)));
        System.out.println("What is the index of Homer? "+arrayListOfSimpsons.indexOf(new Simpson("Homer", 35, 120)));
        System.out.println("What is the last index of Homer? "+arrayListOfSimpsons.lastIndexOf(new Simpson("Homer", 35, 120)));
    }
	
    static class Simpson {

        private String name;
        private int age;
        private int weight;

        public Simpson(String name, int age, int weight) {
            this.name = name;
            this.age = age;
            this.weight = weight;
        }

        @Override
        public boolean equals(Object o) { //As you can see we don't call the equals(). The methods contains, indexOf, lastindexOf manipulate the equals().
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) { //The input object may be different class than this. Else we will not be able to make the next casting.
                return false;
            }
            Simpson simpson = (Simpson) o;
            return age == simpson.age &&  //comment this 
                    weight == simpson.weight &&
                    name.equals(simpson.name);
        }
    }

}