package gr.hua.dit.oopii.lec5.streams;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;

public class CombinationOfStreams {
	public static void main(String Args[]) throws Exception {
    BufferedInputStream bis = null;
    FileInputStream inStream = null;
    DataInputStream dis = null;

       // open input stream test.txt for reading purpose.
       inStream = new FileInputStream("file1.txt");

       // input stream is converted to buffered input stream
       bis = new BufferedInputStream(inStream);      
       
       dis = new DataInputStream(bis);
       
       DataInputStream	dis2 = new DataInputStream(new BufferedInputStream(new FileInputStream("file1.txt")));
       
       for (int i=0; i<150;i++)
    	   System.out.print((char)dis.readByte());

       dis.close();
}
	}
