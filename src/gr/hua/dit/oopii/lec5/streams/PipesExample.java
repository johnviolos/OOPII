//We have a pipe in which we put data and take them later/
package gr.hua.dit.oopii.lec5.streams;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipesExample {
	public static void main(String[] args) throws IOException {
		//pipeWriteRead();
		readWithBuffer();
	}
	
public static void pipeWriteRead()  throws IOException { 
	PipedInputStream geek_input = new PipedInputStream(); 
    PipedOutputStream geek_output = new PipedOutputStream(); 
    try
    { 
        // Use of connect() : connecting geek_input with geek_output 
            geek_input.connect(geek_output); 
  
            // Use of read() method : 
        geek_output.write(75); //We put data in the pipe with the: PipedOutputStream.write()
        System.out.println("using read() : " + (char)geek_input.read()); //We read data from the pipe with the: PipedInputStream.read()
        geek_output.write(70); 
        System.out.println("using read() : " + (char)geek_input.read()); 
        geek_output.write("k".codePointAt(0)); 
        System.out.println("using read() : " + (char)geek_input.read()); 
        geek_input.close();
    } 
    catch (IOException excpt) 
    { 
        excpt.printStackTrace(); 
    } 
} 

public static void readWithBuffer() throws IOException //We also use a buffer (ArrayList)
{ 
    PipedInputStream geek_input = new PipedInputStream(); 
    PipedOutputStream geek_output = new PipedOutputStream(); 
    try
    { 
        // Use of connect() : connecting geek_input with geek_output 
        geek_input.connect(geek_output); 

        geek_output.write(71); 
        geek_output.write(69); 
        geek_output.write(69); 
        geek_output.write(75); 
        geek_output.write(83); 

        // Use of available() : 
        System.out.println("Use of available() : " + geek_input.available()); 

        // Use of read(byte[] buffer, int offset, int maxlen) : 
        byte[] buffer = new byte[5]; 
        // destination 'buffer' 
        geek_input.read(buffer, 0, 5); 

        String str = new String(buffer); 
        System.out.println("Using read(buffer, offset, maxlen) : " + str); 

        // Use of close() method : 
        System.out.println("Closing the stream"); 
        geek_input.close(); 

    } 
    catch (IOException excpt) 
    { 
        excpt.printStackTrace(); 
    } 
}
}
