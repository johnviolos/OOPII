package listenerInterface;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FilterText implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		String text = ListenerInterface2Buttons.getTf1Text();
		ListenerInterface2Buttons.setTf2Text(text.replace("o", "0").replace("a", "4").replace("i", "1").replace("I", "1").replace("A", "4").replace("O", "0")); //.setTf2(tf2   );tf2.setText(text.toUpperCase());
		
		// TODO Auto-generated method stub
		
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
