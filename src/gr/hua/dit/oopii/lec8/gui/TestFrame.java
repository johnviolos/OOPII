package gr.hua.dit.oopii.lec8.gui;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class TestFrame extends JFrame { 
	JTextField tf; 
	JTextArea ta; 
	JPasswordField pf; 
	JScrollPane jsp; 
	public TestFrame() {
tf = new JTextField(); ta = new JTextArea(); ta.setText("Your Text will appear"); ta.append("\nhere:\n");
pf = new JPasswordField("hidden");
jsp = new JScrollPane(); jsp.getViewport().add(ta); 
this.setLayout(new GridLayout(3, 3)); this.getContentPane().add(tf); this.getContentPane().add(jsp); this.getContentPane().add(pf);
String password=pf.getText();
ta.append(password); this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
} 
	
	public static void main(String[] args) {TestFrame tf = new TestFrame();
	tf.setSize(1600,800); 
	tf.setVisible(true); }
}