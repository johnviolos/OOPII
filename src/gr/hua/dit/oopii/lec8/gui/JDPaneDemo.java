package gr.hua.dit.oopii.lec8.gui;
//slide 28
import java.awt.BorderLayout;  
import java.awt.Container;  
import javax.swing.JDesktopPane;  
import javax.swing.JFrame;  
import javax.swing.JInternalFrame;  
import javax.swing.JLabel;  
public class JDPaneDemo extends JFrame  
{  
  public JDPaneDemo()   
  {  
    CustomDesktopPane desktopPane = new CustomDesktopPane();  
    Container contentPane = getContentPane();  
    contentPane.add(desktopPane, BorderLayout.CENTER);  
    desktopPane.display(desktopPane);  
  
    setTitle("JDesktopPane CloneList");  
    setSize(300,350);  
    setVisible(true);  
  }  
  public static void  main(String args[])  
  {  
    new JDPaneDemo();  
  }  
}  
class CustomDesktopPane extends JDesktopPane  
{  
  int numFrames = 3,  x = 30, y = 30;  
  public void display(CustomDesktopPane dp)   
  {  
    for(int  i = 0; i < numFrames ; ++i )   
    {  
      JInternalFrame jframe = new JInternalFrame("Internal Frame " + i ,  true, true, true, true);  //We create the three Internal Frames (windows)
  
      jframe.setBounds(x, y, 250, 85);  
     Container c1 = jframe.getContentPane( ) ;  
     c1.add(new JLabel("I love my country"));  
     dp.add( jframe );  
     jframe.setVisible(true);         
     y += 85;  
    }  
  }  
} 