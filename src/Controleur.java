import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class Controleur {

	private final VueBoutons vueBoutons;

	private final VueTerrain vueTerrain;

	private final Terrain modele;

    /**
     * Ajoute les listeners sur les boutons.
     * @param vue VueBoutons sur laquelle on ajoute les listeners.
     * @param modele Terrain
     */
	public Controleur(VueBoutons vueBoutons, VueTerrain vueTerrain, Terrain modele) {
	    this.vueBoutons = vueBoutons;
        this.vueTerrain = vueTerrain;
	    this.modele = modele;
        vueBoutons.getConfigurer().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        vueBoutons.getAleatoire().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modele.aleaLampe();
                vueBoutons.getQuitter().setEnabled(true);
                vueBoutons.getJouer().setEnabled(true);
            }
        });
        vueBoutons.getJouer().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        vueBoutons.getQuitter().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public void mouseClicked(MouseEvent e){
        modele.changeLampe(e.getX(),e.getY());
    }
}
