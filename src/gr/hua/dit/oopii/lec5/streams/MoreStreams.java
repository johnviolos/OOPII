package gr.hua.dit.oopii.lec5.streams;
//slide 6
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class MoreStreams {
public static void main(String args[])throws Exception{  
	printStream();
	bufferedInputStream();
}


public static void printStream()throws Exception{  			//It writes in OutputStream Strings with println. no chars or bytres
   FileOutputStream fout=new FileOutputStream("file4.txt");  
   PrintStream pout=new PrintStream(fout);  
   pout.println(1900);  
   pout.println("Hello Java");  
   pout.println("Welcome to Java");  
   pout.close();  
   fout.close();  
}  

public static void bufferedInputStream() throws Exception {
    BufferedInputStream bis = null;
    FileInputStream inStream = null;
    DataInputStream dis = null;
	try {
       // open input stream test.txt for reading purpose.
       inStream = new FileInputStream("file4.txt");

       // input stream is converted to buffered input stream
       bis = new BufferedInputStream(inStream);      
       
       dis = new DataInputStream(bis);
       dis.readChar();
       // read until a single byte is available
       while( bis.available() > 0 ) {
          
          // get the number of bytes available
          Integer nBytes = bis.available();
          System.out.println("Available bytes = " + nBytes );

          // read next available character
          char ch =  (char)bis.read();

          // print the read character.
          System.out.println("The character read = " + ch );
       }
    } catch(Exception e) {
       e.printStackTrace();
    } finally {
       // releases any system resources associated with the stream
       if(inStream!=null)
          inStream.close();
       if(bis!=null)
          bis.close();
    }
 }

public static void bufferedOutputStream() throws Exception {
    ByteArrayOutputStream baos = null;
    BufferedOutputStream bos = null;
		
    try {
       // create new ByteArrayOutputStream
       baos = new ByteArrayOutputStream();

       // create new BufferedOutputStream with baos
       bos = new BufferedOutputStream(baos);
			
       // assign integer
       int b = 87;

       // write to stream
       bos.write(b);

       // force the byte to be written to baos
       bos.flush();
			
       // convert ByteArrayOutputStream to bytes
       byte[] bytes = baos.toByteArray();	

       // prints the byte
       System.out.println(bytes[0]);
       
    } catch(IOException e) {
       // if I/O error occurs.
       e.printStackTrace();
    } finally {
       // releases any system resources associated with the stream
       if(baos!=null)
          baos.close();
       if(bos!=null)
          bos.close();
    }
 }
public static void dataInputStream()throws IOException {

    // writing string to a file encoded as modified UTF-8
    DataOutputStream dataOut = new DataOutputStream(new FileOutputStream("file.txt"));
    dataOut.writeUTF("hello");
    

    // Reading data from the same file
    DataInputStream dataIn = new DataInputStream(new FileInputStream("file.txt"));

    while(dataIn.available()>0) {
       String k = dataIn.readUTF();
       System.out.print(k+" ");
    }
    dataIn.close();
    dataOut.close();
 }

}
