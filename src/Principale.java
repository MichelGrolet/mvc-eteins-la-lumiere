import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;

public class Principale {
	public static void main(String[] args) {
		//Creation des vues
		VueBoutons vueBoutons = new VueBoutons();
		VueTerrain vueTerrain = new VueTerrain();

		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(new BorderLayout());
		f.add(vueBoutons, BorderLayout.WEST);
		f.add(vueTerrain, BorderLayout.CENTER);
		f.pack();
		f.setVisible(true);
	}
}
