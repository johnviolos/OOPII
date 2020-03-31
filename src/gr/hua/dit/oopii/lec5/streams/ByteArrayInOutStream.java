package gr.hua.dit.oopii.lec5.streams;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArrayInOutStream {
	  public static void main(String args[])throws IOException {
	      ByteArrayOutputStream bOutput = new ByteArrayOutputStream(12); // Creates a new byte array output stream, with a buffer capacity of the specified size,

	      while( bOutput.size()!= 10 ) {
	         // Gets the inputs from the user
	         bOutput.write("hello".getBytes()); 						// We write the String into the ByteArrayOutputStream. Encodes this String into a sequence of bytes.
	      }
	      byte b [] = bOutput.toByteArray();							// Creates a newly allocated byte array and the valid contents of the buffer have been copied into it
	      System.out.println("Print the content");
	      
	      for(int x = 0 ; x < b.length; x++) {
	         // printing the characters
	         System.out.print((char)b[x]  + "   "); 
	      }
	      System.out.println("   ");
	      
	      int c;
	      ByteArrayInputStream bInput = new ByteArrayInputStream(b);	//Creates a ByteArrayInputStream so that it uses buf as its buffer array. 
	      System.out.println("Converting characters to Upper case " );
	      
	      for(int y = 0 ; y < 1; y++) {
	         while(( c = bInput.read())!= -1) {
	            System.out.println(Character.toUpperCase((char)c));
	         }
	         bInput.reset(); 
	      }
	   }
}
