package listenerInterface;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class UppercaseText implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		//String text = ListenerInterface2Buttons.getTf1Text();
		//ListenerInterface2Buttons.setTf2Text(text.toUpperCase());
		//System.out.println(text);
		
	}

	@Override
	public void mousePressed(MouseEvent e) { 							// It listens mousePressed
		String text = ListenerInterface2Buttons.getTf1Text();			//  & it Acts with the following statements
		ListenerInterface2Buttons.setTf2Text(text.toUpperCase());
		System.out.println(text);
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
