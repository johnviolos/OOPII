package gr.hua.dit.oopii.lec8.gui;
//slide 8
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Label;
import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.CardLayout;
import javax.swing.JFrame;

public class LayOutExamples {
public static void main(String[] args) {
	//FlowLayoutExample a = new FlowLayoutExample();
	//BorderLayoutExample a = new BorderLayoutExample();
    GridLayoutExample a = new GridLayoutExample();
    //GridBagLayoutExample a = new GridBagLayoutExample();
    //CardLayoutExample a = new CardLayoutExample();   
}

public static class FlowLayoutExample extends JFrame {

    public FlowLayoutExample() {

        setVisible(true);							//Shows or hides this Window depending on the value of parameter
        setDefaultCloseOperation(EXIT_ON_CLOSE);	//the operation which should be performed when the user closes the frame

        FlowLayout g = new FlowLayout();			//Constructs a new FlowLayout with a centered alignment and a default 5-unit horizontal and vertical gap
        setLayout(g);								//Sets the layout manager for this container.
        setTitle("Flow Layout");
        setSize(600, 300);
        Button bt1= new Button("Button 1");
       
        add(new Button("Button 1"));
        add(new Button("Button 2"));
        add(new Button("Button 3"));
        add(new Button("Button 4"));
        add(new Button("Button 5"));
        add(new Button("Button 6"));
    }
}

public static class BorderLayoutExample extends JFrame {
    public BorderLayoutExample() {

        setVisible(true);								//Shows or hides this Window depending on the value of parameter
        setDefaultCloseOperation(EXIT_ON_CLOSE); 		//the operation which should be performed when the user closes the frame

        BorderLayout b = new BorderLayout();			//Constructs a new border layout with no gaps between components.
        setTitle("Border Layout");						//Sets the title for this frame to the specified string.

        setSize(300, 300);								//Resizes this component so that it has width width and height height.
        add(new Button("North"), BorderLayout.NORTH);	//Adds the specified component to the end of this container
        add(new Button("South"), BorderLayout.SOUTH);
        add(new Button("East"), BorderLayout.EAST);
        add(new Button("West"), BorderLayout.WEST);
        add(new Button("Center"), BorderLayout.CENTER);
    }
}

public static class GridLayoutExample extends JFrame {
public  GridLayoutExample() {

    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    GridLayout g = new GridLayout(3, 2);
    setLayout(g);
    setTitle("Grid Layout");
    setSize(300, 300);
    add(new Button("Button 1"));
    add(new Button("Button 2"));
    add(new Button("Button 3"));
    add(new Button("Button 4"));
    add(new Button("Button 5"));
    add(new Button("Button 6"));

}
}

public static class GridBagLayoutExample extends JFrame {
    public GridBagLayoutExample() {
        setSize(300, 300);
        setPreferredSize(getSize());
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        GridBagLayout g = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(g);
        setTitle("GridBag Layout");

        GridBagLayout layout = new GridBagLayout();

        this.setLayout(layout);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(new Button("Button 1"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        this.add(new Button("Button 2"), gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 20;
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(new Button("Button 3"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        this.add(new Button("Button 4"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        this.add(new Button("Button 5"), gbc);

    }
}

public static class CardLayoutExample extends JFrame {


    public CardLayoutExample() {

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        CardLayout g = new CardLayout();
        setLayout(g);
        setTitle("Card Layout");

        setSize(300, 300);
        add(new Button("Button 1"));
        add(new Button("Button 2"));
        add(new Button("Button 3"));
        add(new Button("Button 4"));
        add(new Button("Button 5"));
        add(new Button("Button 6"));

    }
}


}
