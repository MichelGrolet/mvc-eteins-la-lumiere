import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

/**
* Classe qui controle les boutons
*/

public class ControleurBoutons {
    /**
    * Vue de boutons correspondant
    */
	private final VueBoutons vueBoutons;

    /**
    * Le terrain de lampes
    */
	private final Terrain modele;

    /**
     * Ajoute les listeners sur les boutons.
     * @param vueBoutons VueBoutons sur laquelle on ajoute les listeners.
     * @param modele Terrain
     */
	public ControleurBoutons(VueBoutons vueBoutons,Terrain modele) {
	    this.vueBoutons = vueBoutons;
        this.modele=modele;
        // CONFIGURER
        vueBoutons.getConfigurer().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!modele.modeValeur("jeu") && !modele.modeValeur("gagne")){
                modele.setMode("configuration");
                modele.zeroClic();
                vueBoutons.setBouton(vueBoutons.getJouer(), true);
                vueBoutons.setBouton(vueBoutons.getQuitter(), true);
                }
            }
        });
        // ALEATOIRE
        vueBoutons.getAleatoire().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!modele.modeValeur("jeu") && !modele.modeValeur("gagne")){
                modele.setMode("configuration");
                modele.aleaLampe();
                modele.zeroClic();
                vueBoutons.setBouton(vueBoutons.getJouer(), true);
                vueBoutons.setBouton(vueBoutons.getQuitter(), true);
                }
            }
        });
        // JOUER
        vueBoutons.getJouer().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!modele.modeValeur("inactif")){
                    modele.cGagne();
                    modele.setMode("jeu");
                    vueBoutons.setBouton(vueBoutons.getJouer(), false);
                    vueBoutons.setBouton(vueBoutons.getQuitter(), true);
                    modele.demarrerCompteur();
                    vueBoutons.getConfigurer().setBackground(Color.decode("#DDDDDD"));
                    vueBoutons.getAleatoire().setBackground(Color.decode("#DDDDDD"));
                }
            }
        });
        // QUITTER
        vueBoutons.getQuitter().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!modele.modeValeur("inactif")){
                    modele.reinitialiser();
                    modele.setMode("inactif");
                    modele.zeroClic();
                    vueBoutons.setBouton(vueBoutons.getJouer(), false);
                    vueBoutons.setBouton(vueBoutons.getQuitter(), false);
                    vueBoutons.getConfigurer().setBackground(Color.decode("#F0B90B"));
                    vueBoutons.getAleatoire().setBackground(Color.decode("#F0B90B"));
                }
            }
        });
    }
}
