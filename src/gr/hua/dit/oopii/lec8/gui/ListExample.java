package gr.hua.dit.oopii.lec8.gui;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

public class ListExample {
	
	public static void main(String[] args) throws InterruptedException {
		JFrame f = new JFrame("Frame1");
		
		JPanel myPanel=new JPanel();		
		DefaultListModel dlm = new DefaultListModel();
		dlm.addElement(new Human("George", "Brown", 22, "6th Avenue")); 
		dlm.addElement(new Human("Mary", "Jones", 18, "5th Avenue")); 
		dlm.addElement(new Human("Bill", "Murray", 19, "Madison Avenue")); 
		JList	students = new JList(dlm);
		myPanel.add(students);
		myPanel.add(new JButton("clear"));
		myPanel.add(new JButton("copy"));
		myPanel.add(students);
		f.setContentPane(myPanel);
		f.setSize(550,280); 
		f.setVisible(true); 
		
		Thread.sleep(4000);
		Human h;
		Object[] selected=students.getSelectedValuesList().toArray(); 
		for (int i=0;i<selected.length;i++) {
			 h=(Human)selected[i];
			System.out.println(((Human)selected[i]).toString());}
				
		

	}
	
	
	public static class Human { String name; String surname; int age;
	String address;
	public Human(String name, String surname, int age, String address) {
	this.name = name; this.surname = surname; this.age = age; this.address = address;
	}
	@Override
	public String toString() {
	return this.name+" "+this.surname; }
	}
}
