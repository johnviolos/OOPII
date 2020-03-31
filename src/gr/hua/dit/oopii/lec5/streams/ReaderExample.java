package gr.hua.dit.oopii.lec5.streams;
//slide 10
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

public class ReaderExample {
	public static void main(String[] args) throws Exception {
		//bufferedReader();
		lineNumberReader();
		
	}	
	   public static void bufferedReader() throws Exception {
		      String thisLine = null;
		      
		      try {
		        
		    	  InputStream is = new FileInputStream("file3.txt");
		    	  InputStreamReader isr = new InputStreamReader(is);
		    	  BufferedReader br = new BufferedReader(isr);
		         
		         while ((thisLine = br.readLine()) != null) {
		            System.out.println(thisLine);
		         }  
		         
		         
		         br.close();
		      } catch(Exception e) {
		         e.printStackTrace();
		      }
		   }
	   
	   public static void lineNumberReader() throws IOException {
		      FileReader fr = null;
		      LineNumberReader lnr = null;
		      String str;
		      int i;
		      
		      try {
		         // create new reader
		         fr = new FileReader("file3.txt");
		         lnr = new LineNumberReader(fr);
		   
		         // read lines till the end of the stream
		         while((str = lnr.readLine())!=null) {
		            i = lnr.getLineNumber();
		            System.out.print("("+i+")");
		                  
		            // prints string
		            System.out.println(str);
		         }
		         
		      } catch(Exception e) {
		         // if any error occurs
		         e.printStackTrace();
		      } finally {
		         // closes the stream and releases system resources
		         if(fr!=null)
		            fr.close();
		         if(lnr!=null)
		            lnr.close();
		      }
		   }
}
