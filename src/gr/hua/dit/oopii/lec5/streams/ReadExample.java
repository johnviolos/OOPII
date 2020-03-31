package gr.hua.dit.oopii.lec5.streams;
//slide 4
import java.io.FileInputStream;
import java.io.InputStream;
//https://www.tutorialspoint.com/java/io/inputstream_read_byte_len.htm
public class ReadExample {

public static void main(String Args[])throws Exception {
	  InputStream is = null; // InputStream is abstract class
      byte[] buffer = new byte[150];		      
      //char[] buffer2 = new char[150]; 			//InputStream use as buffer a byte array not char array.
      char c;
      
      try {
         
         is = new FileInputStream("file1.txt"); // new input stream created FileInputStream extends InputStream
         System.out.println("The number of available bytes is: "+is.available());
         System.out.println("Characters printed:");		        
         is.read(buffer, 2, 111); 				// read stream data into buffer
         
         for(byte b:buffer) {   				// for each byte in the buffer        	 
            if(b == 'o')						//Replaces the o to 0 (zero)
               c = '0';
            else	               
               c = (char)b;						//convert byte to character            
            System.out.print(c);				//the b is byte try with b
         }System.out.println();
        
         is.skip(5);
            System.out.println("\nThe number of available bytes is:"+is.available());
            is.mark(250);
            for (int i=0;i<10;i++)
            System.out.println("current char:"+ (char)is.read());
            System.out.println("Is Mark supported? "+ is.markSupported());
     
         is.close();
      } catch(Exception e) {
         // if any I/O error occurs
         e.printStackTrace();
      } finally {
         // releases system resources associated with this stream
         if(is!=null)
            is.close();
      }
   }
}

