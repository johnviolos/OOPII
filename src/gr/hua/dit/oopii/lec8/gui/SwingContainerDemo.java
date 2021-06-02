package gr.hua.dit.oopii.lec8.gui;
//slide 19

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;

public class SwingContainerDemo {
   private JFrame mainFrame;
   private JPanel controlPanel;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JLabel msglabel;

   public SwingContainerDemo(){		//Prepare the GUI by the constructor.
      prepareGUI();
   }
   public static void main(String[] args){
      SwingContainerDemo  swingContainerDemo = new SwingContainerDemo();  
      swingContainerDemo.showJPanelDemo();
   }
   private void prepareGUI(){											//The constructor creates the JPanel & JLabel objects 
      mainFrame = new JFrame("Java Swing Examples");
      mainFrame.setSize(400,400);
      mainFrame.setLayout(new GridLayout(3, 1));						//The Frame will have three 3 items inside in a grid (3,1). The Frame will have one panel and two labels.
      
      mainFrame.addWindowListener(new WindowAdapter() {					//We added a Listener in the mainFrame which extends the WindowAdapter class.
         public void windowClosing(WindowEvent windowEvent){			//It takes as argument an Anonymous Inner Class.
            System.exit(0);												//It also override the method windowClossing
         }        														//So we add functionality on the fly with a class that will be used only one time.
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
   private void showJPanelDemo(){									//The method showJPanelDemo() assign values and content to these components.
      headerLabel.setText("Container in action: JPanel");      		//The headerLabel and the controlPane exist as class attributes but in this method they will be assigned to concrete objects.
      JPanel panel = new JPanel();
      panel.setBackground(Color.magenta);
      panel.setLayout(new FlowLayout());        
      panel.add(msglabel);
      BevelBorder bb = new BevelBorder (BevelBorder.RAISED);		//Here, we create a Border
      controlPanel.setBorder(bb);									//and set the border to the controlPanel.
      controlPanel.add(panel);        								//The controlPanel also takes as argument the panel which is a JPanel.
      mainFrame.setVisible(true);      
   }   
}