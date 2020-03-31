package gr.hua.dit.oopii.lec7.collections;
import java.util.*;

import gr.hua.dit.oopii.lec7.students.AgeComparator;
import gr.hua.dit.oopii.lec7.students.NameComparator;
import gr.hua.dit.oopii.lec7.students.Student;
import gr.hua.dit.oopii.lec7.students.TwoFieldsComparator;  

class TestComparator{  
public static void main(String args[]){  
//Creating a list of students  
ArrayList<Student> al=new ArrayList<Student>();  
al.add(new Student(101,"Vijay",23));  
al.add(new Student(106,"Ajay",27));  
al.add(new Student(105,"Jai",29)); 
al.add(new Student(105,"Jai",22));  
  
System.out.println("Sorting by Name");  

Collections.sort(al,new NameComparator());  
//Traversing the elements of list  
for(Student st: al){  
System.out.println(st.rollno+" "+st.name+" "+st.age);  
}  
  
System.out.println("sorting by Age");  
//Using AgeComparator to sort the elements  
Collections.sort(al,new AgeComparator());  
//Travering the list again  
for(Student st: al){  
System.out.println(st.rollno+" "+st.name+" "+st.age);  
}  
  
System.out.println("sorting by Name&Age");  
//Using AgeComparator to sort the elements  
Collections.sort(al,new TwoFieldsComparator());  
//Travering the list again  
for(Student st: al){  
System.out.println(st.rollno+" "+st.name+" "+st.age);  
}  

}  
}  