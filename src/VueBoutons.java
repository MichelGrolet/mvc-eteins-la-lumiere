import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Classe gerant l'affichage des boutons
 */
public class VueBoutons extends JPanel implements Observer {

	private JButton configurer, aleatoire, jouer, quitter;
	private JLabel mouvements;
	private Terrain t;

	public VueBoutons() {
		// Creation des boutons
		configurer = new JButton("Configurer");
		aleatoire = new JButton("Aleatoire");
		jouer = new JButton("Jouer");
		mouvements = new JLabel(" Deplacements : 0");
		mouvements.setFont(new Font("Verdana", Font.PLAIN, 20));
		quitter = new JButton("Quitter");

		jouer.setBorderPainted(false);
		jouer.setFocusPainted(false);
		quitter.setBorderPainted(false);
		quitter.setFocusPainted(false);

		// Les boutons seront dans une grille a une colonne
		this.setLayout(new GridLayout(5, 1));
		this.setPreferredSize(new Dimension(200, 500));

		// Ajout des boutons au panel
		this.add(configurer);
		this.add(aleatoire);
		this.add(jouer);
		this.add(mouvements);
		this.add(quitter);
	}

	/**
	 * Met a jour le nombre de deplacements
	 * @param o
	 * @param arg
	 */
	@Override
	public void update(Observable o, Object arg) {
		this.t = (Terrain) o;
		//mouvements.setText("Deplacements : "+t.getNbClics());
	}

	public void ToggleBouton(JButton bouton) {
		if (bouton.)
		jouer.setBorderPainted(false);
		jouer.setFocusPainted(false);
	}

	public JButton getAleatoire() {
		return aleatoire;
	}

	public JButton getConfigurer() {
		return configurer;
	}

	public JButton getJouer() {
		return jouer;
	}

	public JButton getQuitter() {
		return quitter;
	}

	public JLabel getMouvements() {
		return mouvements;
	}

	public Terrain getT() {
		return t;
	}
}
