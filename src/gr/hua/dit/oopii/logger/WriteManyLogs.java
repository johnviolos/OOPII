package gr.hua.dit.oopii.lec11.logger;
import java.util.logging.Level;
public class WriteManyLogs {

public static void main(String[] args) {
		
	HandlerExample obj1= new HandlerExample();
	for (int i=5; i<20; i++) {
	if(i%2==0)
		obj1.writeToLog(Level.SEVERE, "message ID: "+Integer.toString(i)+" added.");
	else
		obj1.writeToLog(Level.FINE, "message ID: "+Integer.toString(i)+" added.");
	}
		
}
}
