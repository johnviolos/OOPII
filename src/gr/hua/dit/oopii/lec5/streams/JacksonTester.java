//https://www.tutorialspoint.com/jackson/jackson_object_serialization.htm
package gr.hua.dit.oopii.lec5.streams;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
public class JacksonTester {
   
	public static void main(String args[]) throws InterruptedException{
      JacksonTester tester = new JacksonTester();
      ArrayList<Student> arraylist_students = new ArrayList<Student>();
      
      
      try {
		   for (int i=20; i<30; i++) {
		         Student student = new Student();
		         student.setAge(i);
		         student.setName("name_"+(i-20));
		         Date date = new Date();
		         student.setTimestamp(date.getTime());	         
		         arraylist_students.add(student);
		         Thread.sleep(i);
		   } 
		   tester.writeJSON(arraylist_students);

         //arraylist_students = tester.readJSON();
         //System.out.println("The data of the array list is:\n"+arraylist_students);
         //System.out.println("The 1st object in the arraylist is: "+arraylist_students.get(1));
		   }

		   catch (JsonParseException e) {
         e.printStackTrace();
      } catch (JsonMappingException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public void writeJSON(ArrayList<Student> in_arraylist) throws JsonGenerationException, JsonMappingException, IOException{
      ObjectMapper mapper = new ObjectMapper();	
      mapper.writeValue(new File("arraylist.json"), in_arraylist);
   }

   @SuppressWarnings("unchecked")
public ArrayList<Student> readJSON() throws JsonParseException, JsonMappingException, IOException{
      ObjectMapper mapper = new ObjectMapper();
	ArrayList<Student>  out_arraylist = mapper.readValue(new File("arraylist.json"), ArrayList.class);
      return out_arraylist;
   }
}

class Student {
   private String name;
   private int age;
   private long timestamp;
   public Student(){}
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
}