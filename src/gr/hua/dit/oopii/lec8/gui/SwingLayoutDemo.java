package gr.hua.dit.oopii.lec8.gui;
//slide 24

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SwingLayoutDemo {
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;
   private JLabel msglabel;

   public SwingLayoutDemo(){
      prepareGUI();
   }
   public static void main(String[] args){
      SwingLayoutDemo swingLayoutDemo = new SwingLayoutDemo();  
      swingLayoutDemo.showGridBagLayoutDemo();       
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
   private void showGridBagLayoutDemo(){
      headerLabel.setText("Layout in action: GridBagLayout");      

      JPanel panel = new JPanel();
      panel.setBackground(Color.darkGray);
      panel.setSize(300,300);
      GridBagLayout layout = new GridBagLayout();

      panel.setLayout(layout);        
      GridBagConstraints gbc = new GridBagConstraints();

      gbc.fill = GridBagConstraints.HORIZONTAL;
      gbc.gridx = 0;
      gbc.gridy = 0;
      panel.add(new JButton("Button 1"),gbc);

      gbc.gridx = 1;
      gbc.gridy = 0;
      panel.add(new JButton("Button 2"),gbc); 

      gbc.fill = GridBagConstraints.HORIZONTAL;
      gbc.ipady = 20;   
      gbc.gridx = 0;
      gbc.gridy = 1;
      panel.add(new JButton("Button 3"),gbc); 

      gbc.gridx = 1;
      gbc.gridy = 1;       
      panel.add(new JButton("Button 4"),gbc);  

      gbc.gridx = 0;
      gbc.gridy = 2;      
      gbc.fill = GridBagConstraints.HORIZONTAL;
      gbc.gridwidth = 2;
      panel.add(new JButton("Button 5"),gbc);  

      controlPanel.add(panel);
      mainFrame.setVisible(true);  
   }
}