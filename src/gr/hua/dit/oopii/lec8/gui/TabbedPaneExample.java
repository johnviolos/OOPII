package gr.hua.dit.oopii.lec8.gui;

import javax.swing.*;  
public class TabbedPaneExample {  
JFrame f;  
TabbedPaneExample(){  
    f=new JFrame();  
    JTextArea textArea1=new JTextArea("main text");  
    textArea1.setBounds(10,30, 200,200);  
    
    JTextArea textArea2=new JTextArea("visit text");  
    textArea2.setBounds(10,30, 200,200);  
    
    JTextArea textArea3=new JTextArea("help text");  
    textArea3.setBounds(10,30, 200,200);  
    
    
    JPanel p1=new JPanel();  
    p1.add(textArea1);  
    JPanel p2=new JPanel();  
    p2.add(textArea2);
    JPanel p3=new JPanel();  
    p3.add(textArea3);
    
    
    JTabbedPane tp=new JTabbedPane();  
    tp.setBounds(50,50,200,200);  
    //tp.addTab("main",p1);
    tp.add("main",p1);  
    tp.add("visit",p2);  
    tp.add("help",p3);    
    f.add(tp);  
    f.setSize(400,400);  
    f.setLayout(null);  
    f.setVisible(true);  
}  
public static void main(String[] args) {  
    new TabbedPaneExample();  
}} 