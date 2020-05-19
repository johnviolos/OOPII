package listenerInterface;

import javax.swing.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
public class TextFieldWithListener extends JFrame  { 
	private static JTextField tf1;
	private static JTextField tf2;

	public static String getTf1Text() {
		return tf1.getText();
	}
	public static void setTf1Text(String  textIn) {
		TextFieldWithListener.tf1.setText(textIn);
	}
	public static String getTf2Text() {
		return tf2.getText();
	}
	public static void setTf2Text(String  textIn) {
		TextFieldWithListener.tf2.setText(textIn);
		
	}




	
	
		void init(){
			KeyListener listener = new KeyListener() {
				 
				@Override				 
				public void keyPressed(KeyEvent event) {
				 
				    //System.out.println("Key Pressed");
				 
				}
				 
				@Override				 
				public void keyReleased(KeyEvent event) {
					ArrayList<String> mistakeWords = new ArrayList<String>( Arrays.asList("wrong", "mistake", "false"));
	
					System.out.println("Key Released");
					if (mistakeWords.contains(tf1.getText().toLowerCase())) //tf1.getText().equals("wrong")
					tf1.setForeground(Color.red);
					else 
						tf1.setForeground(Color.blue);
				 
				}
				 
				@Override				 
				public void keyTyped(KeyEvent event) {
				 
					//System.out.println("Key Typed");
				 
				}
				};
			
			JButton button1;
			button1=new JButton("upper case");
			button1.setSize(20,30);
			button1.addMouseListener(new UppercaseText());
					
			JButton button2;
			button2=new JButton("transform");
			button2.setSize(20,30);
			button2.addMouseListener(new FilterText());
			
			tf1 = new JTextField("enter text here");
			tf1.addKeyListener(listener);
			tf1.setColumns(40);
			
			tf2 = new JTextField("");
			tf2.setColumns(56);
			//tf2.setSize(400,200);
			
			JPanel myPanel=new JPanel();
			myPanel.setSize(800, 800);
			myPanel.add(button1);
			myPanel.add(button2);
			myPanel.add(tf1);
			myPanel.add(tf2);
			
			this.setContentPane(myPanel);
			this.setSize(800,800); 
			this.setVisible(true); 	
			this.addWindowListener(new WindowAdapter() {
		         public void windowClosing(WindowEvent windowEvent){
		             System.exit(0);
		          }        
		       });   
	} 


//public void mouseClicked(MouseEvent e) { }


public static void main(String args[]){
TextFieldWithListener m=new TextFieldWithListener(); 
m.init();
m.setVisible(true);
//.show();
}
}