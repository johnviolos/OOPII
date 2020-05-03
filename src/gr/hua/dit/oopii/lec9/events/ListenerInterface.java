package gr.hua.dit.oopii.lec9.events;

import javax.swing.*;
import java.awt.event.*;
public class ListenerInterface extends JFrame implements MouseListener { 
	JButton button1;

	void init(){
		button1=new JButton("OK"); 
		this.add(button1); 
		button1.addMouseListener(this); // The mouseListener takes as input the mouse listener object that implements MouseListener
		this.setSize(200,200);			// Implementing the mouse listener we override the methods mouseExited & mouseEntered which have the functionality.
	} 


public void mouseClicked(MouseEvent e) { }
//είναι ταυτόχρονα πλαίσιο //και ακροατής
//παρόμοια οι mousePressed και mouseReleased
public void mouseExited(MouseEvent e) { button1.setText("OFF");} 
public void mouseEntered(MouseEvent e) { button1.setText("ON");} 

public static void main(String args[]){
ListenerInterface m=new ListenerInterface(); 
m.init();
m.show();
}
@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	
}}