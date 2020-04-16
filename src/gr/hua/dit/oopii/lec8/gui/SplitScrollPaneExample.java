package gr.hua.dit.oopii.lec8.gui;

import java.awt.FlowLayout;

import javax.swing.*; 
class SplitScrollPaneExample extends JFrame { 
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		
		//scrollpane();
		splitPaneMethod();
	}
	
	public static void splitPaneMethod()  { 
		JFrame f; 
		f = new JFrame("frame"); 
		JSplitPane split =new JSplitPane( JSplitPane.HORIZONTAL_SPLIT, new JButton("Click Here"), new JButton("and Here"));
		f.add(split);
		f.setSize(400, 100); 
		f.setVisible(true);  
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	} 
	
	
	public static void scrollpane() {
		final JFrame frame = new JFrame("Scroll Pane Example");
		 
        // Display the window.
        frame.setSize(200, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        // set flow layout for the frame
        frame.getContentPane().setLayout(new FlowLayout());
 
        JTextArea textArea = new JTextArea(5, 5);
        textArea.setText(sonnet);
        textArea.setVisible(true);
        JScrollPane scrollableTextArea = new JScrollPane(textArea);
        scrollableTextArea.setFocusable(true);
        scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
 
        frame.getContentPane().add(scrollableTextArea);
 
	}
private static String sonnet="Shall I compare thee to a summer's day?\n" + 
		"Thou art more lovely and more temperate:\n" + 
		"Rough winds do shake the darling buds of May,\n" + 
		"And summer's lease hath all too short a date:\n" + 
		"Sometime too hot the eye of heaven shines,\n" + 
		"And often is his gold complexion dimm'd;\n" + 
		"And every fair from fair sometime declines,\n" + 
		"By chance, or nature's changing course, untrimm'd;\n" + 
		"But thy eternal summer shall not fade\n" + 
		"Nor lose possession of that fair thou ow'st;\n" + 
		"Nor shall Death brag thou wander'st in his shade,\n" + 
		"When in eternal lines to time thou grow'st;\n" + 
		"So long as men can breathe or eyes can see,\n" + 
		"So long lives this, and this gives life to thee.";
} 

