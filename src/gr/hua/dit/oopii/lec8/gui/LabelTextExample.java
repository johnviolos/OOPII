package gr.hua.dit.oopii.lec8.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.TextArea;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class LabelTextExample {
	public static void main(String[] args) {texts();}
	
	
	public static void labels() {
		JLabel label1 = new JLabel("JLabel");
		JLabel label2 = new JLabel("JLabel",SwingConstants.CENTER); 
		label2.setOpaque(true); label2.setBackground(Color.white);
		JLabel label3 = new JLabel("JLabel",SwingConstants.CENTER); 
		label3.setFont(new Font("Helvetica", Font.BOLD, 18)); 
		label3.setOpaque(true); label3.setBackground(Color.white);
		ImageIcon icon = new ImageIcon("java_image.jpg");
		
		JLabel label4 = new JLabel("JLabel",icon, SwingConstants.RIGHT); 
		label4.setVerticalTextPosition(SwingConstants.TOP); 
		label4.setOpaque(true); 
		label4.setBackground(Color.white);
		JPanel myPanel=new JPanel();
		myPanel.add(label1); 
		myPanel.add(label2);
		myPanel.add(label3); 
		myPanel.add(label4);
		JFrame f = new JFrame("Frame1");
		f.setContentPane(myPanel);
		f.setSize(1600,800); 
		f.setVisible(true); 
	}
	
	public static void texts() {
		JTextField tf1 = new JTextField();
		JTextField tf2 = new JTextField("text");
		JTextField tf3 = new JTextField("more text",40); 
		tf2.getText();
		tf1.setText("empty");
		TextArea ta= new TextArea();
		ta.append("text"); 
		ta.append("\nline2"); 
		JPasswordField pf=new JPasswordField("hidden");
		
		JPanel myPanel=new JPanel();
		myPanel.add(tf1);
		myPanel.add(tf2);
		myPanel.add(tf3);
		myPanel.add(ta); 
		myPanel.add(pf); 
		JFrame f = new JFrame("Frame1");
		f.setContentPane(myPanel);
		f.setSize(1600,800); 
		f.setVisible(true); 
	}
}
