import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class VueTerrain extends JPanel implements Observer {

	public VueTerrain() {

	}

	@Override
	public void update(Observable o, Object arg) {
		
	}

	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
    }
	
}
