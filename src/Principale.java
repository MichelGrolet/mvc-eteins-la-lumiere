import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;

public class Principale {
	public static void main(String[] args) {
		//Creation du modele
		Terrain modele = new Terrain();

		//Creation des vues
		VueBoutons vueBoutons = new VueBoutons();
		modele.addObserver(vueBoutons);
		VueTerrain vueTerrain = new VueTerrain(modele);
		modele.addObserver(vueTerrain);

		//Creation des controleurs
		ControlleurBoutons controlleurBoutons = new ControlleurBoutons(vueBoutons, modele);
		ControlleurTerrain controlleurTerrain = new ControlleurTerrain(vueBoutons, modele);


		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(new BorderLayout());
		f.add(vueBoutons, BorderLayout.WEST);
		f.add(vueTerrain, BorderLayout.CENTER);
		f.pack();
		f.setVisible(true);
	}
}
