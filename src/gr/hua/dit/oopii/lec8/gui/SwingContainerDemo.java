package gr.hua.dit.oopii.lec8.gui;
//slide 19

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;

public class SwingContainerDemo {
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;
   private JLabel msglabel;

   public SwingContainerDemo(){
      prepareGUI();
   }
   public static void main(String[] args){
      SwingContainerDemo  swingContainerDemo = new SwingContainerDemo();  
      swingContainerDemo.showJPanelDemo();
   }
   private void prepareGUI(){
      mainFrame = new JFrame("Java Swing Examples");
      mainFrame.setSize(400,400);
      mainFrame.setLayout(new GridLayout(3, 1));
      
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });
      
      headerLabel = new JLabel("", JLabel.CENTER);        
      statusLabel = new JLabel("", JLabel.CENTER);    
      statusLabel.setSize(350,100);
      msglabel = new JLabel("Welcome to TutorialsPoint SWING Tutorial.", JLabel.CENTER);
      
      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());

      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.add(statusLabel);
      mainFrame.setVisible(true);  
   }
   private void showJPanelDemo(){
      headerLabel.setText("Container in action: JPanel");      
      JPanel panel = new JPanel();
      panel.setBackground(Color.magenta);
      panel.setLayout(new FlowLayout());        
      panel.add(msglabel);
      BevelBorder bb = new BevelBorder (BevelBorder.RAISED);
      controlPanel.setBorder(bb);
      controlPanel.add(panel);        
      mainFrame.setVisible(true);      
   }   
}