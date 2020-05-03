package gr.hua.dit.oopii.lec8.gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class CombinationExample {
	public static void  main(String args[]) {
		JFrame f = new JFrame("Frame1");
		JPanel p1 = new JPanel( );
		JButton b1 = new JButton("OK");
		JButton b2 = new JButton("Cancel");
		p1.add(b1);
		p1.add(b2); 
		JTextArea t=new JTextArea("The text is here!"); 
		f.getContentPane().setLayout(new BorderLayout()); 
		f.getContentPane().add(p1,BorderLayout.NORTH); 
		f.getContentPane().add(t,BorderLayout.CENTER);
		f.setSize(400,400); 
		f.setVisible(true); 
	}
}
