import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControleurBoutons {

	private final VueBoutons vue;

	private final Terrain modele;

    /**
     * Ajoute les listeners sur les boutons.
     * @param vue VueBoutons sur laquelle on ajoute les listeners.
     * @param modele Terrain
     */
	public ControleurBoutons(VueBoutons vue, Terrain modele) {
	    this.vue = vue;
	    this.modele = modele;
	    vue.getConfigurer().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modele.aleaLampe();
            }
        });
        vue.getAleatoire().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modele.aleaLampe();
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
