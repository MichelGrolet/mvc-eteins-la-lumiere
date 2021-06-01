import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class VueTerrain extends JPanel implements Observer {


	private Terrain t;

	public VueTerrain(Terrain t) {
		this.t = t;
		this.setPreferredSize(new Dimension(500, 500));
		this.setLayout(new GridLayout(5, 5));

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
