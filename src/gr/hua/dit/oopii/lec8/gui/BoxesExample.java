package gr.hua.dit.oopii.lec8.gui;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;



public class BoxesExample {
	
	public static void  main(String args[]) {
	//jComboBox();
	//jCheckBox();
	jList();
	}

public static void  jComboBox() {    
	JFrame f = new JFrame("Frame1");
	f=new JFrame("ComboBox Example");    
    String country[]={"India","Aus","U.S.A","England","Newzealand"};        
    JComboBox cb=new JComboBox(country);    
    cb.setBounds(50, 50,90,20);    
    f.add(cb);        
    f.setLayout(null);    
    f.setSize(400,500);    
    f.setVisible(true);   
}
	
public static void  jCheckBox() {
	JFrame f = new JFrame("Frame1");
	JPanel myPanel=new JPanel();

	myPanel.add(new JCheckBox("case 1"));
	myPanel.add(new JCheckBox("case 2"));
	//Τα JRadioButton λειτουργούν σε ομάδες (ButtonGroup) και μόνο ένα επιλέγεται κάθε φορά.
	ButtonGroup options = new ButtonGroup( ); 
	JRadioButton rb1= new JRadioButton("Option 1"); 
	JRadioButton rb2= new JRadioButton("Option 2"); 
	options.add(rb1); 
	options.add(rb2); 
	myPanel.add(rb1); 
	myPanel.add(rb2);
	
	f.setContentPane(myPanel);
	f.setSize(350,80); 
	f.setVisible(true); 
}
	
	
public static void jList(){
	JFrame f= new JFrame();  
    DefaultListModel<String> l1 = new DefaultListModel<>();  
    l1.addElement("Item1");  
    l1.addElement("Item2");  
    l1.addElement("Item3");  
    l1.addElement("Item4");  
    JList<String> list = new JList<>(l1);  
    list.setBounds(100,100, 75,75);  
    f.add(list);  
    f.setSize(400,400);  
    f.setLayout(null);  
    f.setVisible(true);  
    try {
		Thread.sleep(4000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    System.out.println(list.getSelectedValuesList().get(0)); //What we have selected.
}

}
