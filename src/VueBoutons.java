import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JPanel;

public class VueBoutons extends JPanel implements Observer {

	public VueBoutons() {
		JButton configurer = new JButton("Configurer");
		JButton aleatoire = new JButton("Aleatoire");
		JButton jouer = new JButton("Jouer");
		JButton vide = new JButton();
		JButton quitter = new JButton("Quitter");

		this.setLayout(new GridLayout(1, 5));

		this.add(configurer);
		this.add(aleatoire);
		this.add(jouer);
		this.add(vide);
		this.add(quitter);
	}

	@Override
	public void update(Observable o, Object arg) {
		
	}
}
