package gr.hua.dit.oopii.lec5.streams;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileExample {
	public static void main(String[] args) {
		   
	      try {
	         // create a new RandomAccessFile with filename test
	         RandomAccessFile raf = new RandomAccessFile("raf.txt", "rw");

	         // write something in the file
	         raf.writeUTF("Hello World");

	         // set the file pointer at 0 position
	         raf.seek(0);

	         // print the string
	         System.out.println("" + raf.readUTF());

	         // set the file pointer at 0 position
	         raf.seek(0);

	         // attempt to skip 10 bytes and print the number of bytes skipped
	         System.out.println("" + raf.skipBytes(5));

	         // print what is left after skipping
	         System.out.println("" + raf.readLine());

	         // set the file pointer to position 8
	         raf.seek(8);

	         // attempt to skip 10 more bytes and print the number of bytes skipped
	         System.out.println("" + raf.skipBytes(10));
	         raf.close();
	         
	      } catch (IOException ex) {
	         ex.printStackTrace();
	      }
	   }
	
	
}
