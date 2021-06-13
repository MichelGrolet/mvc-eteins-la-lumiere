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

	/**
    * Les differents boutons (configurer, aleatoire, jouer, quitter)
    */
	private JButton configurer, aleatoire, jouer, quitter;

	/**
    * Affichage du nombre de clics
    */
	private JLabel mouvements;

	/**
    * Le terrain de lampes
    */
	private Terrain t;

	/**
	* Constructeur vide de la vue
	*/
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

		//On ajoute les elements
		setBouton(configurer, true);
		setBouton(aleatoire, true);
		this.add(mouvements);
		setBouton(jouer, false);
		setBouton(quitter, false);
	}

	/**
	 * Met a jour le nombre de deplacements
	 * @param o un observer
	 * @param arg un objet
	 */
	@Override
	public void update(Observable o, Object arg) {
		this.t = (Terrain) o;
		mouvements.setText("Clics : "+t.getNbClic());
	}

	/**
	 * Retourne le bouton aleatoire
	 * @return un JButton
	 */
	public JButton getAleatoire() {
		return aleatoire;
	}

	/**
	 * Retourne le bouton configurer
	 * @return un JButton
	 */
	public JButton getConfigurer() {
		return configurer;
	}

	/**
	 * Retourne le bouton jouer
	 * @return un JButton
	 */
	public JButton getJouer() {
		return jouer;
	}

	/**
	 * Retourne le bouton quitter
	 * @return un JButton
	 */
	public JButton getQuitter() {
		return quitter;
	}

	/**
	 * Retourne le label des clics
	 * @return un JLabel
	 */
	public JLabel getMouvements() {
		return mouvements;
	}

	/**
	 * Retourne le modele
	 * @return un Terrain
	 */
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

	/**
	 * Change l'etat d'un bouton
	 * @param b bouton a changer
	 * @param actif definit si le bouton doit etre actif ou non
	 */
	public void setActif(JButton b, boolean actif) {
		this.setEnabled(actif);
		if (actif) {
			b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			b.setBackground(Color.decode("#F0B90B"));
		} else {
			b.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			b.setBackground(Color.decode("#DDDDDD"));
		}
	}
}
