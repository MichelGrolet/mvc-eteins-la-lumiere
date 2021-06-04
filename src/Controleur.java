import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controleur implements MouseListener {

	private final VueBoutons vueBoutons;

	private final VueTerrain vueTerrain;

	private final Terrain modele;

	private String mode = "inactif";

    /**
     * Ajoute les listeners sur les boutons.
     * @param vueBoutons VueBoutons sur laquelle on ajoute les listeners.
     * @param vueTerrain
     * @param modele Terrain
     */
	public Controleur(VueBoutons vueBoutons, VueTerrain vueTerrain, Terrain modele) {
	    this.vueBoutons = vueBoutons;
        this.vueTerrain = vueTerrain;
	    this.modele = modele;
	    // CONFIGURER
        vueBoutons.getConfigurer().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controleur.this.mode = "configuration";
            }
        });
        // ALEATOIRE
        vueBoutons.getAleatoire().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modele.aleaLampe();
                vueBoutons.getQuitter().setEnabled(true);
                vueBoutons.getJouer().setEnabled(true);
            }
        });
        // JOUER
        vueBoutons.getJouer().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controleur.this.mode = "jeu";
            }
        });
        // QUITTER
        vueBoutons.getQuitter().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modele.reinitialiser();
            }
        });
    }

    public void mouseClicked(MouseEvent e){

    }

    @Override
    public void mousePressed(MouseEvent e) {
	    int x = e.getX();
	    int y = e.getY();
	    if (this.mode.equals("configuration")) modele.configLampe(x, y);
        else if (this.mode.equals("jeu")) modele.changeLampe(x, y);
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
