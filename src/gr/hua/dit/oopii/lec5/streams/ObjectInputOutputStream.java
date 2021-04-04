package gr.hua.dit.oopii.lec5.streams;
//slide 5
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectInputOutputStream {
	public static void main(String[] args) {

		Person p1 = new Person("John", 30, "Male");				//Person implements Serializable interface in order to save it in file.
		Person p2 = new Person("Rachel", 25, "Female");

		try {
			FileOutputStream f = new FileOutputStream(new File("myObjects.txt"));	//Output
			ObjectOutputStream o = new ObjectOutputStream(f);	//The ObjectOutput takes as input the FileOutput

			o.writeObject(p1);	// Write objects to file
			o.writeObject(p2);

			o.close();			// we close the ObjectOutputStream
			f.close();			// we close the file output stream

			FileInputStream fi = new FileInputStream(new File("myObjects.txt"));	//Input
			ObjectInputStream oi = new ObjectInputStream(fi);

			Person pr1 = (Person) oi.readObject();	// Read objects
			Person pr2 = (Person) oi.readObject();

			System.out.println(pr1.toString());
			System.out.println(pr2.toString());

			oi.close();
			fi.close();

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	public static class Person implements Serializable {

		private static final long serialVersionUID = 1L;
		private String name;
		private int age;
		private String gender;

		Person() {
		};

		Person(String name, int age, String gender) {
			this.name = name;
			this.age = age;
			this.gender = gender;
		}

		@Override
		public String toString() {
			return "Name:" + name + "\nAge: " + age + "\nGender: " + gender;
		}
	}

	    
}
