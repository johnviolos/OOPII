package gr.hua.dit.oopii.lec5.streams;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AbstractJacksonTester {

	  
	public static void main(String args[]) throws InterruptedException{
	AbstractJacksonTester tester1 = new AbstractJacksonTester();
    ArrayList<AbsStudent> arraylist_abs_students = new ArrayList<AbsStudent>();
    
     try { 
    	 tester1.createStudents();	//We create and store in the file abs_arraylist.json objects from the classes YoungStudents, MidleStudents and ElderStudents that extend the abstract class Student.
    	 Thread.sleep(2000);
    	 
    	 arraylist_abs_students = tester1.readJSON();	//We read from the file abs_arraylist.json the objects from the classes YoungStudents, MidleStudents and ElderStudents that extend the abstract class Student 
         System.out.println("The data of the array list is:\n"+arraylist_abs_students);
         System.out.println("\nThe 1st object in the arraylist is: "+arraylist_abs_students.get(1));
         System.out.println("The 1st object in the arraylist is: "+arraylist_abs_students.get(2));
         System.out.println("The Name of 1st student is: "+((AbsStudent)arraylist_abs_students.get(1)).getName());
	}
		catch (JsonParseException e) {
         e.printStackTrace();
      } catch (JsonMappingException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
	
   public void createStudents() throws InterruptedException, JsonGenerationException, JsonMappingException, IOException {
		ArrayList<AbsStudent> arraylist_abs_students = new ArrayList<AbsStudent>();
		for (int i=20; i<30; i++) {	
			 YoungStudent student = new YoungStudent();
			 student.setAge(i-5);
			 student.setName("young_name_"+(i-20));
			 Date date = new Date();
			 student.setTimestamp(date.getTime());	         
			 arraylist_abs_students.add(student);
			 Thread.sleep(i);
			 
			 MiddleStudent student2 = new MiddleStudent();
			 student2.setAge(i+20);
			 student2.setName("middle_name_"+(i-20));
			 Date date2 = new Date();
			 student2.setTimestamp(date2.getTime());	         
			 arraylist_abs_students.add(student2);
			 Thread.sleep(i);
			 
			 ElderStudent student3 = new ElderStudent();
			 student3.setAge(i+40);
			 student3.setName("elder_name_"+(i-20));
			 Date date3 = new Date();
			 student.setTimestamp(date3.getTime());	         
			 arraylist_abs_students.add(student3);
			 Thread.sleep(i);
		} 
		this.writeJSON(arraylist_abs_students);	   
   }	

   public void writeJSON(ArrayList<AbsStudent> in_arraylist) throws JsonGenerationException, JsonMappingException, IOException{
      ObjectMapper mapper = new ObjectMapper();	
      mapper.enableDefaultTyping();
      AllStudents data = new AllStudents();
      data.setCollectionAllStudents(in_arraylist);
      mapper.writeValue(new File("abs_arraylist.json"), data);
   }

@SuppressWarnings("unchecked")
public ArrayList<AbsStudent> readJSON() throws JsonParseException, JsonMappingException, IOException{
      ObjectMapper mapper = new ObjectMapper();
      mapper.enableDefaultTyping();
      AllStudents data = mapper.readValue(new File("abs_arraylist.json"), AllStudents.class);
      return data.getCollectionAllStudents();
   }
}

abstract class AbsStudent {
   private String name;
   private int age;
   private long timestamp;
   public AbsStudent(){}
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public int getAge() {
      return age;
   }
   public void setAge(int age) {
      this.age = age;
   }
   public long getTimestamp() {
	  return timestamp;
   }
   public void setTimestamp(long timestamp) {
	   this.timestamp = timestamp;
   }
   public String toString(){
      return "Student [ name: "+name+", age: "+ age+ " ]";
   }	
   abstract void studentAbstractMethod(); 
}

class YoungStudent extends AbsStudent{
	@Override
	void studentAbstractMethod() {
		System.out.println("Young student"+this.toString());		
	}
}

class MiddleStudent extends AbsStudent{
	@Override
	void studentAbstractMethod() {
		System.out.println("Middle student"+this.toString());		
	}
}
   
class ElderStudent extends AbsStudent{
	@Override
	void studentAbstractMethod() {
		System.out.println("Elder student"+this.toString());		
	}
}

class AllStudents {
	private ArrayList<AbsStudent> collectionAllStudents;

	public ArrayList<AbsStudent> getCollectionAllStudents() {
		return collectionAllStudents;
	}

	public void setCollectionAllStudents(ArrayList<AbsStudent> collectionAllStudents) {
		this.collectionAllStudents = collectionAllStudents;
	}
}
