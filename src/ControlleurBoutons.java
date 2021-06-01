import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlleurBoutons {

	private final VueBoutons vue;

	private final Terrain modele;

    /**
     * Ajoute les listeners sur les boutons.
     * @param vue VueBoutons sur laquelle on ajoute les listeners.
     * @param modele Terrain
     */
	public ControlleurBoutons(VueBoutons vue, Terrain modele) {
	    this.vue = vue;
	    this.modele = modele;
	    vue.getConfigurer().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        vue.getAleatoire().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        vue.getJouer().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        vue.getQuitter().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
