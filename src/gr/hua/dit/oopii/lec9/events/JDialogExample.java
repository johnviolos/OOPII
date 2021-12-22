package gr.hua.dit.oopii.lec9.events;

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class JDialogExample {
	
		public static void  main(String args[]) {
			//jdialog();
			//jOptionPane();
			jFileChooser();
		}
		
public static void jdialog() {
	JFrame f = new JFrame("Frame1");
	f.setSize(1600,800); 
	f.setVisible(true); 
	
	JDialog dialog = new JDialog( f, "Dialog Frame",false);
	dialog.setSize(400, 200);
	JLabel label = new JLabel("This is a message");
	dialog.getContentPane().add(label);
	dialog.setVisible(true);
}

public static void jOptionPane() {
	JFrame myFrame = new JFrame("Frame1");
	myFrame.setSize(1600,800); 
	myFrame.setVisible(true); 
	int n = JOptionPane.showConfirmDialog(myFrame, "Is it OK?", "ConfirmDialog", JOptionPane.YES_NO_OPTION);	//n has the option of user in the showConfirmDialog.
	String s = (String)JOptionPane.showInputDialog(myFrame, "Name?");											//s  is the input String of user in the showInputDialog.
	JOptionPane.showMessageDialog(myFrame, "Hi!");
	
	Object[] options = {"Yes, please", "No way!"};
	int n2 = JOptionPane.showOptionDialog(myFrame, "Choose", "Choices",											//n2 is the option of user in the showOptionDialog.
	JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,options[0]);
	
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	System.out.println("Result 1: " +n);
	System.out.println("Result 2: " +s);
	System.out.println("Result 3: " +n2);

}

public static void jFileChooser() {
	JFileChooser fc = new JFileChooser();
	JButton b= new JButton("OK");
	JPanel myPanel=new JPanel();
	myPanel.add(b);
	int returnVal = fc.showOpenDialog(b);
	
	if (returnVal == JFileChooser.APPROVE_OPTION) { // αν ο χρήστης επέλεξε Open
		File file = fc.getSelectedFile(); //το path από το αρχείο που επέλεξε
		System.out.println("Opening: " + file.getAbsolutePath() + "." ); }
	else {
		System.out.println("Open command cancelled by user."); }
	
	fc.showDialog(b, "Save");	//We can also have the save button in the JFileCChooser
	JFrame f = new JFrame("Frame1");
	f.setContentPane(myPanel);
	f.setSize(250,80); 
	f.setVisible(true); 
	
	System.out.println(returnVal);
	
}
	
}
