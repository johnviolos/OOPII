package gr.hua.dit.oopii.lec5.streams;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;

public class Streams_examples {
	public static void main(String args[] ){ 
		@SuppressWarnings("unused")
		int million = 1_000_000;	
		checkFile();					//Relative and Absolute paths.
		//serializableWriteObj();		// We read/write objects of our classes
		//serializableReadObj();	
		//serializableWrite();			//We can also read/write primitive types and objects from standard libraries.  			
		//fileRead();					//Simple read data from file using the FileInputStream.
		//copyFiles();					// Copy Files as Streams line by line. We can process the data with good granularity.
		//copyFiles2(); 					//It copies file using the Files.copy(src, dst) from source to destination. We cannot process the data. 
		//channelprocessing();
	}
	public static void serializableWriteObj() {
		Foo obj= new Foo();							//The class Foo implements the marker interface Serializable
			try{	FileOutputStream out = new FileOutputStream("ser_out.dat"); 	//output stream for writing data to a File 
					ObjectOutputStream s = new ObjectOutputStream(out); 			//write both primitive types and object instances to an underlying OutputStream
					s.writeObject(obj);												//to write an object to the stream
					//s.writeObject(new Date());
					s.flush();
					s.close();					
				} 
					catch (Exception e){
					e.printStackTrace(); }
		}

	public static void serializableReadObj() {
		FileInputStream in;
		try {
			in = new FileInputStream("ser_out.dat");			//Input stream for Reading data to a File 
			ObjectInputStream t=new ObjectInputStream(in);		//Recover those objects previously serialized
			Foo ser_obj = (Foo)t.readObject();					//method read an object from the ObjectInputStream. We also make the casting
			System.out.println(ser_obj.printObj());
			t.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		
	}

	public static void serializableWrite() {

		try{
				FileOutputStream out = new FileOutputStream("output.dat"); 
				ObjectOutputStream s = new ObjectOutputStream(out); 
				s.writeObject("Today");
				s.writeObject(new Date());
				s.flush();
				s.close();
				
				FileInputStream in = new FileInputStream("output.dat"); 
				ObjectInputStream t=new ObjectInputStream(in);
				String today = (String)t.readObject();
				Date date = (Date)t.readObject();
				t.close();
				System.out.println(today+"\n"+date);		
			} 
			catch (Exception e){
				e.printStackTrace(); }
	}
	
public static void fileoutput() {

FileOutputStream f = null;

try {
	f = new FileOutputStream("file.txt");
} catch (FileNotFoundException e) {
	e.printStackTrace();
} 
System.setOut(new PrintStream(f));
System.out.println("We write words."); //Check the file it has written this text.
}

public static void checkFile() {	
	String path = System. getProperty("user.dir");			//We see the current path. In this path we can add the relative path.
	System.out.println("Working Directory = " + path);	
	File numFile = new File("file.txt"); 					//File is a representation of a file or directory path name. In the constructor we can put and String that declares a path.
	if (numFile.exists())									//We check if the file exists
		System.out.println("The length of the file is: "+numFile.length());		
	System.out.println("The name of the file is: "+numFile.getName());
	System.out.println("The absolute path of the file is: "+numFile.getAbsolutePath());
}

public static void fileRead() {
	File smileyFile = new File("file.txt"); 
	try {
		@SuppressWarnings("resource")
		FileInputStream smileyInStream = new FileInputStream(smileyFile);
		System.out.println("info:"+(char)smileyInStream.read());			//We read byte byte and cast them to char.
		System.out.println("info:"+(char)smileyInStream.read());
		System.out.println("info:"+(char)smileyInStream.read());
		System.out.println("info:"+(char)smileyInStream.read());
		System.out.println("info:"+(char)smileyInStream.read());
		System.out.println("info:"+(char)smileyInStream.read());
		System.out.println("info:"+(char)smileyInStream.read());
		System.out.println("info:"+(char)smileyInStream.read());
		System.out.println("info:"+(char)smileyInStream.read());		
	} catch (FileNotFoundException e) { //The attempt to open the file denoted by a specified pathname has failed. It extends the IOException
		e.printStackTrace();
	} catch (IOException e) {			//The general IOException is related to any Input and Output operations
		e.printStackTrace();
	}	
	if (smileyFile.canRead()){ 
		System.out.println("Last modified: "+smileyFile.lastModified());
	}
}

public static void copyFiles() {
	try {
		@SuppressWarnings("resource")
		BufferedReader eisodos = new BufferedReader(new FileReader("file.txt"));
		PrintWriter exodos =new PrintWriter(new BufferedWriter(new FileWriter("new_file.txt")));
		String s;
		int lineCount=0;
		while((s = eisodos.readLine()) != null )
		exodos.println(lineCount++ + ": " + s);
		exodos.close();
		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}	
	
}

	public static void copyFiles2() {
		Path src = Paths.get("/home/fred/readme.txt");
		Path dst = Paths.get("/home/fred/copy_readme.txt"); 
		try {
			Files.copy(src, dst,
			StandardCopyOption.COPY_ATTRIBUTES, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

	public static void channelprocessing() {
		
		RandomAccessFile file = null;
		try {
			file = new RandomAccessFile("file1.txt", "r");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		FileChannel fileChannel = file.getChannel();
		ByteBuffer byteBuffer = ByteBuffer.allocate(512);
		try {
			while (fileChannel.read(byteBuffer) > 0) { //The channel takes data from the buffer.
				// flip the buffer to prepare for get operation
				byteBuffer.flip();
				while (byteBuffer.hasRemaining()) {
					System.out.print((char) byteBuffer.get());
				}
				// clear the buffer ready for next sequence of read
				byteBuffer.clear();
				
			}
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

}
