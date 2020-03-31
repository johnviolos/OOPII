package gr.hua.dit.oopii.lec5.streams;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;


public class NIOexample {
   public static void main(String args[]) throws IOException {

      readWriteFileChannel();
   }
   public static void readWriteFileChannel() throws IOException {
      RandomAccessFile randomAccessFile = new RandomAccessFile("file8.txt","rw");
      FileChannel fileChannel = randomAccessFile.getChannel();
      ByteBuffer byteBuffer = ByteBuffer.allocate(512);
      Charset charset = Charset.forName("US-ASCII");
      while (fileChannel.read(byteBuffer) > 0) {//We read 512 chars per time
         byteBuffer.rewind();		//sets the position back to 0, so you can reread all the data in the buffer
         System.out.print(charset.decode(byteBuffer)); //Convenience method that decodes bytes in this charset into Unicode characters.         
      }
     // byteBuffer=ByteBuffer.wrap("We write new text!".getBytes());
      byteBuffer.flip();
      byteBuffer.putChar('w');byteBuffer.putChar('e');byteBuffer.putChar(' '); byteBuffer.putChar('w'); byteBuffer.putChar('r');byteBuffer.putChar('i');
      byteBuffer.putChar('t'); byteBuffer.putChar('e');byteBuffer.putChar('.');
      byteBuffer.flip();
    
      fileChannel.write(byteBuffer);	//We can have two different buffers that are connected to the same channel.      
      fileChannel.close();
      randomAccessFile.close();
   }
  
}