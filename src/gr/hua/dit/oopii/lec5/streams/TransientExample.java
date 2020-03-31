package gr.hua.dit.oopii.lec5.streams;
//slide 27
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable; 
public class TransientExample {

public static void main(String args[])throws Exception{ 
	
	//serialize("transExam.dat");
	deserialize("transExam.dat");
}

public static void serialize(String fileName)throws Exception{  
	  Student s1 =new Student(211,"ravi",22);//creating object  
	  //writing object into file  
	  FileOutputStream f=new FileOutputStream(fileName);  
	  ObjectOutputStream out=new ObjectOutputStream(f);  
	  out.writeObject(s1);  
	  out.flush();  
	  
	  out.close();  
	  f.close();  
	  System.out.println("success");  
	 } 
 
public static void deserialize(String fileName)throws Exception{  
	  ObjectInputStream in=new ObjectInputStream(new FileInputStream(fileName));  
	  Student s=(Student)in.readObject();  
	  System.out.println(s.id+" "+s.name+" "+s.age);  
	  in.close();  
	 } 

public static class Student implements Serializable{  
	private static final long serialVersionUID = 1L;
	int id;  
	String name;  //If we make String name Transient then it will be null.
	transient int age;//Now it will not be serialized  
	 public Student(int id, String name,int age) {  
	  this.id = id;  
	  this.name = name;  
	  this.age=age;  
	 }  
	} 	
}

 

