package gr.hua.dit.oopii.lec8.gui;
//slide 43
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class ButtonExample {
	
	public static void  main(String args[]) {
		JButton b= new JButton("OK");
	
	JToggleButton tb1= new JToggleButton("ON"); JToggleButton tb2= new JToggleButton("OFF");
	ButtonGroup buttonGroup = new ButtonGroup(); 
	tb1.setMnemonic('n'); // Ενεργοποιείται με ALT+n 
	tb1.setToolTipText("This is the ON button"); 
	tb2.setMnemonic('f'); // Ενεργοποιείται με ALT+f 
	tb2.setToolTipText("This is the OFF button"); 
	buttonGroup.add(tb1);
	buttonGroup.add(tb2);
	JPanel myPanel=new JPanel();
	myPanel.add(tb1);
	myPanel.add(tb2);
	myPanel.add(b);
	JFrame f = new JFrame("Frame1");
	f.setContentPane(myPanel);
	f.setSize(250,80); 
	f.setVisible(true); 
}
}
