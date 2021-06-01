import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;

public class ControleurTerrain extends MouseInputAdapter {

    private VueTerrain vue;

    private Terrain modele;

    /**
     *
     * @param vue VueTerrain sur laquelle on ajoute les listeners.
     * @param modele Terrain
     */
    public ControleurTerrain(VueTerrain vue, Terrain modele) {
        this.vue = vue;
        this.modele = modele;
    }

    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        modele.changeLampe(x, y);
    }
}
