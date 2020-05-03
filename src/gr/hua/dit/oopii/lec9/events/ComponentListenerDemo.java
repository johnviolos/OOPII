package gr.hua.dit.oopii.lec9.events;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ComponentListenerDemo {
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;

   public ComponentListenerDemo(){
      prepareGUI();
   }
   public static void main(String[] args){
      ComponentListenerDemo  componentListenerDemo = new ComponentListenerDemo();  
      componentListenerDemo.showComponentListenerDemo();
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
   private void showComponentListenerDemo(){
      headerLabel.setText("Listener in action: ComponentListener");      
   
      JPanel panel = new JPanel();      
      panel.setBackground(Color.magenta);            

      JLabel msglabel = 
      new JLabel("Welcome to TutorialsPoint SWING Tutorial.",JLabel.CENTER);        
      panel.add(msglabel);
	
      msglabel.addComponentListener(new CustomComponentListener());     
      
      controlPanel.add(panel);
      mainFrame.setVisible(true);  
      
      try {
  		Thread.sleep(4000);
  	} catch (InterruptedException e) {
  		// TODO Auto-generated catch block
  		e.printStackTrace();
  	}
      
      msglabel.hide();// .setHorizontalTextPosition(500);
   }
   class CustomComponentListener implements ComponentListener {
      public void componentResized(ComponentEvent e) {
         statusLabel.setText(statusLabel.getText() 
            + e.getComponent().getClass().getSimpleName() + " resized. ");
      }
      public void componentMoved(ComponentEvent e) {
         statusLabel.setText(statusLabel.getText() 
            + e.getComponent().getClass().getSimpleName() + " moved. ");
      }
      public void componentShown(ComponentEvent e) {
         statusLabel.setText(statusLabel.getText() 
            + e.getComponent().getClass().getSimpleName() + " shown. ");
      }
      public void componentHidden(ComponentEvent e) {
         statusLabel.setText(statusLabel.getText() 
            + e.getComponent().getClass().getSimpleName() + " hidden. ");
      }
   }
}