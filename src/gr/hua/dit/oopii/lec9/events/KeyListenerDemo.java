package gr.hua.dit.oopii.lec9.events;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KeyListenerDemo {
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;

   public KeyListenerDemo(){
      prepareGUI();
   }
   public static void main(String[] args){
      KeyListenerDemo  keyListenerDemo = new KeyListenerDemo();  
      keyListenerDemo.showKeyListenerDemo();
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
   private JTextField textField;
   private void showKeyListenerDemo(){
      headerLabel.setText("Listener in action: KeyListener");      
      textField  = new JTextField(10);								//2 different Listeners that will take input from the same text field and make different processing
      textField.addKeyListener(new CustomKeyListener());			//1st Listener activated with Enter key as defines CustomKeyListener.
      JButton okButton = new JButton("OK");
      
      okButton.addActionListener(new ActionListener() {				//2nd Listener activated with Button click.
         public void actionPerformed(ActionEvent e) {
            statusLabel.setText("Entered text with button ok: " + textField.getText());               //1st case 
         }
      });
      controlPanel.add(textField);
      controlPanel.add(okButton);    
      mainFrame.setVisible(true);  
   }
   class CustomKeyListener implements KeyListener{				//1st Listener activated with Enter key as defines CustomKeyListener.
      public void keyTyped(KeyEvent e) {
      }
      public void keyPressed(KeyEvent e) {
         if(e.getKeyCode() == KeyEvent.VK_ENTER){
            statusLabel.setText("Entered text with textField enter: " + textField.getText());		//2nd case 
         }
      }
      public void keyReleased(KeyEvent e) {
      }   
   }
}