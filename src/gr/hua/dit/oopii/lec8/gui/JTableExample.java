package gr.hua.dit.oopii.lec8.gui;
//slide 48
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import gr.hua.dit.oopii.lec8.gui.ListExample.Human;

public class JTableExample {
	public static void main(String[] args) {
		JFrame f = new JFrame("Frame1");
		
		JPanel myPanel=new JPanel();		

		
		String[] columnNames = {"First Name", "Last Name", "Age", "Address"}; 
		Object[][] data = {{"George", "Brown", new Integer(22), "6th Avenue"},
		{"Mary", "Jones", new Integer(18), "5th Avenue"},
		{"Bill", "Murray", new Integer(19), "Madison Avenue"}}; 
		
		DefaultTableModel dtm = new DefaultTableModel(data,columnNames); 
		JTable studentsTable=new JTable(dtm);
		JScrollPane jsp2 = new JScrollPane(); 
		jsp2.getViewport().add(studentsTable); 
		myPanel.add(jsp2);
		
		f.setContentPane(myPanel);
		f.setSize(550,280); 
		f.setVisible(true); 
	}
}
