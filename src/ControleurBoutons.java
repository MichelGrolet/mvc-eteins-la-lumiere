import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControleurBoutons {

	private final VueBoutons vueBoutons;

	private final VueTerrain vueTerrain;

	private final Terrain modele;

    /**
     * Ajoute les listeners sur les boutons.
     * @param vueBoutons VueBoutons sur laquelle on ajoute les listeners.
     * @param vueTerrain
     * @param modele Terrain
     */
	public ControleurBoutons(VueBoutons vueBoutons, VueTerrain vueTerrain, Terrain modele) {
	    this.vueBoutons = vueBoutons;
        this.vueTerrain = vueTerrain;
	    this.modele = modele;
        // CONFIGURER
        vueBoutons.getConfigurer().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modele.setMode("configuration");
                vueBoutons.setBouton(vueBoutons.getQuitter(), true);
                vueBoutons.setBouton(vueBoutons.getJouer(), true);
            }
        });
        // ALEATOIRE
        vueBoutons.getAleatoire().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modele.setMode("configuration");
                modele.aleaLampe();
                vueBoutons.setBouton(vueBoutons.getQuitter(), true);
                vueBoutons.setBouton(vueBoutons.getJouer(), true);
            }
        });
        // JOUER
        vueBoutons.getJouer().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modele.setMode("jeu");
                vueBoutons.setBouton(vueBoutons.getJouer(), false);
            }
        });
        // QUITTER
        vueBoutons.getQuitter().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modele.reinitialiser();
                modele.setMode("inactif");
                vueBoutons.setBouton(vueBoutons.getQuitter(), false);
                vueBoutons.setBouton(vueBoutons.getJouer(), false);
            }
        });
    }
}
