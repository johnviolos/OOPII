package gr.hua.dit.oopii.lec5.streams;
import java.io.File;
import java.io.FileInputStream;
//lec 2
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class StreamsExample {
public static void main(String Args[]) throws Exception {
	
	setOutExample("file1.txt");			//It writes a String in a File. 
	//setOutExample("folderEx");		//If the file exists but is a directory rather than a regular file/ cannot be created/ cannot be opened for any other reason: then a [FileNotFoundException is thrown]
	//setInKeyboard();					//The input is from keyboard.
	//setInFile(); 						//The input is from File.
	//setErrFile();						//We redirect errors to File.
}

public static void setOutExample(String fileName) {
	FileOutputStream f = null;
	System.err.println("We write an error message");	//By convention, this output stream is used to display error messages
	try {
		f = new FileOutputStream(fileName);  		//Creates a file output stream to write to the file with the specified name.
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		System.err.println("Got an error: " + e);	//The "standard" error output stream.
		//e.printStackTrace();
	} 
	System.setOut(new PrintStream(f));  	// We define as output the file fileName
	System.out.println(sonnet); 			//Print a String to The "standard" output stream. This stream is already open and ready to accept output data. 
											//Typically this stream corresponds to display output or another output destination specified by the host environment or user.
}

public static void setInKeyboard() {
    @SuppressWarnings("resource")
	Scanner sc = new Scanner(System.in);//Scanner  produces values scanned from the specified input stream (system.in). 
    System.out.println("Printing the file passed in:");
    while(sc.hasNextLine()) System.out.println(sc.nextLine().toUpperCase());
    sc.close();
}

public static void setInFile() throws IOException {

    File file = new File("file1.txt");

    System.out.println("file exits: "+file.exists());

    FileInputStream stream = new FileInputStream(file);
    System.setIn(stream);		//Reassigns the "standard" input stream.

    System.out.println("-- reading from System.in --");

    byte[] data = new byte[1000];
    System.in.read(data);
    System.out.println(new String(data));
}

public static void setErrFile() throws Exception {
	System.err.println("This goes to the console");
	PrintStream console = System.err;

	File file = new File("err.txt");
	FileOutputStream fos = new FileOutputStream(file);
	PrintStream ps = new PrintStream(fos);
	System.setErr(ps);

	System.err.println("This goes to err.txt");

	try {
		throw new Exception("Exception goes to err.txt too");
	} catch (Exception e) {
		e.printStackTrace();
	}

	System.setErr(console);
	System.err.println("This also goes to the console");
}







static String sonnet="So is it not with me as with that Muse\n" + 
		"Stirr'd by a painted beauty to his verse,\n" + 
		"Who heaven itself for ornament doth use\n" + 
		"And every fair with his fair doth rehearse\n" + 
		"Making a couplement of proud compare,\n" + 
		"With sun and moon, with earth and sea's rich gems,\n" + 
		"With April's first-born flowers, and all things rare\n" + 
		"That heaven's air in this huge rondure hems.\n" + 
		"O' let me, true in love, but truly write,\n" + 
		"And then believe me, my love is as fair\n" + 
		"As any mother's child, though not so bright\n" + 
		"As those gold candles fix'd in heaven's air:\n" + 
		"Let them say more than like of hearsay well;\n" + 
		"I will not praise that purpose not to sell.";
}
