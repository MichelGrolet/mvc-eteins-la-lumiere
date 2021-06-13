import javax.swing.*;
import java.awt.BorderLayout;

/**
* Classe principale, lance le jeu
*/

public class Principale {
	/**
	* Lance le jeu
	* @param args le tableau d'arguments
	*/
	public static void main(String[] args) {
		//Creation du modele
		Terrain modele = new Terrain();

		//Creation des vues
		VueBoutons vueBoutons = new VueBoutons();
		modele.addObserver(vueBoutons);
		VueTerrain vueTerrain = new VueTerrain(modele);
		modele.addObserver(vueTerrain);

		//Creation du controleur
		ControleurTerrain controleurTerrain = new ControleurTerrain(modele);
		ControleurBoutons controleurBoutons = new ControleurBoutons(vueBoutons,  modele);
		vueTerrain.addMouseListener(controleurTerrain);

		//Creation du JFrame
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(new BorderLayout());
		f.add(vueBoutons, BorderLayout.WEST);
		f.add(vueTerrain, BorderLayout.CENTER);
		f.pack();
		f.setVisible(true);
	}
}
