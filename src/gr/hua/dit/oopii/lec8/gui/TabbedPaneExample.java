package gr.hua.dit.oopii.lec8.gui;

import javax.swing.*;  
public class TabbedPaneExample {  
JFrame f;  
TabbedPaneExample(){  
    f=new JFrame();  
    JTextArea textArea1=new JTextArea("main text");  //We create 3 TextAreas
    textArea1.setBounds(10,30, 200,200);  
    
    JTextArea textArea2=new JTextArea("visit text");  
    textArea2.setBounds(10,30, 200,200);  
    
    JTextArea textArea3=new JTextArea("help text");  
    textArea3.setBounds(10,30, 200,200);  
    
    
    JPanel p1=new JPanel();  					//We create 3 Panels and we add each TextArea to a Panel
    p1.add(textArea1);  
    JPanel p2=new JPanel();  
    p2.add(textArea2);
    JPanel p3=new JPanel();  
    p3.add(textArea3);
    
    
    JTabbedPane tp=new JTabbedPane();  		//We make a TabbedPane. 
    tp.setBounds(50,50,200,200);  			//In the TabbedPAne, we add three tabs and each tab has a panel. 
    tp.add("main",p1);  
    tp.add("visit",p2);  
    tp.add("help",p3);    
    f.add(tp);  							//In the Fraim, we add the TabbedPane.
    f.setSize(400,400);  
    f.setLayout(null);  
    f.setVisible(true);  
}  
public static void main(String[] args) {  
    new TabbedPaneExample();  
}} 