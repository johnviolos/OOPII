package students;

import java.util.Comparator;

public class TwoFieldsComparator implements Comparator<Object> {

        public int compare(Object o1, Object o2) {

            String x1 = ((Student) o1).getName();
            String x2 = ((Student) o2).getName();
            int sComp = x1.compareTo(x2);

            if (sComp != 0) {
               return sComp;
            } 

            Integer xi1 = ((Student) o1).getAge();
            Integer xi2 = ((Student) o2).getAge();
            return xi1.compareTo(xi2);
    }
	
}
