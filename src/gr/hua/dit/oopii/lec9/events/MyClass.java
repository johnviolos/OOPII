package gr.hua.dit.oopii.lec9.events;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyClass extends JFrame { 
	JButton button1;
	void init(){
		button1=new JButton("OK");
		button1.setSize(20,30);
		JTextField tf = new JTextField("Text here!");
		tf.setSize(200,200);
		
		JPanel myPanel=new JPanel();
		myPanel.setSize(300, 200);
		myPanel.add(button1);
		myPanel.add(tf);
		
		
		button1.addMouseListener(new MouseAdapter(){
			public void mouseExited(MouseEvent e) { 
				button1.setText("OFF");
			} 
		
			public void mouseEntered(MouseEvent e) { 
				button1.setText("ON");
			}
			
			public void mouseClicked(MouseEvent e) {
				button1.setText("clicked");
				tf.setText("We clicked the button");
			}
		});
		
		
		
		this.setContentPane(myPanel);
		this.setSize(300,200); 
		this.setVisible(true); 	
	}
public static void main(String args[]){ 
	MyClass mc = new MyClass();
	mc.init();
} 

}