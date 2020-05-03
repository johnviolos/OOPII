package gr.hua.dit.oopii.lec9.events;
//slide 75
import java.awt.*;
import java.awt.event.*;
import java.util.Date;

import javax.swing.*;

public class ActionListenerDemo {
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;

   public ActionListenerDemo(){
      prepareGUI();
   }
   public static void main(String[] args){
      ActionListenerDemo  actionListenerDemo = new ActionListenerDemo();  
      actionListenerDemo.showActionListenerDemo();
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
   private void showActionListenerDemo(){
      headerLabel.setText("Listener in action: ActionListener");      

      JPanel panel = new JPanel();      
      panel.setBackground(Color.magenta);            
      JButton okButton = new JButton("OK");

      okButton.addActionListener(new CustomActionListener());       //The object can be registered using the addActionListener() method.    
      panel.add(okButton);											//When the action event occurs, that object's actionPerformed method is invoked.
      controlPanel.add(panel);
      mainFrame.setVisible(true); 
   }
   class CustomActionListener implements ActionListener{			//When the action event occurs, that object's actionPerformed method is invoked.
      public void actionPerformed(ActionEvent e) {					//ActionEvent should implement this interface.
    	  Date dt = new Date(e.getWhen());							//The object ActionEvent has properties. 
    	  statusLabel.setText("Ok Button Clicked: "+dt);			//When the AL catches the event it sets a text to the label: statusLabel.
      
      
      }
   }	
}