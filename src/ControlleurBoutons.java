import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlleurBoutons {

	private final VueBoutons vue;

    /**
     * Ajoute les listeners sur les boutons.
     * @param vue VueBoutons su laquelle on ajoute les listeners.
     */
	public ControlleurBoutons(VueBoutons vue) {
	    this.vue = vue;
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
