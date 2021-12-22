package gr.hua.dit.oopii.lec8.gui;
import javax.swing.ImageIcon;
//slide 14
//slide 33
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.WindowConstants;

public class JFrameExample {
	public static void main(String[] args) {
		//setVisible(true);
		JFrame f = new JFrame("Frame title"); 
		JPanel p = new JPanel( );
		JButton b = new JButton("press me");
		p.add(b);
		f.setContentPane(p);
		
		JMenuBar menuBar = new JMenuBar();

	    JMenu menu = new JMenu("File");
	    menuBar.add(menu);
	    JMenuItem menuItem1 = new JMenuItem(" Save");
	    JMenuItem menuItem2 = new JMenuItem(" Load");
	    JMenuItem menuItem3 = new JMenuItem(" Open");
	    JMenuItem menuItem4 = new JMenuItem(" Print");
	    JMenuItem menuItem5 = new JMenuItem(" Exit");
	    menu.add(menuItem1);	   
	    menu.add(menuItem2);
	    menu.add(menuItem3);
	    menu.add(menuItem4);
	    menu.add(menuItem5);
	    
	    JMenu menu2 = new JMenu("Help");
	    menuBar.add(menu2);
	    JMenuItem menuItem6 = new JMenuItem("Help");
	    JMenuItem menuItem7 = new JMenuItem("About");
	    JMenuItem menuItem8 = new JMenuItem("Search");

	    menu2.add(menuItem6);	   
	    menu2.add(menuItem7);
	    menu2.add(menuItem8);
	    
	    JMenu check = new JMenu("Check"); 
	    menuBar.add(check);
	    check.add(new JCheckBoxMenuItem("Option 1")); 
	    check.add(new JSeparator());
	    check.add(new JCheckBoxMenuItem("Option 2", true));
	    
		f.setJMenuBar(menuBar);	//Sets the menubar for this frame.
		
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //Closing the frame, it also close the application.
		
		//f.setBounds(120,120,300,300);	//Moves and resizes this component. The new location of the top-left corner is specified by x and y, and the new size is specified by width and height.
		f.setLocation(50, 100);
		f.setSize(400, 200);
		f.isActive();		
		f.setVisible(true);
		
	}		

}
