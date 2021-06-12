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
		// Les boutons seront dans une grille a une colonne
		this.setLayout(new GridLayout(5, 1, 50, 50));
		this.setPreferredSize(new Dimension(200, 500));
		this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

		// Creation des boutons
		configurer = new JButton("Configurer");
		aleatoire = new JButton("Aleatoire");
		jouer = new JButton("Jouer");
		quitter = new JButton("Quitter");

		//Creation du JLabel
		mouvements = new JLabel("Clics : 0", JLabel.CENTER);
		mouvements.setFont(new Font("Verdana", Font.PLAIN, 20));

		setBouton(configurer, true);
		setBouton(aleatoire, true);
		this.add(mouvements);
		setBouton(jouer, false);
		setBouton(quitter, false);
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

	/**
	 * Appelle les fonctions de base pour les boutons
	 * @param b bouton a initialiser
	 * @param actif definit si le bouton doit etre actif ou non
	 */
	public void setBouton(JButton b, boolean actif) {
		b.setFont(new Font("Verdana", Font.PLAIN, 13));
		setActif(b, actif);
		// Ajout du bouton au panel
		this.add(b);
	}

	public void setActif(JButton b, boolean actif) {
		this.setEnabled(actif);
		if (actif) {
			b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			b.setBackground(Color.decode("#F0B90B"));
		} else {
			b.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			b.setBackground(Color.decode("#FFFFFF"));
		}
	}
}
