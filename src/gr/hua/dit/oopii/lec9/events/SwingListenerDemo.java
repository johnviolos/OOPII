package gr.hua.dit.oopii.lec9.events;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SwingListenerDemo {
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;
   JFrame aboutFrame;
   public SwingListenerDemo(){
      prepareGUI();
   }
   public static void main(String[] args){
      SwingListenerDemo  swingListenerDemo = new SwingListenerDemo();  
      swingListenerDemo.showWindowListenerDemo();
   }
   private void prepareGUI(){
      mainFrame = new JFrame("Java SWING Examples");
      mainFrame.setSize(400,400);
      mainFrame.setLayout(new GridLayout(3, 1));

      headerLabel = new JLabel("",JLabel.CENTER );
      statusLabel = new JLabel("",JLabel.CENTER);        
      statusLabel.setSize(350,100);
      
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    
      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());

      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.add(statusLabel);
      mainFrame.setVisible(true);  
   }
   private void showWindowListenerDemo(){
      headerLabel.setText("Listener in action: WindowListener");      
      JButton okButton = new JButton("OK");

      aboutFrame = new JFrame();
      aboutFrame.setSize(300,200);;
      aboutFrame.setTitle("WindowListener Demo");
      aboutFrame.addWindowListener(new CustomWindowListener());
      
      JPanel panel = new JPanel();      
      panel.setBackground(Color.white);            
      JLabel msglabel = new JLabel("Welcome to TutorialsPoint SWING Tutorial."
         ,JLabel.CENTER);        
      panel.add(msglabel);
      aboutFrame.add(panel);
      aboutFrame.setVisible(true); 
   }
   class CustomWindowListener implements WindowListener {
      public void windowOpened(WindowEvent e) {
    	  aboutFrame.setTitle("WindowListener windowOpened");
    	  headerLabel.setText("Listener in action: windowOpened");
      }
      public void windowClosing(WindowEvent e) {
         aboutFrame.dispose();
      }
      public void windowClosed(WindowEvent e) {
    	  aboutFrame.setTitle("WindowListener windowClosed");
    	  headerLabel.setText("Listener in action: windowClosed");
      }
      public void windowIconified(WindowEvent e) {
    	  aboutFrame.setTitle("WindowListener windowIconified");
    	  headerLabel.setText("Listener in action: windowIconified");
      }
      public void windowDeiconified(WindowEvent e) {
      }
      public void windowActivated(WindowEvent e) {
    	  aboutFrame.setTitle("WindowListener windowActivated");
    	  headerLabel.setText("Listener in action: windowActivated");
      }
      public void windowDeactivated(WindowEvent e) {
    	  aboutFrame.setTitle("WindowListener windowDeactivated");
    	  headerLabel.setText("Listener in action: windowDeactivated");
      }
   }   
}