package gr.hua.dit.oopii.lec5.streams;
import java.io.*; 
public class SequenceInOutStream {


  public static void main(String args[])throws Exception{    
   FileInputStream fin1=new FileInputStream("file1.txt");    
   FileInputStream fin2=new FileInputStream("file3.txt");    
   FileOutputStream fout=new FileOutputStream("file4.txt");      
   SequenceInputStream sis=new SequenceInputStream(fin1,fin2);    //It concatenates two Stream sequences.
   int i;    
   while((i=sis.read())!=-1)    
   {    
     fout.write(i);        
   }    
   sis.close();    
   fout.close();      
   fin1.close();      
   fin2.close();       
   System.out.println("Success..");  
  }    
	 	
	
}
