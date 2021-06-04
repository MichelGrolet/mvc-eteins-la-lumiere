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
		mouvements = new JLabel(" Clics : 0");
		mouvements.setFont(new Font("Verdana", Font.PLAIN, 20));
		quitter = new JButton("Quitter");

		configurer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		aleatoire.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jouer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		quitter.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		configurer.setFont(new Font("Verdana", Font.PLAIN, 15));
		aleatoire.setFont(new Font("Verdana", Font.PLAIN, 15));
		jouer.setFont(new Font("Verdana", Font.PLAIN, 15));
		quitter.setFont(new Font("Verdana", Font.PLAIN, 15));
		quitter.setBackground(Color.decode("#F0B90B"));
		jouer.setEnabled(false);
		quitter.setEnabled(false);

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
		mouvements.setText("Clics : "+t.getNbClic());
	}

	public void ToggleBouton(JButton bouton) {
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
