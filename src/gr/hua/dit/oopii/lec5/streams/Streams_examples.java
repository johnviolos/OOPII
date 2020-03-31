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
		channelprocessing();
		//serializableWrite_obj();
		//serializableRead_obj();
		
		//serializableWrite();
		//copyFiles();
		//fileInfos();
		//checkFile();
	}

public static void fileoutput() {

FileOutputStream f = null;

try {
	f = new FileOutputStream("file.txt");
} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} 
System.setOut(new PrintStream(f));
System.out.println("We write words."); //Check the file it has written this text.}
}

public static void checkFile() {
	
	String path = System. getProperty("user.dir");			//We see the current path.
	System.out.println("Working Directory = " + path);
	
	File numFile = new File("file.txt"); if (numFile.exists())
	System.out.println("The length of the file is: "+numFile.length());
	System.out.println("The name of the file is: "+numFile.getName());
	System.out.println("The absolute path of the file is: "+numFile.getAbsolutePath());
}

public static void fileInfos() {
	File smileyFile = new File("file.txt"); 
	try {
		@SuppressWarnings("resource")
		FileInputStream smileyInStream = new FileInputStream(smileyFile);
		System.out.println("info:"+(char)smileyInStream.read());
		System.out.println("info:"+(char)smileyInStream.read());
		System.out.println("info:"+(char)smileyInStream.read());
		System.out.println("info:"+(char)smileyInStream.read());
		System.out.println("info:"+(char)smileyInStream.read());
		System.out.println("info:"+(char)smileyInStream.read());
		System.out.println("info:"+(char)smileyInStream.read());
		System.out.println("info:"+(char)smileyInStream.read());
		System.out.println("info:"+(char)smileyInStream.read());
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
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
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	
}

public static void serializableWrite() {

	try{FileOutputStream out = new FileOutputStream("output.dat"); 
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


public static void serializableWrite_obj() {
Foo obj= new Foo();
	try{FileOutputStream out = new FileOutputStream("ser_out.dat"); 
			ObjectOutputStream s = new ObjectOutputStream(out); 
			s.writeObject(obj);
			//s.writeObject(new Date());
			s.flush();
			s.close();
			
		
		} 
			catch (Exception e){
			e.printStackTrace(); }
}

public static void serializableRead_obj() {
	FileInputStream in;
	try {
		in = new FileInputStream("ser_out.dat");
		ObjectInputStream t=new ObjectInputStream(in);
		Foo ser_obj = (Foo)t.readObject();
		System.out.println(ser_obj.printObj());
		t.close();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
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
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
}

public static void channelprocessing() {
	
	RandomAccessFile file = null;
	try {
		file = new RandomAccessFile("sonnet.txt", "r");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
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
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

		

	
}

}
