package gr.hua.dit.oopii.lec5.streams;
//slide 15
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileExample {

public static void main(String[] Args) {

	File numFile = new File("file1.txt"); 
	if (numFile.exists())
		System.out.println("The length of the file (chars):"+numFile.length());
	
	File file2 = new File("del_file.txt");
	System.out.println("Is the file deleted? "+file2.delete());
	
	File file3 = new File("new_file.txt");
	try {
		file3.createNewFile();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		file3.setReadOnly();		//We set the file as ReadOnly
	}
	System.out.println("Can I write in the "+file3.getName()+": "+ file3.canWrite());	
	System.out.println("The absolute path of "+file3.getName() +" is: "+file3.getAbsolutePath());
	
	File file4 = new File("new_folder");
	System.out.println("Can I create the "+file4.getName()+"? "+file4.mkdir());
	Date date = new Date(file4.lastModified());
	System.out.println("When did the "+file4.getName()+ " last modified? "+date);
	
	File file5 = new File("/Users/violos/Files/Coding/eclipse-workspace/Tests/");
	String[] fileNames= file5.list();
	System.out.println("The List of files: ");
	for (int i=0; i<fileNames.length; i++)
		{System.out.print(fileNames[i]+" ");
		if (i%5==0)
			System.out.println();
		}
	
	String userHome = System.getProperty("user.home"); //The path user.home of the user who runs the code 
	System.out.println("\n\nRelative path: "+userHome);
	File file6 = new File(""); //Current position
	System.out.println("What is my path now "+file6.getAbsolutePath());
	
}

}
